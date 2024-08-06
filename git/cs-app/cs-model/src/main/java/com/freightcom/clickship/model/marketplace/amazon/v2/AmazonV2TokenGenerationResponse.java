package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2TokenGenerationResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public AmazonV2TokenGenerationResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public AmazonV2TokenGenerationResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public AmazonV2TokenGenerationResponse setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public AmazonV2TokenGenerationResponse setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
