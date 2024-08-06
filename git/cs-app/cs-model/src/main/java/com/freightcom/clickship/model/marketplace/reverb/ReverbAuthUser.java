package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbAuthUser {
	@JsonProperty("id")
	private String id;
	@JsonProperty("shipping_region_code")
	private String shippingRegionCode;
	@JsonProperty("display_currency")
	private String displayCurrency;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("third_party_ad_data_consent")
	private String thirdPartyAdDataConsent;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShippingRegionCode() {
		return shippingRegionCode;
	}
	public void setShippingRegionCode(String shippingRegionCode) {
		this.shippingRegionCode = shippingRegionCode;
	}
	public String getDisplayCurrency() {
		return displayCurrency;
	}
	public void setDisplayCurrency(String displayCurrency) {
		this.displayCurrency = displayCurrency;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getThirdPartyAdDataConsent() {
		return thirdPartyAdDataConsent;
	}
	public void setThirdPartyAdDataConsent(String thirdPartyAdDataConsent) {
		this.thirdPartyAdDataConsent = thirdPartyAdDataConsent;
	}
}
