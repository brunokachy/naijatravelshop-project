package com.naijatravelshop.service.hotel.pojo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Bruno on
 * 27/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class HotelListReponse {

    private List<HotelResponse> hotelList;

    private Integer totalResult;

    private Double maximumPrice;

    private Double minimumPrice;
}
