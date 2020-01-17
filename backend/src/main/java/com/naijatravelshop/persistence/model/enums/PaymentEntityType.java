package com.naijatravelshop.persistence.model.enums;

public enum PaymentEntityType {
    RESERVATION("RESERVATION");

    private final String value;

    PaymentEntityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
