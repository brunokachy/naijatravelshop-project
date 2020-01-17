package com.naijatravelshop.service.payment.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.naijatravelshop.persistence.model.crm.ServiceRequest;
import com.naijatravelshop.persistence.model.enums.*;
import com.naijatravelshop.persistence.model.payment.PaymentHistory;
import com.naijatravelshop.persistence.model.portal.Reservation;
import com.naijatravelshop.persistence.model.portal.ReservationOwner;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestRepository;
import com.naijatravelshop.persistence.repository.payment.PaymentHistoryRepository;
import com.naijatravelshop.persistence.repository.portal.ReservationOwnerRepository;
import com.naijatravelshop.persistence.repository.portal.ReservationRepository;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.service.payment.pojo.Request.BankPaymentDTO;
import com.naijatravelshop.service.payment.pojo.Request.FlwPaymentVerificationDTO;
import com.naijatravelshop.service.payment.pojo.Response.FlwAccountDetail;
import com.naijatravelshop.service.payment.service.PaymentService;
import com.naijatravelshop.web.constants.ProjectConstant;
import com.naijatravelshop.web.exceptions.BadRequestException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Bruno on
 * 18/05/2019
 */
@Service
public class PaymentServiceImpl implements PaymentService {

//    @Value("${payment_verify_endpoint}")
//    private String paymentVerifyEndpoint;
//
//    @Value("${secret_key}")
//    private String secretKey;

    private ReservationRepository reservationRepository;
    private ReservationOwnerRepository reservationOwnerRepository;
    private PaymentHistoryRepository paymentHistoryRepository;
    private SettingRepository settingRepository;
    private ServiceRequestRepository serviceRequestRepository;

