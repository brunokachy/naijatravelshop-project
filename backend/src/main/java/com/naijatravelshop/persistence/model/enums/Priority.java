package com.naijatravelshop.persistence.model.enums;

public enum Priority {
    HIGH("ACTIVE"),
    MEDIUM("DELETED"),
    LOW("INACTIVE");

    private final String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


