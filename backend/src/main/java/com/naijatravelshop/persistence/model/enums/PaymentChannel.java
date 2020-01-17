package com.naijatravelshop.persistence.model.enums;

public enum PaymentChannel {

    WEB("WEB"),
    BOOK_ON_HOLD("BOOK_ON_HOLD"),
    BANK_PAYMENT("BANK PAYMENT"),
    BOOK_NOW_PAY_LATER("BOOK NOW PAY LATER");


    private final String value;

    PaymentChannel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
