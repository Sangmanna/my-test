package com.freightcom.clickship.model.marketplace.etsy;

public enum EtsyEndpoint {
	COUNTRIES("https://openapi.etsy.com/v2/countries?api_key=%s"),
	GET_USER_ADDRESSES("https://openapi.etsy.com/v2/users/%s/addresses"),	
	GET_PRODUCT("https://openapi.etsy.com/v2/listings/%s"),	
	GET_PRODUCTS("https://openapi.etsy.com/v2/shops/%s/listings/%s"),
	GET_PRODUCT_IMAGES("https://openapi.etsy.com/v2/listings/%s/images"),	
	GET_PRODUCT_VARIANTS("https://openapi.etsy.com/v2/listings/%s/inventory"),
	SELF("__SELF__"),
	USER("https://openapi.etsy.com/v2/users/"),
	SHOPS("https://openapi.etsy.com/v2/shops/"),
	GET_ORDER("https://openapi.etsy.com/v2/receipts/%s"),
	SHIPPING("https://openapi.etsy.com/v2/shipping/info/"),
	GET_ORDERS("https://openapi.etsy.com/v2/shops/%s/receipts"),
	ACCESS_TOKEN("https://openapi.etsy.com/v2/oauth/access_token"),
	REQUEST_TOKEN("https://openapi.etsy.com/v2/oauth/request_token"),
	GET_SHOP_DETAILS("https://openapi.etsy.com/v2/shops/%s?api_key=%s"),
	TRAKCING("https://openapi.etsy.com/v2/shops/%s/receipts/%s/tracking"),
	GET_ORDERLINES("https://openapi.etsy.com/v2/receipts/%s/transactions");


	private String value;

	EtsyEndpoint(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
