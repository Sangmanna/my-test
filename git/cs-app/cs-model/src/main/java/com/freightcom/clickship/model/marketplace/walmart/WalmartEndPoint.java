package com.freightcom.clickship.model.marketplace.walmart;

public enum WalmartEndPoint {
    ORDERS("/%s/ca/orders"),
    ITEMS("/%s/ca/items"),
    FULFILLMENT("%s/ca/orders/%s/shipping"),
    CANCEL_ORDER("%s/ca/orders/%s/cancel"),
    GET_INVENTORY("%s/ca/inventory"),
    UPDATE_INVENTORY("%s/ca/inventory"),
    GET_ORDER ("%s/ca/orders/%s"),
    GET_ITEM ("%s/ca/items/%s"),
    GET_FEED_STATUS("%s/ca/feeds");


    private String value;

    WalmartEndPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
