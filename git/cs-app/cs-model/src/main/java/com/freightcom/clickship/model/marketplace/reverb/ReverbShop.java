package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbShop {
	@JsonProperty("description")
	private String description;
//	@JsonProperty("legal_country_code")
//	private String legalCountryCode;
	@JsonProperty("direct_checkout")
	private String directCheckout;
	@JsonProperty("name")
	private String name;
	@JsonProperty("slug")
	private String slug;
	@JsonProperty("id")
	private String id;
	@JsonProperty("payment_policy")
	private String paymentPolicy;
	@JsonProperty("website")
	private String website;
//	@JsonProperty("banner")
//	private String banner;

//	@JsonProperty("avatar")
//	private String avatar;
//	@JsonProperty("on_vacation")
//	private boolean onVacation;
//	@JsonProperty("tax_policies")
//	private String[] taxPolicies;
//	@JsonProperty("video_id")
//	private String videoId;
//	@JsonProperty("feedback_count")
//	private int feedbackCount;
//	@JsonProperty("feedback_count_formatted")
//	private String feedbackCountFormatted;
//	@JsonProperty("rating_percentage")
//	private Float ratingPercentage;
	
	@JsonProperty("address")
	private ReverbShopAddress address;
	
//	@JsonProperty("return_policies")
//	private ReverbReturnPolicies returnPolicies;
	
//	@JsonProperty("return_policy")
//	private String returnPolicy;
	
//	@JsonProperty("payment_methods")
//	private ReverbPaymentMethods paymentMethods;

//	@JsonProperty("belongs_to_requesting_user")
//	private boolean belongsToRequestingUser;
	
	@JsonProperty("user_uuid")
	private String userUuid;
	
	@JsonProperty("user_id")
	private String userId;
	
//	@JsonProperty("shipping_profiles")
//	private String[] shippingProfiles;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("onboarding_status")
	private String onboardingStatus;
	
//	@JsonProperty("_links")
//	private ReverbShopLinks shopLinks;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirectCheckout() {
		return directCheckout;
	}

	public void setDirectCheckout(String directCheckout) {
		this.directCheckout = directCheckout;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymentPolicy() {
		return paymentPolicy;
	}

	public void setPaymentPolicy(String paymentPolicy) {
		this.paymentPolicy = paymentPolicy;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public ReverbShopAddress getAddress() {
		return address;
	}

	public void setAddress(ReverbShopAddress address) {
		this.address = address;
	}


	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOnboardingStatus() {
		return onboardingStatus;
	}

	public void setOnboardingStatus(String onboardingStatus) {
		this.onboardingStatus = onboardingStatus;
	}
}
