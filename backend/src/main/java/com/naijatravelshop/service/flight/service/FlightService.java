package com.naijatravelshop.service.flight.service;

import com.naijatravelshop.service.flight.pojo.request.ReservationRequestDTO;
import com.naijatravelshop.service.flight.pojo.request.VisaRequestDTO;
import com.naijatravelshop.service.flight.pojo.response.AirportDTO;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;

import java.util.List;

public interface FlightService {

    ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO);

    List<AirportDTO> getAllAirports();

}
