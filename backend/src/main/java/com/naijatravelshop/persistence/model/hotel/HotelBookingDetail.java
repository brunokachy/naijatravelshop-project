package com.naijatravelshop.persistence.model.hotel;

import com.naijatravelshop.persistence.model.generic.AuditModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Getter
@Setter
@Table(name = "hotel_booking_detail")
public class HotelBookingDetail extends AuditModel implements Serializable {
    @Column(nullable = false)
    private Timestamp checkinDate;
    @Column(nullable = false)
    private Timestamp checkoutDate;
    private Integer numberOfRoom = 0;
    private Integer numberOfAdult = 0;
    private Integer numberOfChildren = 0;
    private Long nightlyRateTotalInKobo;
    private Integer numberOfNightsStay;
    private String supplierReference;
    private String roomType;
    private String hotelName;
    private String hotelDescription;
    private String hotelId;
    private String cityName;
    @ManyToOne
    private HotelCity city;
    private String countryName;
    private String countryCode;
}
