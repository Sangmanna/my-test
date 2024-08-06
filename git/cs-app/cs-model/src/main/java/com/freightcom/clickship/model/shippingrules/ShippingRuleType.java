package com.freightcom.clickship.model.shippingrules;

public enum ShippingRuleType {

    REAL_TIME_RATE_PROPERTY("Real Time Rate Property"),
    EXISTING_ORDER_PROPERTY("Existing Order Property");

    private String type;

    ShippingRuleType(String s) {
        this.type = s;
    }

    public String getType() {
        return type;
    }
}
