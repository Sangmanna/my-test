package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SquareSpaceTokenGenerationRequest {
    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("code")
    private String code;

    @JsonProperty("redirect_uri")
    private String redirectUri;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("refresh_token")
    private String refreshToken;

    public String getGrantType() {
        return grantType;
    }

    public SquareSpaceTokenGenerationRequest setGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    public String getCode() {
        return code;
    }

    public SquareSpaceTokenGenerationRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public SquareSpaceTokenGenerationRequest setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public SquareSpaceTokenGenerationRequest setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public SquareSpaceTokenGenerationRequest setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }
}
