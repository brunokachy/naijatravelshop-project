package com.naijatravelshop.service.flight.pojo.request;

import java.util.List;

/**
 * Created by Bruno on
 * 05/06/2019
 */
public class OriginDestinationOptionsDTO {
    private Integer stops;
    private List<FlightSegmentsDTO> flightSegments;

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public List<FlightSegmentsDTO> getFlightSegments() {
        return flightSegments;
    }

    public void setFlightSegments(List<FlightSegmentsDTO> flightSegments) {
        this.flightSegments = flightSegments;
    }
}
