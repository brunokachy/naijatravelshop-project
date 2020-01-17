package com.naijatravelshop.service.visa.service.impl;

import com.naijatravelshop.persistence.model.crm.Customer;
import com.naijatravelshop.persistence.model.crm.ServiceRequest;
import com.naijatravelshop.persistence.model.crm.ServiceRequestActorHistory;
import com.naijatravelshop.persistence.model.crm.ServiceRequestLog;
import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.enums.Priority;
import com.naijatravelshop.persistence.model.enums.ReservationType;
import com.naijatravelshop.persistence.model.enums.ServiceQueueName;
import com.naijatravelshop.persistence.model.enums.ServiceTaskSubject;
import com.naijatravelshop.persistence.model.enums.ServiceTaskType;
import com.naijatravelshop.persistence.model.portal.Country;
import com.naijatravelshop.persistence.model.visa.VisaCountry;
import com.naijatravelshop.persistence.model.visa.VisaRequest;
import com.naijatravelshop.persistence.repository.crm.CustomerRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestActorHistoryRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestLogRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestRepository;
import com.naijatravelshop.persistence.repository.portal.CountryRepository;
import com.naijatravelshop.persistence.repository.portal.PortalUserRepository;
import com.naijatravelshop.persistence.repository.visa.VisaCountryRepository;
import com.naijatravelshop.persistence.repository.visa.VisaRequestRepository;
import com.naijatravelshop.service.email.EmailService;
import com.naijatravelshop.service.flight.pojo.request.VisaRequestDTO;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.visa.pojo.response.VisaCountryDTO;
import com.naijatravelshop.service.visa.service.VisaService;
import com.naijatravelshop.web.exceptions.BadRequestException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Bruno on
 * 04/11/2019
 */
@Service
public class VisaServiceImpl implements VisaService {
    private VisaCountryRepository visaCountryRepository;
    private CountryRepository countryRepository;
    private VisaRequestRepository visaRequestRepository;
    private CustomerRepository customerRepository;
    private ServiceRequestRepository serviceRequestRepository;
    private ServiceRequestActorHistoryRepository serviceRequestActorHistoryRepository;
    private ServiceRequestLogRepository serviceRequestLogRepository;
    private EmailService emailService;

    public VisaServiceImpl(
            VisaCountryRepository visaCountryRepository,
            CountryRepository countryRepository,
            VisaRequestRepository visaRequestRepository,
            CustomerRepository customerRepository,
            ServiceRequestRepository serviceRequestRepository,
            ServiceRequestActorHistoryRepository serviceRequestActorHistoryRepository,
            ServiceRequestLogRepository serviceRequestLogRepository, EmailService emailService
    ) {
        this.visaCountryRepository = visaCountryRepository;
        this.countryRepository = countryRepository;
        this.visaRequestRepository = visaRequestRepository;
        this.customerRepository = customerRepository;
        this.serviceRequestRepository = serviceRequestRepository;
        this.serviceRequestActorHistoryRepository = serviceRequestActorHistoryRepository;
        this.serviceRequestLogRepository = serviceRequestLogRepository;
        this.emailService = emailService;
    }

    private static final Logger log = LoggerFactory.getLogger(VisaServiceImpl.class);

    @Override
    public List<VisaCountryDTO> getAllVisaCountry() {
        List<VisaCountryDTO> visaCountryList = new ArrayList<>();

        for (VisaCountry visaCountry : visaCountryRepository.findAll()) {
            VisaCountryDTO visaCountryDTO = VisaCountryDTO.builder()
                    .name(visaCountry.getCountryName())
                    .id(visaCountry.getId())
                    .status(visaCountry.getStatus().getValue())
                    .build();
            visaCountryList.add(visaCountryDTO);
        }
        return visaCountryList;
    }

    @Override
    public List<VisaCountryDTO> getAllActiveVisaCountry() {
        List<VisaCountry> visaCountryList = visaCountryRepository.getAllByStatusEquals(EntityStatus.ACTIVE);
        return visaCountryList.stream().map(visaCountry -> VisaCountryDTO.builder()
                .name(visaCountry.getCountryName())
                .id(visaCountry.getId())
                .status(visaCountry.getStatus().getValue())
                .build()).collect(Collectors.toList());
    }

    @Override
    public VisaCountryDTO createVisaCountry(String countryName) {
        VisaCountry visaCountry = new VisaCountry();
        visaCountry.setCountryName(countryName);
        visaCountry.setStatus(EntityStatus.ACTIVE);

        visaCountryRepository.save(visaCountry);

        return VisaCountryDTO.builder()
                .name(countryName)
                .id(visaCountry.getId())
                .status(EntityStatus.ACTIVE.getValue())
                .build();
    }

