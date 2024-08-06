package com.freightcom.clickship.model.marketplace.ebay;

public enum EbayEndpoint {
    AUTH_EXCHANGE ("/identity/v1/oauth2/token"),
    ORDERS ("/sell/fulfillment/v1/order"),
    CREATE_SHIPMENT("/sell/fulfillment/v1/order/{orderId}/shipping_fulfillment"),
    PROFILE("/commerce/identity/v1/user"),
    GENERATE_TOKEN("/identity/%s/oauth2/token"),
    GET_IMAGE("/buy/browse/v1/item/get_item_by_legacy_id"),
    CANCEL_ORDER ("/post-order/v2/cancellation"),
    EBAY_AUTHORIZE_URL ("/oauth2/authorize"),
    GET_ORDER ("/sell/fulfillment/v1/order/{orderId}"),
    GET_USER_PROFILE ("/shopping"),
    GET_USER_STATUS("/ws/api.dll"),
    GET_PUBLIC_KEY("/commerce/notification/v1/public_key/{public_key_id}");

    private String value;

     EbayEndpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
