package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceStore {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("store_id")
	private String storeId;

	@JsonProperty("account_uuid")
	private String uuid;

	@JsonProperty("domain")
	private String domain;

	@JsonProperty("secure_url")
	private String secureUrl;

	@JsonProperty("control_panel_base_url")
	private String adminUrl;

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("country_code")
	private String countryCode;
	
	@JsonProperty("language")
	private String language;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("weight_units")
	private String weightUnit;
	
	@JsonProperty("dimension_units")
	private String dimensionUnit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSecureUrl() {
		return secureUrl;
	}

	public void setSecureUrl(String secureUrl) {
		this.secureUrl = secureUrl;
	}
	
	public String getAdminUrl() {
		return adminUrl;
	}

	public void setAdminUrl(String adminUrl) {
		this.adminUrl = adminUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getDimensionUnit() {
		return dimensionUnit;
	}

	public void setDimensionUnit(String dimensionUnit) {
		this.dimensionUnit = dimensionUnit;
	}

}
