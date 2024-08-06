package com.freightcom.clickship.model.marketplace.lightspeed;

public enum ShipmentStatus {
    SHIPPED("shipped"),
    NOT_SHIPPED("not_shipped"),
    PARTIALLY_SHIPPED("partially_shipped"),
    CANCELLED("cancelled");

    private String value;

    private ShipmentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
