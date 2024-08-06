package com.freightcom.clickship.client.ebay.auth;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenGenerationResponse {

    @JsonProperty("access_token")
    private String accessToken;
   
    @JsonProperty("expires_in")
    private int accessCodeExpiryInSec;
    
    @JsonProperty("refresh_token")
    private String refreshToken;
    
    @JsonProperty("refresh_token_expires_in")
    private int refreshTokenExpiryInSec;
    
    @JsonProperty("token_type")
    private String tokenType;

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

    public int getAccessCodeExpiryInSec() {
        return accessCodeExpiryInSec;
    }

    public void setAccessCodeExpiryInSec(int accessCodeExpiryInSec) {
        this.accessCodeExpiryInSec = accessCodeExpiryInSec;
    }

    public int getRefreshTokenExpiryInSec() {
        return refreshTokenExpiryInSec;
    }

    public void setRefreshTokenExpiryInSec(int refreshTokenExpiryInSec) {
        this.refreshTokenExpiryInSec = refreshTokenExpiryInSec;
    }

}
