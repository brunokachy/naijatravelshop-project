package com.naijatravelshop.persistence.model.enums;

public enum ProcessStatus {
    SUCCESSFUL("SUCCESSFUL"),
    PENDING("PENDING"),
    CANCELLED("CANCELLED"),
    FAILED("FAILED"),
    DECLINED("DECLINED"),
    NO_LONGER_VALID("NO_LONGER_VALID"),
    PROCESSED("PROCESSED");


    private final String value;

    ProcessStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
