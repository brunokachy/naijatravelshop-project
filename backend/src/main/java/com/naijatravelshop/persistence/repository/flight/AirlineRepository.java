package com.naijatravelshop.persistence.repository.flight;

import com.naijatravelshop.persistence.model.flight.Airline;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AirlineRepository extends CrudRepository<Airline, Long> {

    Optional<Airline> findFirstByIataCodeAndStatus(String iataCode, String status);
}
