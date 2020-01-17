package com.naijatravelshop.persistence.model.enums;

public enum UnitType {
    PERCENT("PERCENT"),
    AMOUNT_IN_KOBO ("AMOUNT_IN_KOBO");

    private final String value;

    UnitType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
