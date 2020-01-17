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
 * 12/08/2019
 */
@Data
@XmlRootElement(name = "filters")
@XmlAccessorType(XmlAccessType.FIELD)
public class Filters implements Serializable {
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "noPrice")
    private String noPrice;

    @XmlAttribute(name = "xmlns:a")
    private String xmlnsa;

    @XmlAttribute(name = "xmlns:c")
    private String xmlnsc;

    @XmlElement(name = "c:condition")
    private ConditionC conditionC;
}
