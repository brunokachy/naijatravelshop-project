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
@XmlRootElement(name = "hotel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel {
    private Description description1;
    private Description description2;
    private String hotelName;
    private String address;
    private String cityName;
    private String cityCode;
    private String countryName;
    private String countryCode;
    private Amenitie amenitie;
    private Leisure leisure;
    private Business business;
    private String rating;
    private Images images;
    private GeoPoint geoPoint;
    @XmlAttribute(name = "runno")
    private String runno;
    @XmlAttribute(name = "preferred")
    private String preferred;
    @XmlAttribute(name = "exclusive")
    private String exclusive;
    @XmlAttribute(name = "cityname")
    private String cityame;
    @XmlAttribute(name = "hotelid")
    private String hotelid;
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "id")
    private String id;
    private String allowBook;
    @XmlElement(name = "room")
    @XmlElementWrapper(name = "rooms")
    private List<Room> rooms;
}
