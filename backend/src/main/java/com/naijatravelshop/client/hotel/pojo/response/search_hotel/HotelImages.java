package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Data
@XmlRootElement(name = "hotelImages")
@XmlAccessorType(XmlAccessType.FIELD)
public class HotelImages {

    private String thumb;

    private List<Image> image;

    @XmlAttribute(name = "count")
    private String count;
}
