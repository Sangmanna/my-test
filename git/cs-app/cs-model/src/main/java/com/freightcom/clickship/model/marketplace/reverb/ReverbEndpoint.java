package com.freightcom.clickship.model.marketplace.reverb;

public enum ReverbEndpoint {
    
    GET_SHOP_ACCOUNT("/api/account"),
	GET_ORDERS("/api/my/orders/selling/all"),
	GET_ORDERS_ID("/api/my/orders/selling/%s"),
	GET_SECRET_TOKEN("/oauth/token"),
	// https://sandbox.reverb.com/api/my/orders/selling/all
	GET_OFFERS("/api/offers"),
	GET_OFFER("/api/offers/%s"),
	SHIPMENT_URL("/api/my/orders/selling/%s/ship"),
	GET_PRODUCTS("/api/my/listings"),
	GET_PRODUCTS_LISTING("/api/listings/%s"),
	UPDATE_PRODUCT("api/listings/%s"),
	CANCEL_FULFILLMENT("/api/shipments/delete/");
	
	
	


    private String value;

    ReverbEndpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
