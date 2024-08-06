package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceTokenRequest {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("type")
	private String type;

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("scope")
	private String scope;
	
	@JsonProperty("context")
	private String context;
	
	@JsonProperty("client_id")
	private String clientId;
	
	@JsonProperty("grant_type")
	private String grantType;

	@JsonProperty("redirect_uri")
	private String redirectUri;

	@JsonProperty("client_secret")
	private String clientSecret;
	
	@JsonProperty("signed_payload")
	private String signPayload;
	
	@JsonProperty("account_uuid")
	private String accountUuid;
	
	public String getId() {
		return id;
	}

	public BigCommerceTokenRequest setId(String id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public BigCommerceTokenRequest setType(String type) {
		this.type = type;
		return this;
	}

	public String getCode() {
		return code;
	}

	public BigCommerceTokenRequest setCode(String code) {
		this.code = code;
		return this;
	}

	public String getScope() {
		return scope;
	}

	public BigCommerceTokenRequest setScope(String scope) {
		this.scope = scope;
		return this;
	}

	public String getContext() {
		return context;
	}

	public BigCommerceTokenRequest setContext(String context) {
		this.context = context;
		return this;
	}

	public String getClientId() {
		return clientId;
	}

	public BigCommerceTokenRequest setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	public String getGrantType() {
		return grantType;
	}

	public BigCommerceTokenRequest setGrantType(String grantType) {
		this.grantType = grantType;
		return this;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public BigCommerceTokenRequest setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
		return this;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public BigCommerceTokenRequest setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
		return this;
	}

	public String getSignPayload() {
		return signPayload;
	}

	public BigCommerceTokenRequest setSignPayload(String signPayload) {
		this.signPayload = signPayload;
		return this;
	}

	public String getAccountUuid() {
		return accountUuid;
	}

	public BigCommerceTokenRequest setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
		return this;
	}

}
