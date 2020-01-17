package com.naijatravelshop.service.flight.pojo.request;

/**
 * Created by Bruno on
 * 05/06/2019
 */
public class FlightDataSearchDTO {
    private Integer tripType;
    private Integer ticketClass;
    private TravellerCountDTO travellerDetail;

    public Integer getTripType() {
        return tripType;
    }

    public void setTripType(Integer tripType) {
        this.tripType = tripType;
    }

    public Integer getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(Integer ticketClass) {
        this.ticketClass = ticketClass;
    }

    public TravellerCountDTO getTravellerDetail() {
        return travellerDetail;
    }

    public void setTravellerDetail(TravellerCountDTO travellerDetail) {
        this.travellerDetail = travellerDetail;
    }
}
