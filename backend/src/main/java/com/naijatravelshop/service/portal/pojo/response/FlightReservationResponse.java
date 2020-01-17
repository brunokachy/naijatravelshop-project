package com.naijatravelshop.service.portal.pojo.response;

import com.naijatravelshop.service.flight.pojo.request.FlightSegmentsDTO;
import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by Bruno on
 * 23/06/2019
 */
@Setter
@Getter
public class FlightReservationResponse {
    private String bookingNumber;
    private Long sellingPrice;
    private String reservationStatus;
    private Date dateProcessed;
    private TravellerDTO reservationOwner;

    private Date bookingDate;
    private Integer numberOfAdult = 1;
    private Integer numberOfChildren = 0;
    private Integer numberOfInfant = 0;
    private Boolean visaServiceRequested = false;
    private Boolean hotelServiceRequested = false;

    private List<TravellerDTO> travellers;

    private String paymentReference;
    private String paymentStatus;
    private Date paymentDate;
    private String transactionId;
    private String paymentChannel;

    List<FlightSegmentsDTO> flightRoutes;

}
