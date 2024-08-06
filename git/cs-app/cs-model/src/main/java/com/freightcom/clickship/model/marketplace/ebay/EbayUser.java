package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EbayUser {
    @JsonProperty("UserID")
    private String UserID;

    @JsonProperty("RegistrationSite")
    private String RegistrationSite;

    @JsonProperty("Status")
    private String Status;
    
    @JsonProperty("SellerItemsURL")
    private String itemUrl;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getRegistrationSite() {
        return RegistrationSite;
    }

    public void setRegistrationSite(String registrationSite) {
        RegistrationSite = registrationSite;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
    
}