    @Override
    public VisaCountryDTO updateVisaCountry(VisaCountryDTO visaCountryDTO) {
        VisaCountryDTO result;

        Optional<VisaCountry> optionalVisaCountry = visaCountryRepository.findById(visaCountryDTO.getId());

        if (optionalVisaCountry.isPresent()) {
            VisaCountry visaCountry = optionalVisaCountry.get();
            visaCountry.setCountryName(visaCountryDTO.getName());
            visaCountry.setStatus(EntityStatus.valueOf(visaCountryDTO.getStatus()));
            visaCountryRepository.save(visaCountry);
            result = VisaCountryDTO.builder()
                    .name(visaCountryDTO.getName())
                    .id(visaCountry.getId())
                    .status(EntityStatus.ACTIVE.getValue())
                    .build();
        } else {
            throw new BadRequestException("Could not find Visa Country");
        }
        return result;
    }

    @Override
    public ReservationResponseDTO createVisaRequest(VisaRequestDTO visaRequestDTO) {
        ReservationResponseDTO responseDTO = new ReservationResponseDTO();
        VisaRequest visaRequest = new VisaRequest();
        Optional<Country> optionalCountry;

        visaRequest.setProcessed(false);
        visaRequest.setMiddleName(visaRequestDTO.getMiddleName());
        visaRequest.setPassportNumber(visaRequestDTO.getPassportNumber());
        visaRequest.setRequestById(visaRequestDTO.getRequestById());
        visaRequest.setAdditionalInfo(visaRequestDTO.getAdditionalInfo());
        visaRequest.setApplicationCapacity(visaRequestDTO.getApplicationCapacity());
        visaRequest.setArrestedBefore(visaRequestDTO.getArrestedBefore());
        visaRequest.setDeportedBefore(visaRequestDTO.getDeportedBefore());
        visaRequest.setDuplicateAccountFunction(visaRequestDTO.getDuplicateAccountFunction());
        visaRequest.setEmployerName(visaRequestDTO.getEmployerName());
        visaRequest.setEmploymentStatus(visaRequestDTO.getEmploymentStatus());
        visaRequest.setHasCashFlow(visaRequestDTO.getHasCashFlow());
        visaRequest.setInfoAttestation(visaRequestDTO.getInfoAttestation());
        visaRequest.setInvolvedInTerrorism(visaRequestDTO.getInvolvedInTerrorism());
        visaRequest.setIsAccountBalanceLow(visaRequestDTO.getIsAccountBalanceLow());
        visaRequest.setIsBusinessRegistered(visaRequestDTO.getIsBusinessRegistered());
        visaRequest.setMonthlyTurnover(visaRequestDTO.getMonthlyTurnover());
        visaRequest.setNameOfBusiness(visaRequestDTO.getNameOfBusiness());
        visaRequest.setNatureOfBusiness(visaRequestDTO.getNatureOfBusiness());
        visaRequest.setNeedInvitationLetter(visaRequestDTO.getNeedInvitationLetter());
        visaRequest.setNoOfStaff(visaRequestDTO.getNoOfStaff());
        visaRequest.setOtherPurposes(visaRequestDTO.getOtherPurposes());
        visaRequest.setOverStayedTopCountryBefore(visaRequestDTO.getOverStayedTopCountryBefore());
        visaRequest.setPassportExpiryDate(visaRequestDTO.getPassportExpiryDate());
        visaRequest.setPassportIssueDate(visaRequestDTO.getPassportIssueDate());
        visaRequest.setPlaceToStay(visaRequestDTO.getPlaceToStay());
        visaRequest.setPlanToReturn(visaRequestDTO.getPlanToReturn());
        visaRequest.setPositionInCompany(visaRequestDTO.getPositionInCompany());
        visaRequest.setProvideFundSource(visaRequestDTO.getProvideFundSource());
        visaRequest.setReasonRejectionChanged(visaRequestDTO.getReasonRejectionChanged());
        visaRequest.setRejectedPreviously(visaRequestDTO.getRejectedPreviously());
        visaRequest.setRejectionReason(visaRequestDTO.getRejectionReason());
        visaRequest.setRequireInsurance(visaRequestDTO.getRequireInsurance());
        visaRequest.setSalaryRange(visaRequestDTO.getSalaryRange());
        visaRequest.setSpecialCircumstance(visaRequestDTO.getSpecialCircumstance());
        visaRequest.setTimesAppliedPreviously(visaRequestDTO.getTimesAppliedPreviously());
        visaRequest.setTopCountryOverstayed(visaRequestDTO.getTopCountryOverstayed());
        visaRequest.setTopCountryVisited(visaRequestDTO.getTopCountryVisited());
        visaRequest.setTravelPurpose(visaRequestDTO.getTravelPurpose());
        visaRequest.setVisaAttestation(visaRequestDTO.getVisaAttestation());
        visaRequest.setVisitedPreviously(visaRequestDTO.getVisitedPreviously());
        visaRequest.setVisitedTopCountryBefore(visaRequestDTO.getVisitedTopCountryBefore());
        visaRequest.setWillInviteeHostYou(visaRequestDTO.getWillInviteeHostYou());
        visaRequest.setStatus(EntityStatus.ACTIVE);

        optionalCountry = countryRepository.findFirstByName(visaRequestDTO.getResidentCountry());
        if (optionalCountry.isPresent()) {
            visaRequest.setResidentCountry(optionalCountry.get());
        }
        Optional<VisaCountry> optionalVisaCountry = visaCountryRepository.findFirstByCountryName(visaRequestDTO.getDestinationCountry());
        if (optionalVisaCountry.isPresent()) {
            visaRequest.setDestinationCountry(optionalVisaCountry.get());
        }
        optionalCountry = countryRepository.findFirstByName(visaRequestDTO.getNationality());
        if (optionalCountry.isPresent()) {
            visaRequest.setNationality(optionalCountry.get());
        }

        visaRequest.setTravelDate(new Timestamp(visaRequestDTO.getReturnDate().getTime()));
        if (visaRequestDTO.getEmploymentResumptionDate() != null) {
            visaRequest.setEmploymentResumptionDate(new Timestamp(visaRequestDTO.getEmploymentResumptionDate().getTime()));
        }
        visaRequest.setEmail(visaRequestDTO.getEmail());
        visaRequest.setFirstName(visaRequestDTO.getFirstName());
        visaRequest.setLastName(visaRequestDTO.getLastName());
        visaRequest.setPhoneNumber(visaRequestDTO.getPhoneNumber());
        visaRequest.setReturnDate(new Timestamp(visaRequestDTO.getReturnDate().getTime()));

        visaRequestRepository.save(visaRequest);
        sendVisaRequestEmail(visaRequest);
        createVisaServiceRequest(visaRequest, visaRequestDTO);
        responseDTO.setReservationId(visaRequest.getId());

        return responseDTO;
    }

