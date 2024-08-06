package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyStore implements Serializable {

	private static final long serialVersionUID = -883552355298712270L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("myshopify_domain")
	private String domain;
	
	@JsonProperty("province")
	private String province;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("address1")
	private String address1;
	
	@JsonProperty("address2")
	private String address2;
	
	@JsonProperty("zip")
	private String postalCode;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("source")
	private String source;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("primary_locale")
	private String locale;	
	
	@JsonProperty("province_code")
	private String provinceCode;
	
	@JsonProperty("country_name")
	private String countryName;
	
	@JsonProperty("country_code")
	private String countryCode;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("timezone")
	private String timezone;
	
	@JsonProperty("weight_unit")
	private String weightUnit;
	
	@JsonProperty("shop_owner")
	private String shopOwner;
	
	@JsonProperty("plan_name")
	private String planName;
	
	@JsonProperty("primary_location_id")
	private Long primaryLocationId;
	
	@JsonProperty("multi_location_enabled")
	private boolean multiLocation;
	
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(String shopOwner) {
		this.shopOwner = shopOwner;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Long getPrimaryLocationId() {
		return primaryLocationId;
	}

	public void setPrimaryLocationId(Long primaryLocationId) {
		this.primaryLocationId = primaryLocationId;
	}
	
	public boolean isMultiLocation() {
		return multiLocation;
	}

	public void setMultiLocation(boolean multiLocation) {
		this.multiLocation = multiLocation;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