    private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);


    public PaymentServiceImpl(ReservationRepository reservationRepository,
                              ReservationOwnerRepository reservationOwnerRepository,
                              PaymentHistoryRepository paymentHistoryRepository,
                              SettingRepository settingRepository,
                              ServiceRequestRepository serviceRequestRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationOwnerRepository = reservationOwnerRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.settingRepository = settingRepository;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    @Transactional
    public void savePaymentHistory(FlwPaymentVerificationDTO flwPaymentVerificationDTO, JSONObject responseObject, ProcessStatus processStatus) {

        Optional<Reservation> reservationOptional = reservationRepository
                .findFirstByBookingNumberEquals(flwPaymentVerificationDTO.getBookingNumber());
        if (reservationOptional.isPresent()) {
            Timestamp currentTime = new Timestamp(new Date().getTime());
            Reservation r = reservationOptional.get();
            r.setActualAmountInKobo(flwPaymentVerificationDTO.getAmount().longValue());
            r.setLastUpdated(currentTime);
            r.setDatePaid(currentTime);
            reservationRepository.save(r);

            Optional<ReservationOwner> ownerOptional = reservationOwnerRepository.findById(r.getReservationOwner().getId());

            PaymentHistory paymentHistory = new PaymentHistory();
            paymentHistory.setAmountInKobo(r.getActualAmountInKobo());
            paymentHistory.setAmountActualPaidInKobo(flwPaymentVerificationDTO.getAmount().longValue());
            paymentHistory.setPaymentDate(currentTime);
            paymentHistory.setStatus(EntityStatus.ACTIVE);
            paymentHistory.setPaymentStatus(processStatus);
            paymentHistory.setPayerEmail(ownerOptional.get().getEmail());
            paymentHistory.setPayerName(ownerOptional.get().getFirstName() + " " + ownerOptional.get().getLastName());
            paymentHistory.setPayerPhone(ownerOptional.get().getPhoneNumber());
            if (responseObject != null) {
                paymentHistory.setPaymentProviderResponseText(responseObject.optString("status", null));
            }
            paymentHistory.setPaymentReference(flwPaymentVerificationDTO.getPaymentRef());
            paymentHistory.setPaymentProviderResponseCode(flwPaymentVerificationDTO.getPaymentCode());
            paymentHistory.setPaymentChannel(PaymentChannel.WEB);
            paymentHistory.setPaymentProvider(PaymentProvider.FLUTTERWAVE_RAVEPAY);
            paymentHistory.setTransactionId(flwPaymentVerificationDTO.getFlwRef());
            paymentHistory.setReservation(r);
            paymentHistoryRepository.save(paymentHistory);
        }
    }

    @Override
    public void verifyFlwPayment(FlwPaymentVerificationDTO flwPaymentVerificationDTO) {
        Optional<Setting> paymentVerifyEndpoint = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
        Optional<Setting> secretKey = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_SECRET_KEY);

        try {
            // This packages the payload
            JSONObject data = new JSONObject();
            data.put("txref", flwPaymentVerificationDTO.getFlwRef());
            data.put("SECKEY", secretKey.get().getValue());
            // end of payload

            // This sends the request to server with payload
            HttpResponse<JsonNode> response = Unirest.post(paymentVerifyEndpoint.get().getValue())
                    .header("Content-Type", "application/json")
                    .body(data)
                    .asJson();

            // This get the response from payload
            JsonNode jsonNode = response.getBody();

            // This get the json object from payload
            JSONObject responseObject = jsonNode.getObject();

            log.info("VERIFICATION RESPONSE: {}", responseObject.toString());

            // check of no object is returned
            if (responseObject == null) {
                savePaymentHistory(flwPaymentVerificationDTO, responseObject, ProcessStatus.FAILED);
                throw new BadRequestException("No response from server");
            }

            // This get status from returned payload
            String status = responseObject.optString("status", null);

            // this ensures that status is not null
            if (status == null) {
                savePaymentHistory(flwPaymentVerificationDTO, responseObject, ProcessStatus.FAILED);
                throw new BadRequestException("Transaction status unknown");
            }

            // This confirms the transaction exist on rave
            if (!"success".equalsIgnoreCase(status)) {
                savePaymentHistory(flwPaymentVerificationDTO, responseObject, ProcessStatus.FAILED);
                String message = responseObject.optString("message", null);
                throw new BadRequestException(message);
            }

            try {
                data = responseObject.getJSONObject("data");
            } catch (JSONException e) {
                JSONArray dataArray = responseObject.getJSONArray("data");
                data = dataArray.getJSONObject(0);
            }

            // This get the amount stored on server
            double actualAmount = data.getDouble("amount");

            // This validates that the amount stored on client is same returned
            if (actualAmount != flwPaymentVerificationDTO.getAmount()) {
                savePaymentHistory(flwPaymentVerificationDTO, responseObject, ProcessStatus.FAILED);
                throw new BadRequestException("Amount does not match");
            }

            savePaymentHistory(flwPaymentVerificationDTO, responseObject, ProcessStatus.SUCCESSFUL);
            // now you can give value for payment.
        } catch (UnirestException ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

    @Override
    public void bankPayment(BankPaymentDTO bankPaymentDTO) {
        Optional<Reservation> reservationOptional = reservationRepository
                .findFirstByBookingNumberEquals(bankPaymentDTO.getBookingNumber());
        if (reservationOptional.isPresent()) {
            Timestamp currentTime = new Timestamp(new Date().getTime());
            Reservation reservation = reservationOptional.get();
            reservation.setActualAmountInKobo(reservation.getSellingPrice());
            reservation.setLastUpdated(currentTime);
            reservationRepository.save(reservation);

            Optional<ReservationOwner> ownerOptional = reservationOwnerRepository.findById(reservation.getReservationOwner().getId());

            PaymentHistory paymentHistory = new PaymentHistory();
            paymentHistory.setAmountInKobo(reservation.getActualAmountInKobo());
            paymentHistory.setAmountActualPaidInKobo(reservation.getActualAmountInKobo());
            paymentHistory.setStatus(EntityStatus.ACTIVE);
            paymentHistory.setPaymentStatus(ProcessStatus.PENDING);
            paymentHistory.setPayerEmail(ownerOptional.get().getEmail());
            paymentHistory.setPayerName(ownerOptional.get().getFirstName() + " " + ownerOptional.get().getLastName());
            paymentHistory.setPayerPhone(ownerOptional.get().getPhoneNumber());
            paymentHistory.setPaymentReference(RandomStringUtils.randomAlphabetic(6));
            paymentHistory.setPaymentChannel(PaymentChannel.BANK_PAYMENT);
            paymentHistory.setPaymentProvider(PaymentProvider.BANK);
            paymentHistory.setTransactionId(paymentHistory.getPaymentReference());
            paymentHistory.setReservation(reservation);
            paymentHistoryRepository.save(paymentHistory);

//            Optional<ServiceRequest> optionalServiceRequest = serviceRequestRepository.findByReservation(reservation);
//            if (optionalServiceRequest.isPresent()) {
//                ServiceRequest serviceRequest = optionalServiceRequest.get();
//                serviceRequest.setName(ServiceQueueName.FLIGHT_PENDING_PAYMENT);
//                serviceRequestRepository.save(serviceRequest);
//            }

        }
    }

    @Override
    public FlwAccountDetail getFlwAccountDetail() {
        Optional<Setting> secretKey = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_SECRET_KEY);
        Optional<Setting> publicKey = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PUBLIC_KEY);

        FlwAccountDetail flwAccountDetail = new FlwAccountDetail();
        flwAccountDetail.setPublicKey(publicKey.get().getValue());
        flwAccountDetail.setSecretKey(secretKey.get().getValue());

        return flwAccountDetail;
    }
}
