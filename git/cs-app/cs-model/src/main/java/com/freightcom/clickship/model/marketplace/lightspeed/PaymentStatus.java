package com.freightcom.clickship.model.marketplace.lightspeed;

public enum PaymentStatus {
    PAID("paid"),
    NOT_PAID("not_paid"),
    PARTIALLY_PAID("partially_paid"),
    CANCELLED("cancelled");

    private String value;

    private PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
