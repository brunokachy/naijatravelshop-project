package com.naijatravelshop.service.payment.service;

import com.naijatravelshop.service.payment.pojo.Request.BankPaymentDTO;
import com.naijatravelshop.service.payment.pojo.Request.FlwPaymentVerificationDTO;
import com.naijatravelshop.service.payment.pojo.Response.FlwAccountDetail;

public interface PaymentService {

    void verifyFlwPayment(FlwPaymentVerificationDTO flwPaymentVerificationDTO);

    void bankPayment(BankPaymentDTO bankPaymentDTO);

    FlwAccountDetail getFlwAccountDetail();
}
