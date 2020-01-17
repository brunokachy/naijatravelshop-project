package com.naijatravelshop.persistence.repository.hotel;

import com.naijatravelshop.persistence.model.hotel.HotelCity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelCityRepository extends CrudRepository<HotelCity, Long> {

    Optional<HotelCity> findFirstByCode(String code);
}
