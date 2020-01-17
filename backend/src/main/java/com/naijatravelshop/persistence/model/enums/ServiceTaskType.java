package com.naijatravelshop.persistence.model.enums;

public enum ServiceTaskType {

    UPDATE_TASK("UPDATE TASK"),
    RE_ASSIGN("RE-ASSIGN"),
    NEW_TASK("NEW TASK"),
    TICKETING_REQUEST("TICKETING REQUEST");

    private final String value;

    ServiceTaskType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
