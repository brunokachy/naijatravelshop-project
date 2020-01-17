package com.naijatravelshop.web.controllers.api;

import com.naijatravelshop.service.flight.pojo.request.VisaRequestDTO;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.portal.service.PortalService;
import com.naijatravelshop.service.visa.pojo.response.VisaCountryDTO;
import com.naijatravelshop.service.visa.service.VisaService;
import com.naijatravelshop.web.pojo.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bruno on
 * 04/11/2019
 */
@RestController
@RequestMapping(value = "naijatravelshop/api/visa")
public class VisaController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private VisaService visaService;
    private PortalService portalService;

    public VisaController(VisaService visaService, PortalService portalService) {
        this.visaService = visaService;
        this.portalService = portalService;
    }

    @ApiOperation(value = "Create Visa Country")
    @PostMapping(value = {"/create_visa_country"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<VisaCountryDTO>> createVisaCountry(@RequestBody String countryName) {
        ApiResponse<VisaCountryDTO> apiResponse = new ApiResponse<>();
        VisaCountryDTO createVisaCountryResponse = visaService.createVisaCountry(countryName);
        apiResponse.setMessage("Visa country created successfully");
        apiResponse.setData(createVisaCountryResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Visa Country")
    @PostMapping(value = {"/update_visa_country"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<VisaCountryDTO>> updateVisaCountry(@RequestBody VisaCountryDTO visaCountryDTO) {
        ApiResponse<VisaCountryDTO> apiResponse = new ApiResponse<>();
        VisaCountryDTO createVisaCountryResponse = visaService.updateVisaCountry(visaCountryDTO);
        apiResponse.setMessage("Visa country updated successfully");
        apiResponse.setData(createVisaCountryResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch All Visa Country")
    @GetMapping(value = {"/get_all_visa_country"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<VisaCountryDTO>>> getAllVisaCountry() {
        ApiResponse<List<VisaCountryDTO>> apiResponse = new ApiResponse<>();
        List<VisaCountryDTO> visaCountryDTOS = visaService.getAllVisaCountry();
        apiResponse.setMessage("All visa countries retrieved successfully");
        apiResponse.setData(visaCountryDTOS);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch All Active Visa Country")
    @GetMapping(value = {"/get_all_active_visa_country"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<VisaCountryDTO>>> getAllActiveVisaCountry() {
        ApiResponse<List<VisaCountryDTO>> apiResponse = new ApiResponse<>();
        List<VisaCountryDTO> visaCountryDTOS = visaService.getAllActiveVisaCountry();
        apiResponse.setMessage("All active visa countries retrieved successfully");
        apiResponse.setData(visaCountryDTOS);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch All NA/EU Country")
    @GetMapping(value = {"/get_na_eu_country"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<VisaCountryDTO>>> getNAEUCountry() {
        ApiResponse<List<VisaCountryDTO>> apiResponse = new ApiResponse<>();
        List<VisaCountryDTO> visaCountryDTOS = portalService.getNAEUCountries();
        apiResponse.setMessage("EU/NA countries retrieved successfully");
        apiResponse.setData(visaCountryDTOS);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Create Visa Request")
    @PostMapping(value = {"/create_visa_request"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> createVisaRequest(@RequestBody VisaRequestDTO visaRequestDTO) {
        log.info("CREATE VISA REQUEST: {}", visaRequestDTO.toString());
        ApiResponse<ReservationResponseDTO> apiResponse = new ApiResponse<>();
        ReservationResponseDTO responseDTO = visaService.createVisaRequest(visaRequestDTO);
        apiResponse.setMessage("Visa request was created successfully");
        apiResponse.setData(responseDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
