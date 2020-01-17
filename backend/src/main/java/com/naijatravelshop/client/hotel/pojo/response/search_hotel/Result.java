package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 14/08/2019
 */
@Data
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {
    private String currencyShort;
    private String successful;
    @XmlAttribute(name = "command")
    private String command;
    @XmlAttribute(name = "tID")
    private String tID;
    @XmlAttribute(name = "ip")
    private String ip;
    @XmlAttribute(name = "date")
    private String date;
    @XmlAttribute(name = "version")
    private String version;
    @XmlAttribute(name = "elapsedTime")
    private String elapsedTime;
    @XmlElement(name = "hotel")
    @XmlElementWrapper(name = "hotels")
    private List<Hotel> hotels;
}