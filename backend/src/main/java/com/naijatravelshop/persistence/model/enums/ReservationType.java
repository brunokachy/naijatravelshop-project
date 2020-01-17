package com.naijatravelshop.persistence.model.enums;

public enum ReservationType {
    FLIGHT("FLIGHT"),
    HOTEL("HOTEL"),
    ACTIVITY("ACTIVITY"),
    INBOUND_CALL("INBOUND CALL"),
    VISA("VISA"),
    TRANSFER("TRANSFER");

    private final String value;

    ReservationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
