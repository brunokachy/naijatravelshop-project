package com.naijatravelshop.service.portal.pojo.response;

import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import com.naijatravelshop.service.hotel.pojo.request.RoomDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by Bruno on
 * 10/09/2019
 */
@Builder
@Getter
@Setter
public class HotelReservationResponse {
    private String bookingNumber;
    private Long sellingPrice;
    private String reservationStatus;
    private Date dateProcessed;
    private TravellerDTO reservationOwner;
    private Date bookingDate;

    @Builder.Default
    private Integer numberOfAdult = 1;
    @Builder.Default
    private Integer numberOfChildren = 0;
    private Integer numberOfRooms;
    private Integer nights;
    private String roomType;
    private String hotelName;
    private String hotelDescription;
    private String hotelId;
    private String cityName;
    private String countryName;
    private Date checkInDate;
    private Date checkOutDate;

    private String paymentReference;
    private String paymentStatus;
    private Date paymentDate;
    private String transactionId;
    private String paymentChannel;
    @Builder.Default
    private Boolean visaServiceRequested = false;
    @Builder.Default
    private Boolean hotelServiceRequested = false;
    private List<RoomDTO> rooms;
}
