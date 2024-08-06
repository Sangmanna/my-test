package com.freightcom.clickship.model.marketplace.bestbuy;

public enum BestBuyEndpoint {
    
    GET_SHOP_ACCOUNT("/api/account"),
	GET_ORDERS("/api/orders"),
	GET_OFFERS("/api/offers"),
	GET_OFFER("/api/offers/%s"),
	SHIPMENT_URL("/api/shipments/"),
	CANCEL_FULFILLMENT("/api/shipments/delete/");


    private String value;

    BestBuyEndpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
