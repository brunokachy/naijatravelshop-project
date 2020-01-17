package com.naijatravelshop.service.hotel.pojo.request;

import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bruno on
 * 08/09/2019
 */
@Builder
@Getter
@Setter
@ToString
public class BookHotelDTO implements Serializable {
    private String cityCode;

    private String checkInDate;

    private String checkOutDate;

    private String hotelName;

    private String hotelId;

    private String hotelDescription;

    private String cityName;

    private String countryName;

    private String countryCode;

    private Integer roomPrice;

    private String roomName;

    private Integer nights;

    private List<RoomDTO> guestInformation;

    private TravellerDTO customerAccount;

    private Integer roomCount;

    private Integer adultCount;

    private Integer childCount;

    private String portalUsername;

}
