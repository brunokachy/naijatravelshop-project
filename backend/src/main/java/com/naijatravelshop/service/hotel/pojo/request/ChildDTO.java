package com.naijatravelshop.service.hotel.pojo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Builder
@Getter
@Setter
@ToString
public class ChildDTO {
    private String childNumber;

    private String childAge;
}
