package com.freightcom.clickship.client.shopify.auth;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOAuthRequest implements Serializable {
	
	private static final long serialVersionUID = -4227828686034105001L;

	@JsonProperty("client_id")
	private String key;
	
	@JsonProperty("client_secret")
	private String secret;
	
	@JsonProperty("code")
	private String code;
	
	public ShopifyOAuthRequest(String key, String secret, String code) {
		super();
		this.key = key;
		this.secret = secret;
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public String getSecret() {
		return secret;
	}

	public String getCode() {
		return code;
	}

}
