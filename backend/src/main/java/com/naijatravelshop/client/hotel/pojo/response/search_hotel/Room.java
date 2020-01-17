package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 14/08/2019
 */
@Data
@XmlRootElement(name = "room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {

    private List<RoomType> roomType;
    @XmlAttribute(name = "adults")
    private String adults;
    @XmlAttribute(name = "children")
    private String children;
    @XmlAttribute(name = "extrabeds")
    private String extrabeds;
}
