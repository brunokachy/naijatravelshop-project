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
 * 14/08/2019
 */
@Data
@XmlRootElement(name = "roomType")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomType {
    private String name;
    @XmlElement(name = "rateBasis")
    @XmlElementWrapper(name = "rateBases")
    private List<Ratebasis> rateBasis;
    @XmlAttribute(name = "roomtypecode")
    private String roomtypecode;
}
