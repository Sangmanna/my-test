package com.freightcom.clickship.model.marketplace.squarespace;

public enum SquareSpaceEndPoint {

    AUTH_URL("/api/1/login/oauth/provider/tokens"),
    WEBSITE_INFO("/%s/authorization/website"),
    PRODUCTS("/%s/commerce/products"),
    ORDERS("/%s/commerce/orders"),
    WEBHOOKS("/%s/webhook_subscriptions"),
    GET_PRODUCT("/%s/commerce/products/%s"),
    UPDATE_INVENTORY("/%s/commerce/inventory/adjustments"),
    GET_ORDER("/%s/commerce/orders/%s"),
    CREATE_SHIPMENT("/%s/commerce/orders/%s/fulfillments"),
    WEBHOOK("/%s/webhook_subscriptions/%s"),
    WEBHOOK_CALLBACK_URL("%s/%s/squarespace/%s");

    private String value;

    private SquareSpaceEndPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
