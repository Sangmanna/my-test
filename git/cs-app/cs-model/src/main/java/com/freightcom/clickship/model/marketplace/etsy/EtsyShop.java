package com.freightcom.clickship.model.marketplace.etsy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyShop implements Serializable {

	private static final long serialVersionUID = -8840676413668872992L;

	@JsonProperty("shop_id")
	public Integer shopId;

	@JsonProperty("shop_name")
	public String shopName;

	@JsonProperty("user_id")
	public Integer userId;

	@JsonProperty("creation_tsz")
	public Float creationTsz;

	@JsonProperty("title")
	public String title;

	@JsonProperty("announcement")
	public String announcement;

	@JsonProperty("currency_code")
	public String currencyCode;

	@JsonProperty("is_vacation")
	public Boolean isVacation;

	@JsonProperty("vacation_message")
	public String vacationMessage;

	@JsonProperty("sale_message")
	public String saleMessage;

	@JsonProperty("digital_sale_message")
	public String digitalSaleMessage;

	@JsonProperty("last_updated_tsz")
	public Float lastUpdatedTsz;

	@JsonProperty("listing_active_count")
	public Integer listingActiveCount;

	@JsonProperty("digital_listing_count")
	public Integer digitalListingCount;

	@JsonProperty("login_name")
	public String loginName;

	@JsonProperty("accepts_custom_requests")
	public Boolean acceptsCustomRequests;

	@JsonProperty("policy_welcome")
	public String policyWelcome;

	@JsonProperty("policy_payment")
	public String policyPayment;

	@JsonProperty("policy_shipping")
	public String policyShipping;

	@JsonProperty("policy_refunds")
	public String policyRefunds;

	@JsonProperty("policy_additional")
	public String policyAdditional;

	@JsonProperty("policy_seller_info")
	public String policySellerInfo;

	@JsonProperty("policy_updated_tsz")
	public Float policyUpdatedTsz;

	@JsonProperty("policy_has_private_receipt_info")
	public Boolean policyHasPrivateReceiptInfo;

	@JsonProperty("vacation_autoreply")
	public String vacationAutoreply;

	@JsonProperty("url")
	public String url;

	@JsonProperty("image_url_760x100")
	public String imageUrl_760x100;

	@JsonProperty("num_favorers")
	public Integer numFavorers;

	@JsonProperty("languages")
	public ArrayList<String> languages;

	@JsonProperty("upcoming_local_event_id")
	public Integer upcomingLocalEventId;

	@JsonProperty("icon_url_fullxfull")
	public String iconUrlFullxfull;

	@JsonProperty("is_using_structured_policies")
	public Boolean isUsingStructuredPolicies;

	@JsonProperty("has_onboarded_structured_policies")
	public Boolean hasOnboardedStructuredPolicies;

	@JsonProperty("has_unstructured_policies")
	public Boolean hasUnStructuredPolicies;

	@JsonProperty("first_line")
	private String firstLine;

	@JsonProperty("second_line")
	private String secondLine;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("country_id")
	private Integer countryId;

	@JsonProperty("lat")
	private Float lat;

	@JsonProperty("lon")
	private Float lon;

	@JsonProperty("ga_code")
	private String gaCode;

	@JsonProperty("name")
	private String name;

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Float getCreationTsz() {
		return creationTsz;
	}

	public void setCreationTsz(Float creationTsz) {
		this.creationTsz = creationTsz;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Boolean getVacation() {
		return isVacation;
	}

	public void setVacation(Boolean vacation) {
		isVacation = vacation;
	}

	public String getVacationMessage() {
		return vacationMessage;
	}

	public void setVacationMessage(String vacationMessage) {
		this.vacationMessage = vacationMessage;
	}

	public String getSaleMessage() {
		return saleMessage;
	}

	public void setSaleMessage(String saleMessage) {
		this.saleMessage = saleMessage;
	}

	public String getDigitalSaleMessage() {
		return digitalSaleMessage;
	}

	public void setDigitalSaleMessage(String digitalSaleMessage) {
		this.digitalSaleMessage = digitalSaleMessage;
	}

	public Float getLastUpdatedTsz() {
		return lastUpdatedTsz;
	}

	public void setLastUpdatedTsz(Float lastUpdatedTsz) {
		this.lastUpdatedTsz = lastUpdatedTsz;
	}

	public Integer getListingActiveCount() {
		return listingActiveCount;
	}

	public void setListingActiveCount(Integer listingActiveCount) {
		this.listingActiveCount = listingActiveCount;
	}

	public Integer getDigitalListingCount() {
		return digitalListingCount;
	}

	public void setDigitalListingCount(Integer digitalListingCount) {
		this.digitalListingCount = digitalListingCount;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public Boolean getAcceptsCustomRequests() {
		return acceptsCustomRequests;
	}

	public void setAcceptsCustomRequests(Boolean acceptsCustomRequests) {
		this.acceptsCustomRequests = acceptsCustomRequests;
	}

	public String getPolicyWelcome() {
		return policyWelcome;
	}

	public void setPolicyWelcome(String policyWelcome) {
		this.policyWelcome = policyWelcome;
	}

	public String getPolicyPayment() {
		return policyPayment;
	}

	public void setPolicyPayment(String policyPayment) {
		this.policyPayment = policyPayment;
	}

	public String getPolicyShipping() {
		return policyShipping;
	}

	public void setPolicyShipping(String policyShipping) {
		this.policyShipping = policyShipping;
	}

	public String getPolicyRefunds() {
		return policyRefunds;
	}

	public void setPolicyRefunds(String policyRefunds) {
		this.policyRefunds = policyRefunds;
	}

	public String getPolicyAdditional() {
		return policyAdditional;
	}

	public void setPolicyAdditional(String policyAdditional) {
		this.policyAdditional = policyAdditional;
	}

	public String getPolicySellerInfo() {
		return policySellerInfo;
	}

	public void setPolicySellerInfo(String policySellerInfo) {
		this.policySellerInfo = policySellerInfo;
	}

	public Float getPolicyUpdatedTsz() {
		return policyUpdatedTsz;
	}

	public void setPolicyUpdatedTsz(Float policyUpdatedTsz) {
		this.policyUpdatedTsz = policyUpdatedTsz;
	}

	public Boolean getPolicyHasPrivateReceiptInfo() {
		return policyHasPrivateReceiptInfo;
	}

	public void setPolicyHasPrivateReceiptInfo(Boolean policyHasPrivateReceiptInfo) {
		this.policyHasPrivateReceiptInfo = policyHasPrivateReceiptInfo;
	}

	public String getVacationAutoreply() {
		return vacationAutoreply;
	}

	public void setVacationAutoreply(String vacationAutoreply) {
		this.vacationAutoreply = vacationAutoreply;
	}

	public String getGaCode() {
		return gaCode;
	}

	public void setGaCode(String gaCode) {
		this.gaCode = gaCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageUrl_760x100() {
		return imageUrl_760x100;
	}

	public void setImageUrl_760x100(String imageUrl_760x100) {
		this.imageUrl_760x100 = imageUrl_760x100;
	}

	public Integer getNumFavorers() {
		return numFavorers;
	}

	public void setNumFavorers(Integer numFavorers) {
		this.numFavorers = numFavorers;
	}

	public ArrayList<String> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<String> languages) {
		this.languages = languages;
	}

	public Integer getUpcomingLocalEventId() {
		return upcomingLocalEventId;
	}

	public void setUpcomingLocalEventId(Integer upcomingLocalEventId) {
		this.upcomingLocalEventId = upcomingLocalEventId;
	}

	public String getIconUrlFullxfull() {
		return iconUrlFullxfull;
	}

	public void setIconUrlFullxfull(String iconUrlFullxfull) {
		this.iconUrlFullxfull = iconUrlFullxfull;
	}

	public Boolean getUsingStructuredPolicies() {
		return isUsingStructuredPolicies;
	}

	public void setUsingStructuredPolicies(Boolean usingStructuredPolicies) {
		isUsingStructuredPolicies = usingStructuredPolicies;
	}

	public Boolean getHasOnboardedStructuredPolicies() {
		return hasOnboardedStructuredPolicies;
	}

	public void setHasOnboardedStructuredPolicies(Boolean hasOnboardedStructuredPolicies) {
		this.hasOnboardedStructuredPolicies = hasOnboardedStructuredPolicies;
	}

	public Boolean getHasUnStructuredPolicies() {
		return hasUnStructuredPolicies;
	}

	public void setHasUnStructuredPolicies(Boolean hasUnStructuredPolicies) {
		this.hasUnStructuredPolicies = hasUnStructuredPolicies;
	}
}
