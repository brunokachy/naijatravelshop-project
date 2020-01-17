package com.naijatravelshop.service.hotel.pojo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Bruno on
 * 27/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class RoomResponse implements Comparable<RoomResponse> {

    private Double roomPrice;

    private String name;

    @Override
    public int compareTo(RoomResponse roomResponse) {
        return (this.roomPrice < roomResponse.roomPrice ? -1 :
                (this.roomPrice == roomResponse.roomPrice ? 0 : 1));
    }
}
