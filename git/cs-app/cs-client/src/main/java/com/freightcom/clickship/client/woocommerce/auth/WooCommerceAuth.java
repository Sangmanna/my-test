package com.freightcom.clickship.client.woocommerce.auth;

import com.freightcom.clickship.client.auth.OAuthConfig;

public final class WooCommerceAuth {

	private OAuthConfig oAuthConfig;

	private WooCommerceBasicAuth basicAuthConfig;

	public WooCommerceAuth(OAuthConfig oAuthConfig) {
		super();
		this.oAuthConfig = oAuthConfig;
	}
	
	public WooCommerceAuth(WooCommerceBasicAuth basicAuthConfig) {
		super();
		this.basicAuthConfig = basicAuthConfig;
	}

	public OAuthConfig getoAuthConfig() {
		return oAuthConfig;
	}

	public WooCommerceBasicAuth getBasicAuthConfig() {
		return basicAuthConfig;
	}

}
