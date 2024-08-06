package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SquareSpaceTokenGenerationResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("access_token_expires_at")
    private int accessCodeExpiryAt;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("refresh_token_expires_at")
    private int refreshTokenExpiryAt;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("account_id")
    private String accountId;

    public String getAccessToken() {
        return accessToken;
    }

    public SquareSpaceTokenGenerationResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public SquareSpaceTokenGenerationResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public int getAccessCodeExpiryAt() {
        return accessCodeExpiryAt;
    }

    public SquareSpaceTokenGenerationResponse setAccessCodeExpiryAt(int accessCodeExpiryAt) {
        this.accessCodeExpiryAt = accessCodeExpiryAt;
        return this;
    }

    public int getRefreshTokenExpiryAt() {
        return refreshTokenExpiryAt;
    }

    public SquareSpaceTokenGenerationResponse setRefreshTokenExpiryAt(int refreshTokenExpiryAt) {
        this.refreshTokenExpiryAt = refreshTokenExpiryAt;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public SquareSpaceTokenGenerationResponse setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public SquareSpaceTokenGenerationResponse setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }
}
