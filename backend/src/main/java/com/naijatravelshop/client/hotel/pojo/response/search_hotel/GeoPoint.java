package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Data
@XmlRootElement(name = "geoPoint")
@XmlAccessorType(XmlAccessType.FIELD)
public class GeoPoint {

    private String lat;
    private String lng;
}
