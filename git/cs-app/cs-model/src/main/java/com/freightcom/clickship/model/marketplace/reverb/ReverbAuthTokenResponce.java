package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbAuthTokenResponce {
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("scope")
	private String scope;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("user")
	private ReverbAuthUser reverbAuthUser;
	@JsonProperty("shop")
	private ReverbAuthShop reverbAuthShop;
	
	public ReverbAuthUser getReverbAuthUser() {
		return reverbAuthUser;
	}

	public void setReverbAuthUser(ReverbAuthUser reverbAuthUser) {
		this.reverbAuthUser = reverbAuthUser;
	}

	public ReverbAuthShop getReverbAuthShop() {
		return reverbAuthShop;
	}

	public void setReverbAuthShop(ReverbAuthShop reverbAuthShop) {
		this.reverbAuthShop = reverbAuthShop;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
