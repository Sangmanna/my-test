package com.freightcom.clickship.client.woocommerce.auth;

import java.util.Base64;

import com.freightcom.clickship.client.auth.BasicAuthConfig;

/**
 * 
 * Custom BasicAuth class for WooCommerce API. Occasionally some servers may
 * not parse the BasicAuth Authorization header correctly and throws 401 error.
 * In that case we need provide the consumer key and secret as query string 
 * parameters instead.
 * 
 */
public class WooCommerceBasicAuth extends BasicAuthConfig {

	private final String consumerKey;
    private final String consumerSecret;
    private final String encodedBasicAuth;
    
    public WooCommerceBasicAuth(String url, String key, String secret) {
		super(url, key);

		String token = key +":"+ secret;
        
		this.consumerKey = key;
        this.consumerSecret = secret;
		this.encodedBasicAuth = Base64.getEncoder().encodeToString(token.getBytes());
        super.basicAuth = String.format(BASIC_AUTH, encodedBasicAuth);
	}

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }
    
    public String getEncodedBasicAuth() {
    	return encodedBasicAuth;
    }

}
