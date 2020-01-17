package com.naijatravelshop.persistence.model.flight;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "flight_route")
public class FlightRoute implements Serializable {
    @Column(nullable = false)
    private String departureAirport;
    @Column(nullable = false)
    private String destinationAirport;
    @Column(nullable = false)
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    @Column(nullable = false)
    private String flightNumber;
    private String departureCityName;
    private String destinationCityName;
    private String marketingAirlineName;
    private String marketingAirlineCode;
    private String operatingAirlineName;
    private String operatingAirlineCode;
    private String airlineName;
    private String flightDuration;
    private String bookingClass;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private FlightBookingDetail flightBookingDetail;

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCityName() {
        return departureCityName;
    }

    public void setDepartureCityName(String departureCityName) {
        this.departureCityName = departureCityName;
    }

    public String getDestinationCityName() {
        return destinationCityName;
    }

    public void setDestinationCityName(String destinationCityName) {
        this.destinationCityName = destinationCityName;
    }

    public String getMarketingAirlineName() {
        return marketingAirlineName;
    }

    public void setMarketingAirlineName(String marketingAirlineName) {
        this.marketingAirlineName = marketingAirlineName;
    }

    public String getMarketingAirlineCode() {
        return marketingAirlineCode;
    }

    public void setMarketingAirlineCode(String marketingAirlineCode) {
        this.marketingAirlineCode = marketingAirlineCode;
    }

    public String getOperatingAirlineName() {
        return operatingAirlineName;
    }

    public void setOperatingAirlineName(String operatingAirlineName) {
        this.operatingAirlineName = operatingAirlineName;
    }

    public String getOperatingAirlineCode() {
        return operatingAirlineCode;
    }

    public void setOperatingAirlineCode(String operatingAirlineCode) {
        this.operatingAirlineCode = operatingAirlineCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightBookingDetail getFlightBookingDetail() {
        return flightBookingDetail;
    }

    public void setFlightBookingDetail(FlightBookingDetail flightBookingDetail) {
        this.flightBookingDetail = flightBookingDetail;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass) {
        this.bookingClass = bookingClass;
    }
}
