package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 11/08/2019
 */
@Data
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class Request implements Serializable {

    private BookingDetails bookingDetails;

    @XmlElement(name = "return")
    private Return returns;

    @XmlAttribute(name = "command")
    private String _command;
}
