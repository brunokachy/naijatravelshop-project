package com.naijatravelshop.persistence.model.flight;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "flight_booking_detail")
public class FlightBookingDetail implements Serializable {
    @Column(nullable = false)
    private Timestamp bookingDate;
    private String flightSummary;
    private Integer numberOfAdult = 1;
    private Integer numberOfChildren = 0;
    private Integer numberOfInfant = 0;
    private String pnr;
    private Boolean passwordRequired = false;
    private Boolean visaServiceRequested = false;
    private Boolean hotelServiceRequested = false;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getFlightSummary() {
        return flightSummary;
    }

    public void setFlightSummary(String flightSummary) {
        this.flightSummary = flightSummary;
    }

    public Integer getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(Integer numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Integer getNumberOfInfant() {
        return numberOfInfant;
    }

    public void setNumberOfInfant(Integer numberOfInfant) {
        this.numberOfInfant = numberOfInfant;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public Boolean getPasswordRequired() {
        return passwordRequired;
    }

    public void setPasswordRequired(Boolean passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    public Boolean getVisaServiceRequested() {
        return visaServiceRequested;
    }

    public void setVisaServiceRequested(Boolean visaServiceRequested) {
        this.visaServiceRequested = visaServiceRequested;
    }

    public Boolean getHotelServiceRequested() {
        return hotelServiceRequested;
    }

    public void setHotelServiceRequested(Boolean hotelServiceRequested) {
        this.hotelServiceRequested = hotelServiceRequested;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
