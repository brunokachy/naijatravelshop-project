package com.naijatravelshop.persistence.model.hotel;

import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Bruno on
 * 08/09/2019
 */
@Entity
@Getter
@Setter
public class RoomOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private HotelBookingDetail hotelBookingDetail;
    @Column
    private Integer numberOfAdults;
    @Column
    private Integer numberOfChildren;
}
