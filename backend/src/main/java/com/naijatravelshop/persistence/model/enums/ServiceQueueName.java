package com.naijatravelshop.persistence.model.enums;

public enum ServiceQueueName {

    INBOUND_CALL("INBOUND CALL"),
    VISA_REQUEST("VISA REQUEST"),
    FLIGHT_RESERVATION("FLIGHT RESERVATION"),
    HOTEL_RESERVATION("HOTEL RESERVATION");
//    FLIGHT_FAILED_BOOKING("FLIGHT FAILED BOOKING"),
//    FLIGHT_PENDING_PAYMENT("FLIGHT PENDING PAYMENT"),
//    FIGHT_WEB_PAYMENT("FLIGHT WEB PAYMENT");

    private final String value;

    ServiceQueueName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
