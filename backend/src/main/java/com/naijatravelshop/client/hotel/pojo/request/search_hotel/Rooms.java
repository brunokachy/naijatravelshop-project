package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Data
@XmlRootElement(name = "rooms")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rooms implements Serializable {

    @XmlAttribute(name = "no")
    private String _no;

    private List<Room> room;
}
