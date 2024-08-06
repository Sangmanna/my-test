package com.freightcom.clickship.model.marketplace.etsy.v3;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyToken implements Serializable {

	private static final long serialVersionUID = -8840676413668871111L;

	@JsonProperty("grant_type")
	public String grantType;

	@JsonProperty("client_id")
	public String clientId;

	@JsonProperty("redirect_uri")
	public String redirectUrl;

	@JsonProperty("code")
	public String code;

	@JsonProperty("code_verifier")
	public String codeVerifier;

	@JsonProperty("access_token")
	public String accessToken;

	@JsonProperty("refresh_token")
	public String refreshToken;

	public String getGrantType() {
		return grantType;
	}

	public EtsyToken setGrantType(String grantType) {
		this.grantType = grantType;
		return this;
	}

	public String getClientId() {
		return clientId;
	}

	public EtsyToken setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public EtsyToken setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
		return this;
	}

	public String getCode() {
		return code;
	}

	public EtsyToken setCode(String code) {
		this.code = code;
		return this;
	}

	public String getCodeVerifier() {
		return codeVerifier;
	}

	public EtsyToken setCodeVerifier(String codeVerifier) {
		this.codeVerifier = codeVerifier;
		return this;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public EtsyToken setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public EtsyToken setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}
	
}
