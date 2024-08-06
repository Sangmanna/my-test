package com.freightcom.clickship.model.marketplace.etsy.v3;

public enum EtsyEndpointV3 {
    
    SELF("__SELF__"),
    OAUTH_CONNECT("https://www.etsy.com/oauth/connect"),
    OAUTH_TOKEN("https://api.etsy.com/v3/public/oauth/token"),
    GET_SHOP_DETAILS("https://openapi.etsy.com/v3/application/shops"),
    USER_ADDRESS("https://openapi.etsy.com/v3/application/user/addresses"),
    GET_LISTING_BY_ID("https://openapi.etsy.com/v3/application/listings/%s"),
    GET_LISTINGS("https://openapi.etsy.com/v3/application/shops/%s/listings"),
    GET_RECEIPTS("https://openapi.etsy.com/v3/application/shops/%s/receipts"),
	GET_RECEIPT_BY_ID("https://openapi.etsy.com/v3/application/shops/%s/receipts/%s"),
	TRACKING("https://api.etsy.com/v3/application/shops/%s/receipts/%s/tracking");
	
	private String value;

    EtsyEndpointV3(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
