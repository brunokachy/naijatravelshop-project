package com.naijatravelshop.service.flight.pojo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Bruno on
 * 18/05/2019
 */
@Getter
@Setter
@ToString
public class ReservationRequestDTO {
    private String status;
    private String message;
    private String referenceNumber;
    private String bookingNumber;
    private String ticketLimitDate;
    private Integer paidAmount;
    private String paymentReference;
    private String paymentType;
    private String confirmed;
    private String bookingExpireTime;
    private String reservationType;
    private String portalUsername;
    private FlightDetailDTO flightDetails;
    private FlightDataSearchDTO flightSearch;
    private String flightSummary;

    private String title;

    private String description;

    private Integer amount;

    private TravellerDTO reservationOwner;

    private List<TravellerDTO> travellers;

    private String departureDate;

    private String arrivalDate;

}
