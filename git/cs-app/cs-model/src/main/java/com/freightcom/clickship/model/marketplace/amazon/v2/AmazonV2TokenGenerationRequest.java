package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2TokenGenerationRequest {

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("code")
    private String code;

    @JsonProperty("redirect_uri")
    private String redirectUri;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("refresh_token")
    private String refreshToken;

    public String getGrantType() {
        return grantType;
    }

    public AmazonV2TokenGenerationRequest setGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AmazonV2TokenGenerationRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public AmazonV2TokenGenerationRequest setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public AmazonV2TokenGenerationRequest setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public AmazonV2TokenGenerationRequest setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public AmazonV2TokenGenerationRequest setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }
}
