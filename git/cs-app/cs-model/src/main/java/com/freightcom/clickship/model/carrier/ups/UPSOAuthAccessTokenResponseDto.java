package com.freightcom.clickship.model.carrier.ups;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UPSOAuthAccessTokenResponseDto {

    @JsonProperty("refresh_token_expires_in")
    private int refreshTokenExpiresIn;

    @JsonProperty("refresh_token_status")
    private String refreshTokenStatus;

    @JsonProperty("old_access_token_life_time")
    private int oldAccessTokenLifeTime;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("issued_at")
    private Date issuedAt;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("refresh_token_issued_at")
    private Date refreshTokenIssuedAt;

    @JsonProperty("expires_in")
    private int expiresIn;

    @JsonProperty("refresh_count")
    private int refreshCount;

    @JsonProperty("status")
    private String status;
    
	public int getRefreshTokenExpiresIn() {
		return refreshTokenExpiresIn;
	}

	public void setRefreshTokenExpiresIn(int refreshTokenExpiresIn) {
		this.refreshTokenExpiresIn = refreshTokenExpiresIn;
	}

	public String getRefreshTokenStatus() {
		return refreshTokenStatus;
	}

	public void setRefreshTokenStatus(String refreshTokenStatus) {
		this.refreshTokenStatus = refreshTokenStatus;
	}

	public int getOldAccessTokenLifeTime() {
		return oldAccessTokenLifeTime;
	}

	public void setOldAccessTokenLifeTime(int oldAccessTokenLifeTime) {
		this.oldAccessTokenLifeTime = oldAccessTokenLifeTime;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Date getRefreshTokenIssuedAt() {
		return refreshTokenIssuedAt;
	}

	public void setRefreshTokenIssuedAt(Date refreshTokenIssuedAt) {
		this.refreshTokenIssuedAt = refreshTokenIssuedAt;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public int getRefreshCount() {
		return refreshCount;
	}

	public void setRefreshCount(int refreshCount) {
		this.refreshCount = refreshCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}