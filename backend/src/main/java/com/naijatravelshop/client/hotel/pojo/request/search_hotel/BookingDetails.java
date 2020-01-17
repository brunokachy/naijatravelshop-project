package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * Created by Bruno on
 * 12/08/2019
 */
@Data
@XmlRootElement(name = "bookingDetails")
@XmlType(propOrder={"fromDate", "toDate", "currency", "rooms"})
public class BookingDetails implements Serializable {
    private String fromDate;

    private String toDate;

    private String currency;

    private Rooms rooms;
}
