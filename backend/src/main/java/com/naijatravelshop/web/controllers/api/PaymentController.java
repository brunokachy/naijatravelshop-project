package com.naijatravelshop.web.controllers.api;

import com.naijatravelshop.service.payment.pojo.Request.BankPaymentDTO;
import com.naijatravelshop.service.payment.pojo.Request.FlwPaymentVerificationDTO;
import com.naijatravelshop.service.payment.pojo.Response.FlwAccountDetail;
import com.naijatravelshop.service.payment.service.PaymentService;
import com.naijatravelshop.web.pojo.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Bruno on
 * 18/05/2019
 */
@RestController
@RequestMapping(value = "naijatravelshop/api/payment")
public class PaymentController {

    private PaymentService paymentService;

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @ApiOperation(value = "Flutterwave Payment Verification")
    @PostMapping(value = {"/flw_payment_verification"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> verifyFlwPayment(@RequestBody FlwPaymentVerificationDTO flwPaymentVerificationDTO) {
        log.info("FLUTTERWAVE PAYMENT VERIFICATION: {}", flwPaymentVerificationDTO.toString());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        paymentService.verifyFlwPayment(flwPaymentVerificationDTO);
        apiResponse.setMessage("Payment Verification was successful");
        apiResponse.setData("Success");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Bank Payment")
    @PostMapping(value = {"/bank_payment"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> bankPayment(@RequestBody BankPaymentDTO bankPaymentDTO) {
        log.info("BANK PAYMENT: {}", bankPaymentDTO.toString());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        paymentService.bankPayment(bankPaymentDTO);
        apiResponse.setMessage("Payment details saved successfully");
        apiResponse.setData("Success");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch Flutterwave Account")
    @GetMapping(value = {"/get_flw_account_details"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<FlwAccountDetail>> getFlwAccountDetails() {
        ApiResponse<FlwAccountDetail> apiResponse = new ApiResponse<>();
        FlwAccountDetail flwAccountDetail = paymentService.getFlwAccountDetail();
        apiResponse.setMessage("Flw Account Details retrieved successfully");
        apiResponse.setData(flwAccountDetail);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
