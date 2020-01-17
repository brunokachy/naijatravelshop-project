package com.naijatravelshop.persistence.repository.flight;

import com.naijatravelshop.persistence.model.flight.Airport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirportRepository extends CrudRepository<Airport, Long> {

    List<Airport> getAirportByPopularityIndexGreaterThan(Integer popularityIndex);
}
