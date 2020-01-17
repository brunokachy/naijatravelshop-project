package com.naijatravelshop.persistence.model.hotel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Entity
@Getter
@Setter
@ToString
public class HotelCity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String countryName;

    @Column
    private String countryCode;


}
