package com.freightcom.clickship.model.shippingrules;

public enum ShippingRuleAction {
	
    SELECT_PACKAGE("Select Package"),
    FLAT_RATE_SHIPPING_COST("Select Flat-Rate Shipping Cost as..."),
    FREE_SHIPPING_COST("Set Shipping Cost as Free"),
    INSURANCE_FOR_SHIPMENT("Add Insurance and Signature"),
    SIGNATURE_REQUIRED("Add Signature");

    private final String action;

    ShippingRuleAction(String s) {
        this.action = s;
    }

    public static ShippingRuleAction findByAction(String action) {
        for (ShippingRuleAction v : values()) {
            if (v.action.equals(action)) {
                return v;
            }
        }
        return null;
    }
}
