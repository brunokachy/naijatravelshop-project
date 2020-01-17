package com.naijatravelshop.service.flight.pojo.request;

/**
 * Created by Bruno on
 * 05/06/2019
 */
public class FlightSegmentsDTO {
    private String departureTime;

    private String arrivalTime;

    private String departureAirportCode;

    private String departureAirportName;

    private String arrivalAirportCode;

    private String arrivalAirportName;

    private String airlineCode;

    private String operatingAirlineCode;

    private String airlineName;

    private String bookingClass;

    private String journeyDuration;

    private String flightNumber;

    private String resBookDesigCode;

    private Integer numberInParty;

    private String rph;

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getOperatingAirlineCode() {
        return operatingAirlineCode;
    }

    public void setOperatingAirlineCode(String operatingAirlineCode) {
        this.operatingAirlineCode = operatingAirlineCode;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass) {
        this.bookingClass = bookingClass;
    }

    public String getJourneyDuration() {
        return journeyDuration;
    }

    public void setJourneyDuration(String journeyDuration) {
        this.journeyDuration = journeyDuration;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getResBookDesigCode() {
        return resBookDesigCode;
    }

    public void setResBookDesigCode(String resBookDesigCode) {
        this.resBookDesigCode = resBookDesigCode;
    }

    public Integer getNumberInParty() {
        return numberInParty;
    }

    public void setNumberInParty(Integer numberInParty) {
        this.numberInParty = numberInParty;
    }

    public String getRph() {
        return rph;
    }

    public void setRph(String rph) {
        this.rph = rph;
    }
}
