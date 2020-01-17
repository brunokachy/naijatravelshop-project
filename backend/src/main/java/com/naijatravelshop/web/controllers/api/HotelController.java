package com.naijatravelshop.web.controllers.api;

import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.hotel.pojo.request.BookHotelDTO;
import com.naijatravelshop.service.hotel.pojo.request.HotelCityDTO;
import com.naijatravelshop.service.hotel.pojo.request.SearchHotelDTO;
import com.naijatravelshop.service.hotel.pojo.response.HotelListReponse;
import com.naijatravelshop.service.hotel.service.HotelService;
import com.naijatravelshop.web.pojo.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Bruno on
 * 12/08/2019
 */
@RestController
@CrossOrigin
@RequestMapping(value = "naijatravelshop/api/hotel")
public class HotelController {
    private HotelService hotelService;
    private static final Logger log = LoggerFactory.getLogger(HotelController.class);

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @ApiOperation(value = "Fetch Hotel Cities")
    @PostMapping(value = {"/fetch_hotel_cities"}, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<HotelCityDTO>>> fetchHotelCities() {
        log.info("FETCH HOTEL CITIES: {}");
        ApiResponse<List<HotelCityDTO>> apiResponse = new ApiResponse<>();
        List<HotelCityDTO> responseDTO = hotelService.getAllHotelCity();
        apiResponse.setMessage("Hotel cities fetched successfully");
        apiResponse.setData(responseDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Search Hotels")
    @PostMapping(value = {"/search_hotels"}, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<HotelListReponse>> searchHotels(@RequestBody SearchHotelDTO searchHotelDTO) {
        log.info("FETCH HOTEL CITIES: {}");
        ApiResponse<HotelListReponse> apiResponse = new ApiResponse<>();
        HotelListReponse responseDTO = hotelService.searchHotel(searchHotelDTO);
        apiResponse.setMessage("Hotel Search was successfully");
        apiResponse.setData(responseDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Create Hotel Reservation")
    @PostMapping(value = {"/create_reservation"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> createReservation(@RequestBody BookHotelDTO bookHotelDTO) {
        log.info("CREATE HOTEL RESERVATION: {}", bookHotelDTO.toString());
        ApiResponse<ReservationResponseDTO> apiResponse = new ApiResponse<>();
        ReservationResponseDTO responseDTO = hotelService.createReservation(bookHotelDTO);
        apiResponse.setMessage("Hotel reservation creation was successful");
        apiResponse.setData(responseDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
