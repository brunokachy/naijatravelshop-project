package com.naijatravelshop.persistence.model.portal;

import javax.persistence.*;

/**
 * Created by Bruno on
 * 11/05/2019
 */
@Entity
@Table(name = "cancellation_policy")
public class CancellationPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String startDate;

    private String endDate;

    private Long penalty;

    @ManyToOne
    private Reservation reservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getPenalty() {
        return penalty;
    }

    public void setPenalty(Long penalty) {
        this.penalty = penalty;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
