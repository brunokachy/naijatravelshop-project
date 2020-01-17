package com.naijatravelshop.service.portal.pojo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Bruno on
 * 19/06/2019
 */
@Getter
@Setter
public class RecentBookingResponse {

    private String bookingType;

    private Date bookingDate;

    private String description;

    private String bookingNumber;

    private Double amount;

    private String bookingStatus;

    private String ownerEmail;
}
