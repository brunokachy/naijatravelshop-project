package com.naijatravelshop.client.hotel.service;

import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Hotel;
import com.naijatravelshop.service.hotel.pojo.request.SearchHotelDTO;

import java.util.List;

public interface GOTWClientService {

    List<Hotel> searchHotel(SearchHotelDTO searchHotelDTO);
}
