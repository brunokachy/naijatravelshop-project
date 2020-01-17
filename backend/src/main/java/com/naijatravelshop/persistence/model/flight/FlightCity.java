package com.naijatravelshop.persistence.model.flight;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "flight_city")
public class FlightCity implements Serializable {
    private String name;
    @Column(name = "iata_code")
    private String iataCode;
    private String latitude;
    private String longitude;
    private String timezone;
    private String gmt;
    private Integer popularityIndex;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "country_fk")
    private Long country;
}
