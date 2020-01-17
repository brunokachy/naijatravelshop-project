package com.naijatravelshop.service.visa.service;

import com.naijatravelshop.service.flight.pojo.request.VisaRequestDTO;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.visa.pojo.response.VisaCountryDTO;

import java.util.List;

public interface VisaService {

    List<VisaCountryDTO> getAllVisaCountry();

    List<VisaCountryDTO> getAllActiveVisaCountry();

    VisaCountryDTO createVisaCountry(String countryName);

    VisaCountryDTO updateVisaCountry(VisaCountryDTO visaCountryDTO);

    ReservationResponseDTO createVisaRequest(VisaRequestDTO visaRequestDTO);
}
