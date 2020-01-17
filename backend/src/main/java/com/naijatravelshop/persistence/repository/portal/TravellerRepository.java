package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.hotel.RoomOffer;
import com.naijatravelshop.persistence.model.portal.Reservation;
import com.naijatravelshop.persistence.model.portal.Traveller;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravellerRepository extends CrudRepository<Traveller, Long> {

    List<Traveller> getAllByReservation(Reservation reservation);

    List<Traveller> getAllByRoomOffer(RoomOffer roomOffer);
}
