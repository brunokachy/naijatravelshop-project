package com.naijatravelshop.service.flight.pojo.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Bruno on
 * 18/05/2019
 */
@Getter
@Setter
public class ReservationResponseDTO implements Serializable {

    private String bookingNumber;

    private Long reservationId;
}
