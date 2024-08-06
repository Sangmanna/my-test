package com.freightcom.clickship.model.marketplace.wix;

public class WixConstants {

	public static final String AND = "&";
	public static final String QUERY_PARAM = "?";

	public static final String STATE = "state=";
	public static final String APP_ID = "appId=";
	public static final String HTTPS_PROTOCALL = "https://";
	public static final String REDIRECT_URL = "redirectUrl=";

	public static final String CODE = "code";
	public static final String CLIENT_ID = "client_id";
	public static final String GRANT_TYPE = "grant_type";
	public static final String CLIENT_SECRET = "client_secret";
	public static final String REFRESH_TOKEN = "refresh_token";
	public static final String AUTHORIZATION = "Authorization";
	public static final String AUTHORIZATION_CODE = "authorization_code";
	
	//order statuses
	
	public static final String CANCELED = "CANCELED";
	public static final String FULFILLED = "FULFILLED";
	public static final String NOT_FULFILLED = "NOT_FULFILLED";
	public static final String ORDER_FULFILLED = "ORDER_FULFILLED";
	public static final String PARTIALLY_FULFILLED = "PARTIALLY_FULFILLED";
	
	// Wix payment statuses
	public static final String PAYMENT_PAID = "PAID";
	public static final String PAYMENT_PENDING = "PENDING";
	public static final String PAYMENT_NOT_PAID = "NOT_PAID";
	public static final String PAYMENT_FULLY_REFUNDED = "FULLY_REFUNDED";
	public static final String PAYMENT_PARTIALLY_REFUNDED = "PARTIALLY_REFUNDED";
	public static final String PAYMENT_UNSPECIFIED_PAYMENT_STATUS = "UNSPECIFIED_PAYMENT_STATUS";
	
	public static final String ECOM = "ecom";
	public static final String STORE = "store";

	private WixConstants() {
		throw new IllegalStateException("Utility class");
	}
}
