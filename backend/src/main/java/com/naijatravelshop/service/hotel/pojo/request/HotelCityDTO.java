package com.naijatravelshop.service.hotel.pojo.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Builder
@Getter
@Setter
public class HotelCityDTO implements Serializable {
    private static final Long serialVersionUID = -5554308939380869754L;

    private String name;

    private String code;

    private String countryName;

    private String countryCode;

    private String displayName;
}
