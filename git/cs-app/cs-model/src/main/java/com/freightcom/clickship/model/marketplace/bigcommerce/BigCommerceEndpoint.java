package com.freightcom.clickship.model.marketplace.bigcommerce;

public enum BigCommerceEndpoint {

    AUTH_URL("https://%s/oauth2/token"),
    STORE("https://%s/stores/%s/v2/store"),
    GET_ORDERS("https://%s/stores/%s/v2/orders"),
    GET_WEBHOOK("https://%s/stores/%s/v3/hooks"),
    WEBHOOK_CALLBACK_URL("%s/%s/bigcommerce/%s/%s"),
    ZONES("https://%s/stores/%s/v2/shipping/zones"),
    GET_ORDER_BY_ID("https://%s/stores/%s/v2/orders/%s"),
    GET_PRODUCTS("https://%s/stores/%s/v3/catalog/products"),
    GET_ORDERLINE("https://%s/stores/%s/v2/orders/%s/products"),
    GET_SHIPMENTS("https://%s/stores/%s/v2/orders/%s/shipments"),
    GET_PRODUCT_BY_ID("https://%s/stores/%s/v3/catalog/products/%s"),
    DELETE_SHIPMENT("https://%s/stores/%s/v2/orders/%s/shipments/%s"),
    SHIPPING_METHOD("https://%s/stores/%s/v2/shipping/zones/%s/methods"),
    GET_SHIPPINGADDRESS("https://%s/stores/%s/v2/orders/%s/shipping_addresses"),
    DELETE_SHIPPING_METHOD("https://%s/stores/%s/v2/shipping/zones/%s/methods/%s");

    private String value;

    private BigCommerceEndpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

