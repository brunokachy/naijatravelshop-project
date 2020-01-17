package com.naijatravelshop.service.flight.pojo.request;

import java.util.List;

/**
 * Created by Bruno on
 * 05/06/2019
 */
public class FlightDetailDTO {
    private Integer sequencyNumber;
    private Integer totalFare;
    private String currencyCode;
    private String ticketLimitTime;
    private String signature;
    private List<OriginDestinationOptionsDTO> originDestinationOptions;
    private String logo;

    public Integer getSequencyNumber() {
        return sequencyNumber;
    }

    public void setSequencyNumber(Integer sequencyNumber) {
        this.sequencyNumber = sequencyNumber;
    }

    public Integer getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(Integer totalFare) {
        this.totalFare = totalFare;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTicketLimitTime() {
        return ticketLimitTime;
    }

    public void setTicketLimitTime(String ticketLimitTime) {
        this.ticketLimitTime = ticketLimitTime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<OriginDestinationOptionsDTO> getOriginDestinationOptions() {
        return originDestinationOptions;
    }

    public void setOriginDestinationOptions(List<OriginDestinationOptionsDTO> originDestinationOptions) {
        this.originDestinationOptions = originDestinationOptions;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
