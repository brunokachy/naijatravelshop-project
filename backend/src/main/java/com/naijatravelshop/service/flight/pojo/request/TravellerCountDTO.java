package com.naijatravelshop.service.flight.pojo.request;

/**
 * Created by Bruno on
 * 05/06/2019
 */
public class TravellerCountDTO {
    private Integer adults;

    private Integer children;

    private Integer infants;

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
    }
}
