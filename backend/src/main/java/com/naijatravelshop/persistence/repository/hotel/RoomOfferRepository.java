package com.naijatravelshop.persistence.repository.hotel;

import com.naijatravelshop.persistence.model.hotel.HotelBookingDetail;
import com.naijatravelshop.persistence.model.hotel.RoomOffer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomOfferRepository  extends CrudRepository<RoomOffer, Long> {

    List<RoomOffer> getAllByHotelBookingDetail(HotelBookingDetail hotelBookingDetail);
}
