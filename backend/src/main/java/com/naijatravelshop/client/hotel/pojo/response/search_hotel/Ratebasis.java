package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by Bruno on
 * 12/08/2019
 */
@Data
@XmlRootElement(name = "ratebasis")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ratebasis {

    private String rateType;
    private String total;
    @XmlAttribute(name = "id")
    private String id;
}
