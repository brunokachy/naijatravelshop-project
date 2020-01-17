package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Data
@XmlRootElement(name = "room")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"adultsCode", "children", "rateBasis"})
public class Room implements Serializable {
    private Children children;
    private String adultsCode;
    private String rateBasis;
    @XmlAttribute(name = "runno")
    private String _runno;
}

