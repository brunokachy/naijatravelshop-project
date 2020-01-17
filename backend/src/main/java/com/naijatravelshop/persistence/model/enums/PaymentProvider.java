package com.naijatravelshop.persistence.model.enums;

public enum PaymentProvider {

    ISW_WEBPAYDIRECT("ISW_WEBPAYDIRECT"),
    ISW_PAYDIRECT("ISW_PAYDIRECT"),
    ROSABON("ROSABON"),
    BANK("BANK"),
    PAYSTACK("PAYSTACK"),
    TRAVELBETA("TRAVELBETA"),
    FLUTTERWAVE_RAVEPAY("FLUTTERWAVE_RAVEPAY"),
    ISW_QUICKTELLER("ISW_QUICKTELLER"),
    NETPLUSPAY("NETPLUSPAY");

    private final String value;

    PaymentProvider(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
