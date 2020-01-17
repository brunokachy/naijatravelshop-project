package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Data
@XmlRootElement(name = "return")
@XmlAccessorType(XmlAccessType.FIELD)
public class Return implements Serializable {

    private Filters filters;

    @XmlElement(name = "getRooms")
    private String getRooms;

    private Fields fields;
}
