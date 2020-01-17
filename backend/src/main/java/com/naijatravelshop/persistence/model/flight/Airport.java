package com.naijatravelshop.persistence.model.flight;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "airport")
@Getter
@Setter
@ToString
public class Airport implements Serializable {
    private String name;
    private String iataCode;
    private String icaoCode;
    private String latitude;
    private String longitude;
    private String timezone;
    private String gmt;
    private String contactPhone;
    private String website;
    private Integer popularityIndex;
    private Integer priority = 0;
    private Timestamp lastUpdate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "flight_city_fk")
    private Long flightCity;

}
