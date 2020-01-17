package com.naijatravelshop.service.payment.pojo.Request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Bruno on
 * 28/07/2019
 */
@Getter
@ToString
@Setter
public class BankPaymentDTO {

    private Double amount;

    private String bookingNumber;
}