    @Transactional
    public void createVisaServiceRequest(VisaRequest visaRequest, VisaRequestDTO visaRequestDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(visaRequest.getEmail());
        Customer customer;
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        } else {
            customer = new Customer();
            customer.setEmail(visaRequestDTO.getEmail());
            customer.setFirstName(visaRequestDTO.getFirstName());
            customer.setLastName(visaRequestDTO.getLastName());
            customer.setPhoneNumber(visaRequestDTO.getPhoneNumber());
            customer.setStatus(EntityStatus.ACTIVE);
            customerRepository.save(customer);
        }

        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setCustomer(customer);
        serviceRequest.setName(ServiceQueueName.VISA_REQUEST);
        serviceRequest.setPriority(Priority.MEDIUM);
        serviceRequest.setVisaRequest(visaRequest);
        serviceRequest.setRequestId(RandomStringUtils.randomAlphabetic(6));
        serviceRequest.setServiceType(ReservationType.VISA);
        serviceRequest.setStatus(EntityStatus.ACTIVE);
        serviceRequestRepository.save(serviceRequest);

        ServiceRequestLog serviceRequestLog = new ServiceRequestLog();
        serviceRequestLog.setDescription(ServiceTaskType.NEW_TASK.getValue());
        serviceRequestLog.setSubject(ServiceTaskSubject.VISA);
        serviceRequestLog.setTaskType(ServiceTaskType.NEW_TASK);
        serviceRequestLog.setStatus(EntityStatus.ACTIVE);
        serviceRequestLogRepository.save(serviceRequestLog);
    }

    private void sendVisaRequestEmail(VisaRequest visaRequest) {
        log.info("Sending mail.....");
        Map<String, Object> visaRequestEmail = new HashMap<>();
        visaRequestEmail.put("recieverName", visaRequest.getLastName().toUpperCase() + " " + visaRequest.getFirstName());
        visaRequestEmail.put("destination", visaRequest.getDestinationCountry().getCountryName());
        emailService.sendHtmlEmail(visaRequest.getEmail(), "Visa Request Notification", "visa-request-confirmation-template", visaRequestEmail, "travel@naijatravelshop.com");
    }
}
