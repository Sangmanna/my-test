package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbUser {
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("state")
	private String state;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("shipping_region_code")
	private String shippingRegionCode;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("activated")
	private boolean activated;
	@JsonProperty("profile_slug")
	private String profileSlug;
//	@JsonProperty("roles")
//	private String[] roles;
	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("locale_code")
	private String localeCode;
//	@JsonProperty("accepts_marketing_emails")
//	private boolean acceptsMarketingEmails;
//	@JsonProperty("third_party_ad_data_consent")
//	private boolean thirdPartyAdDataConsent;
	@JsonProperty("shop")
	private ReverbShop shop;
//	@JsonProperty("_links")
//	private ReverbUserLink links;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getShippingRegionCode() {
		return shippingRegionCode;
	}
	public void setShippingRegionCode(String shippingRegionCode) {
		this.shippingRegionCode = shippingRegionCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public String getProfileSlug() {
		return profileSlug;
	}
	public void setProfileSlug(String profileSlug) {
		this.profileSlug = profileSlug;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getLocaleCode() {
		return localeCode;
	}
	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
	public ReverbShop getShop() {
		return shop;
	}
	public void setShop(ReverbShop shop) {
		this.shop = shop;
	}
}
