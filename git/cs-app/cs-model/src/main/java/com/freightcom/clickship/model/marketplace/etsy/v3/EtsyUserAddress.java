package com.freightcom.clickship.model.marketplace.etsy.v3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyUserAddress extends EtsyBaseDTO {

	private static final long serialVersionUID = 4312759036820038157L;

	@JsonProperty("user_address_id")
	private Long id;

	@JsonProperty("user_id")
	private Long userId;

	@JsonProperty("name")
	private String name;

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

	@JsonProperty("iso_country_code")
	private String countryCode;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("is_default_shipping_address")
	private Boolean isDefault;

	public Long getId() {
		return id;
	}

	public EtsyUserAddress setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public EtsyUserAddress setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getName() {
		return name;
	}

	public EtsyUserAddress setName(String name) {
		this.name = name;
		return this;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public EtsyUserAddress setFirstLine(String firstLine) {
		this.firstLine = firstLine;
		return this;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public EtsyUserAddress setSecondLine(String secondLine) {
		this.secondLine = secondLine;
		return this;
	}

	public String getCity() {
		return city;
	}

	public EtsyUserAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public EtsyUserAddress setState(String state) {
		this.state = state;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public EtsyUserAddress setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public EtsyUserAddress setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public String getCountryName() {
		return countryName;
	}

	public EtsyUserAddress setCountryName(String countryName) {
		this.countryName = countryName;
		return this;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public EtsyUserAddress setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
		return this;
	}

}
