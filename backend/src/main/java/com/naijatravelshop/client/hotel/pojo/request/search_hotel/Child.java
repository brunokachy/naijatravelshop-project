package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Child implements Serializable {
    @XmlAttribute(name = "runno")
    private String _runno;

    @XmlValue
    private String child;
}
