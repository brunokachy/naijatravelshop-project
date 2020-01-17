package com.naijatravelshop.persistence.model.payment;

import com.naijatravelshop.persistence.model.enums.*;
import com.naijatravelshop.persistence.model.generic.AuditModel;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.Reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Table(name = "payment_history")
public class PaymentHistory extends AuditModel implements Serializable {
    @Column(nullable = false)
    private String paymentReference;
    @Column(nullable = false)
    private ProcessStatus paymentStatus;
    @Column(nullable = false)
    private PaymentChannel paymentChannel;
    private Long amountInKobo;
    private String paymentProviderReferenceId;
    private String paymentProviderResponseCode = "-1";
    private String paymentProviderResponseText;
    private Timestamp paymentDate;
    private String receiptNumber;
    @Column(nullable = false)
    private PaymentProvider paymentProvider;
    private String payerName;
    private String payerPhone;
    private String payerEmail;
    @Column(nullable = false)
    private String transactionId;
    private String payerPaymentChannel;
    private Long amountActualPaidInKobo;
    private PaymentEntityType paymentEntityType;
    private Long paymentEntityId;
    private PortalUser portalUser;
    @ManyToOne
    private PortalUser paymentProcessedBy;
    @OneToOne
    private BankAccount bankAccount;
    @ManyToOne
    private Reservation reservation;

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public ProcessStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(ProcessStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentChannel getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(PaymentChannel paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public Long getAmountInKobo() {
        return amountInKobo;
    }

    public void setAmountInKobo(Long amountInKobo) {
        this.amountInKobo = amountInKobo;
    }

    public String getPaymentProviderReferenceId() {
        return paymentProviderReferenceId;
    }

    public void setPaymentProviderReferenceId(String paymentProviderReferenceId) {
        this.paymentProviderReferenceId = paymentProviderReferenceId;
    }

    public String getPaymentProviderResponseCode() {
        return paymentProviderResponseCode;
    }

    public void setPaymentProviderResponseCode(String paymentProviderResponseCode) {
        this.paymentProviderResponseCode = paymentProviderResponseCode;
    }

    public String getPaymentProviderResponseText() {
        return paymentProviderResponseText;
    }

    public void setPaymentProviderResponseText(String paymentProviderResponseText) {
        this.paymentProviderResponseText = paymentProviderResponseText;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public PaymentProvider getPaymentProvider() {
        return paymentProvider;
    }

    public void setPaymentProvider(PaymentProvider paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPayerPaymentChannel() {
        return payerPaymentChannel;
    }

    public void setPayerPaymentChannel(String payerPaymentChannel) {
        this.payerPaymentChannel = payerPaymentChannel;
    }

    public Long getAmountActualPaidInKobo() {
        return amountActualPaidInKobo;
    }

    public void setAmountActualPaidInKobo(Long amountActualPaidInKobo) {
        this.amountActualPaidInKobo = amountActualPaidInKobo;
    }

    public PaymentEntityType getPaymentEntityType() {
        return paymentEntityType;
    }

    public void setPaymentEntityType(PaymentEntityType paymentEntityType) {
        this.paymentEntityType = paymentEntityType;
    }

    public Long getPaymentEntityId() {
        return paymentEntityId;
    }

    public void setPaymentEntityId(Long paymentEntityId) {
        this.paymentEntityId = paymentEntityId;
    }

    public PortalUser getPortalUser() {
        return portalUser;
    }

    public void setPortalUser(PortalUser portalUser) {
        this.portalUser = portalUser;
    }

    public PortalUser getPaymentProcessedBy() {
        return paymentProcessedBy;
    }

    public void setPaymentProcessedBy(PortalUser paymentProcessedBy) {
        this.paymentProcessedBy = paymentProcessedBy;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
