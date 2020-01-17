package com.naijatravelshop.persistence.model.enums;

public enum AgeGroupType {

    ADULT("ADULT"),
    CHILD("CHILD"),
    INFANT("INFANT");

    private final String value;

    private AgeGroupType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
