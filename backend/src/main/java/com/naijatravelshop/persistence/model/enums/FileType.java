package com.naijatravelshop.persistence.model.enums;

public enum FileType {
    BMP("BMP"),
    PNG("PNG"),
    JPEG("JPEG"),
    GIF("GIF"),
    JPG("JPG");

    private final String value;

    private FileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
