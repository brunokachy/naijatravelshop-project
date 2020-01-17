package com.naijatravelshop.service.flight.pojo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Bruno on
 * 03/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class AirportDTO implements Serializable {
    private static final Long serialVersionUID = -5554308939380869754L;
    private String icaoCode;
    private String iataCode;
    private String name;
    private String latitude;
    private String longitude;
    private String timezone;
    private String gmt;
    private String city;
    private String country;
    private String displayName;
}
