package com.naijatravelshop.persistence.model.payment;

import com.naijatravelshop.persistence.model.enums.ReservationType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Table(name = "payment_line_item")
public class PaymentLineItem implements Serializable {
    @Column(nullable = false)
    private ReservationType itemType;
    private String itemDescription;
    @Column(nullable = false)
    private Long amountInKobo;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private PaymentHistory paymentHistory;

    public ReservationType getItemType() {
        return itemType;
    }

    public void setItemType(ReservationType itemType) {
        this.itemType = itemType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getAmountInKobo() {
        return amountInKobo;
    }

    public void setAmountInKobo(Long amountInKobo) {
        this.amountInKobo = amountInKobo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(PaymentHistory paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
}
