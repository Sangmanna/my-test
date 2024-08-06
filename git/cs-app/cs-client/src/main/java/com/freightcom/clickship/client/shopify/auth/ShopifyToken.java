package com.freightcom.clickship.client.shopify.auth;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyToken implements Serializable {
	
	private static final long serialVersionUID = -5857127480765540376L;

	@JsonProperty("access_token")
	private String token;
	
	@JsonProperty("scope")
	private String scope;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
