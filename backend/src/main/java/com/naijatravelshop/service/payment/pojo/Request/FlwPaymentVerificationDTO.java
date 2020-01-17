package com.naijatravelshop.service.payment.pojo.Request;

/**
 * Created by Bruno on
 * 18/05/2019
 */

public class FlwPaymentVerificationDTO {
    private String flwRef;

    private String secret;

    private Double amount;

    private Integer paymentEntity;

    private String paymentRef;

    private String paymentCode;

    private String bookingNumber;

    public String getFlwRef() {
        return flwRef;
    }

    public void setFlwRef(String flwRef) {
        this.flwRef = flwRef;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(Integer paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    public String getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
}
