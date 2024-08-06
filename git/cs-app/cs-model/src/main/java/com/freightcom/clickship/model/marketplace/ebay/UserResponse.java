package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    @JsonProperty("accountType")
    private String accountType = null;

    @JsonProperty("registrationMarketplaceId")
    private String registrationMarketplaceId = null;

    @JsonProperty("userId")
    private String userId = null;

    @JsonProperty("username")
    private String username = null;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getRegistrationMarketplaceId() {
        return registrationMarketplaceId;
    }

    public void setRegistrationMarketplaceId(String registrationMarketplaceId) {
        this.registrationMarketplaceId = registrationMarketplaceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
