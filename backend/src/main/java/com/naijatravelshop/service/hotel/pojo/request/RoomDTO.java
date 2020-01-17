package com.naijatravelshop.service.hotel.pojo.request;

import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Builder
@Getter
@Setter
@ToString
public class RoomDTO implements Serializable {
    private Integer numberOfAdults;
    private Integer numberOfChildren;
    private List<Integer> adultsAgeList;
    private List<Integer> childrenAgeList;
    private List<TravellerDTO> adultList;
    private List<TravellerDTO> childrenList;
}
