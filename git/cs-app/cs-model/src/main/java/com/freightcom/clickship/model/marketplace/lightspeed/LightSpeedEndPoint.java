package com.freightcom.clickship.model.marketplace.lightspeed;

public enum LightSpeedEndPoint {
    
    SHOP("/%s/shop.json"),
    ORDERS("%s/orders.json"),
    ORDER("%s/orders/%s.json"),
    ACCOUNT("/%s/account.json"),
    VARIANTS("/%s/variants.json"),
    PRODUCTS("/%s/products.json"),	
    WEBHOOKS("/%s/webhooks.json"),
    VARIANT("/%s/variants/%s.json"),
    PRODUCT("/%s/products/%s.json"),
    WEBHOOK("/%s/webhooks/%s.json"),
    COMPANY("/%s/shop/company.json"),
    GET_SHIPMENT("%s/shipments.json"),
    ORDER_COUNT("%s/orders/count.json"),
    ORDERLINES("%s/orders/%s/products.json"),
    PRODUCT_COUNT("/%s/products/count.json"),
    WEBHOOKS_COUNT("/%s/webhooks/count.json"),
    RTR_CALLBACK_URL_NEW("%s/%s/lightspeed/%s"),
    CREATE_OR_CANCEL_SHIPMENT("%s/shipments/%s.json"),
	WEBHOOK_CALLBACK_URL("%s/%s/lightspeed/v2/%s/%s/%s"),
    CREATE_EXTERNAL_SERVICE("%s/external_services.json"),
    DELETE_EXTERNAL_SERVICE("/%s/external_services/%s.json"),
	RTR_CALLBACK_URL_OLD("%s/%s/lightspeed/clickship/getRates/%s");

    private String value;

    private LightSpeedEndPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
