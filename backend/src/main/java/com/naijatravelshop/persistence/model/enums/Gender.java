package com.naijatravelshop.persistence.model.enums;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

