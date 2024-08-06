package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceTokenResponse {

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("context")
	private String context;
	
	@JsonProperty("store_hash")
	private String storeHash;
	
	@JsonProperty("owner")
	private BigCommerceUserDetails owner;

	@JsonProperty("user")
	private BigCommerceUserDetails user;

	@JsonProperty("account_uuid")
	private String accountId;

	public String getAccessToken() {
		return accessToken;
	}

	public BigCommerceTokenResponse setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	public String getScope() {
		return scope;
	}

	public BigCommerceTokenResponse setScope(String scope) {
		this.scope = scope;
		return this;
	}

	public String getContext() {
		return context;
	}

	public BigCommerceTokenResponse setContext(String context) {
		this.context = context;
		return this;
	}

	public String getStoreHash() {
		return storeHash;
	}

	public BigCommerceTokenResponse setStoreHash(String storeHash) {
		this.storeHash = storeHash;
		return this;
	}

	public BigCommerceUserDetails getOwner() {
		return owner;
	}

	public BigCommerceTokenResponse setOwner(BigCommerceUserDetails owner) {
		this.owner = owner;
		return this;
	}

	public BigCommerceUserDetails getUser() {
		return user;
	}

	public BigCommerceTokenResponse setUser(BigCommerceUserDetails user) {
		this.user = user;
		return this;
	}

	public String getAccountId() {
		return accountId;
	}

	public BigCommerceTokenResponse setAccountId(String accountId) {
		this.accountId = accountId;
		return this;
	}

}
