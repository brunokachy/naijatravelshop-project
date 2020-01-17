package com.naijatravelshop.service.hotel.service;

import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.hotel.pojo.request.BookHotelDTO;
import com.naijatravelshop.service.hotel.pojo.request.HotelCityDTO;
import com.naijatravelshop.service.hotel.pojo.request.SearchHotelDTO;
import com.naijatravelshop.service.hotel.pojo.response.HotelListReponse;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Bruno on
 * 12/08/2019
 */
public interface HotelService {

    List<HotelCityDTO> getAllHotelCity();

    HotelListReponse searchHotel(SearchHotelDTO searchHotelDTO);

    ReservationResponseDTO createReservation(BookHotelDTO bookHotelDTO);

}
