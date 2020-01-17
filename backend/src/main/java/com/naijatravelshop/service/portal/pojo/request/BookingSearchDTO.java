package com.naijatravelshop.service.portal.pojo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bruno on
 * 21/06/2019
 */
@Getter
@Setter
public class BookingSearchDTO {

    private String startDate;

    private String endDate;

    private String bookingStatus;

    private String bookingNo;

    private String ownerEmail;

}
