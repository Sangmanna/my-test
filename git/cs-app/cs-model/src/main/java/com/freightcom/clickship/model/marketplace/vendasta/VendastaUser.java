package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaUser {
	
    @JsonProperty("name")
    private String name;
    
    private String password;
    
    private String username;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("family_name")
    private String familyName;

    @JsonProperty("namespace")
    private String nameSpace;

    @JsonProperty("legacy_user_id")
    private String legacyUserId;
    
	private Boolean isAgreeTerms;
	
	private String marketplaceUrl;

    @JsonProperty("product_navbar_data_url")
    private String productNavbarDataUrl;

    public String getName() {
        return name;
    }

    public VendastaUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getGivenName() {
        return givenName;
    }

    public VendastaUser setGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public VendastaUser setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public VendastaUser setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
        return this;
    }

    public String getLegacyUserId() {
        return legacyUserId;
    }

    public VendastaUser setLegacyUserId(String legacyUserId) {
        this.legacyUserId = legacyUserId;
        return this;
    }

    public String getProductNavbarDataUrl() {
        return productNavbarDataUrl;
    }

    public VendastaUser setProductNavbarDataUrl(String productNavbarDataUrl) {
        this.productNavbarDataUrl = productNavbarDataUrl;
        return this;
    }

	public String getPassword() {
		return password;
	}

	public VendastaUser setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public VendastaUser setUsername(String username) {
		this.username = username;
		return this;
	}

	public Boolean getIsAgreeTerms() {
		return isAgreeTerms;
	}

	public VendastaUser setIsAgreeTerms(Boolean isAgreeTerms) {
		this.isAgreeTerms = isAgreeTerms;
		return this;
	}

	public String getMarketplaceUrl() {
		return marketplaceUrl;
	}

	public VendastaUser setMarketplaceUrl(String marketplaceUrl) {
		this.marketplaceUrl = marketplaceUrl;
		return this;
	}
    
}
