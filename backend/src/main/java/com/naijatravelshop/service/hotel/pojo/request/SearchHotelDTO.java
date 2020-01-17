package com.naijatravelshop.service.hotel.pojo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Builder
@Getter
@Setter
@ToString
public class SearchHotelDTO implements Serializable {

    private String cityCode;

    private String checkInDate;

    private String checkOutDate;

    private List<RoomDTO> roomDetailList;

    private Integer numberOfRooms;
}

