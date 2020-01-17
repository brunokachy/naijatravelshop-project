package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Data
@XmlRootElement(name = "amenitie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Amenitie {

    @XmlElement(name = "amenitieItem")
    @XmlElementWrapper(name = "language")
    private List<String> language;

    @XmlAttribute(name = "count")
    private String count;
}
