package com.freightcom.clickship.model.marketplace.amazon.v2;

public enum AmazonV2EndPoint {

    AUTH_URL("/auth/o2/token"),
    GET_TEMP_CREDENTIALS("/"),
    CREATE_REPORT("/reports/2021-06-30/reports"),
    GET_REPORT("/reports/2021-06-30/reports/%s"),
    CREATE_RDT("/tokens/2021-03-01/restrictedDataToken"),
    GET_ORDERS("/orders/v0/orders"),
    GET_ORDER("/orders/v0/orders/%s"),
    GET_ORDER_ITEMS("/orders/v0/orders/%s/orderItems"),
    GET_PRODUCT("/catalog/v0/items/%s"),
    FEEDS("/feeds/2021-06-30/feeds"),
    GET_FEED("/feeds/2021-06-30/feeds/%s"),
    FEED_DOCUMENTS("/feeds/2021-06-30/documents"),
    GET_FEED_DOCUMENT("/feeds/2021-06-30/documents/%s"),
    CONFIRM_SHIPMENT("/orders/v0/orders/%s/shipmentConfirmation");

    private String value;

    private AmazonV2EndPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
