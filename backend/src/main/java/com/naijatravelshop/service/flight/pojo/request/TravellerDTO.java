package com.naijatravelshop.service.flight.pojo.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Bruno on
 * 18/05/2019
 */
@Getter
@Setter
public class TravellerDTO implements Serializable {

    private String firstName;
    private String lastName;
    private String address;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String title;
    private Integer titleCode;
    private String countryCode;
    private String city;
    private String countryName;
    private Integer age;


}
