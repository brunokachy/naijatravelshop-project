package com.naijatravelshop.service.visa.pojo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Bruno on
 * 04/11/2019
 */
@Getter
@Setter
@ToString
@Builder
public class VisaCountryDTO implements Serializable {

    private String name;

    private Long id;

    private String status;
}
