package com.naijatravelshop.persistence.repository.flight;

import com.naijatravelshop.persistence.model.flight.FlightBookingDetail;
import com.naijatravelshop.persistence.model.flight.FlightRoute;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRouteRepository extends CrudRepository<FlightRoute, Long> {

    List<FlightRoute> findAllByFlightBookingDetail(FlightBookingDetail flightBookingDetail);
}
