package com.naijatravelshop.persistence.model.enums;

public enum RoleType {
    SUPER_ADMIN("SUPER ADMIN"),
    PORTAL_USER("PORTAL USER"),
    GUEST("GUEST"),
    SUPERVISOR("SUPERVISOR"),
    FINANCE_OFFICER("FINANCE OFFICER"),
    PRICING_OFFICER("PRICING OFFICER"),
    VISA_CONSULTANT("VISA CONSULTANT"),
    TRAVEL_CONSULTANT("TRAVEL CONSULTANT"),
    HOTEL_CONSULTANT("HOTEL CONSULTANT"),
    CUSTOMER_SUPPORT("CUSTOMER SUPPORT"),
    TICKETING_OFFICER("TICKETING OFFICER");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
