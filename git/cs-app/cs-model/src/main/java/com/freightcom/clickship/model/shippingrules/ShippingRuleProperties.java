package com.freightcom.clickship.model.shippingrules;

public enum ShippingRuleProperties {
    
	MARKETPLACE("Marketplace"),
    ORDER_VALUE("Order Value"),
    ORDER_WEIGHT("Order Weight"),
    SHIPPING_DESTINATION("Shipping Destination");

    private final String property;

    ShippingRuleProperties(String s) {
        this.property = s;
    }

    public static ShippingRuleProperties findByAction(String action) {
        for (ShippingRuleProperties v : values()) {
            if (v.property.equals(action)) {
                return v;
            }
        }
        return null;
    }
}
