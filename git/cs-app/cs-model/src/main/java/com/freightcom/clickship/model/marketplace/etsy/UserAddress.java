package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAddress implements Serializable {

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

	@JsonProperty("country_id")
	private Long countryId;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("is_default_shipping")
	private Boolean isDefaultShipping;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Boolean getDefaultShipping() {
		return isDefaultShipping;
	}

	public void setDefaultShipping(Boolean defaultShipping) {
		isDefaultShipping = defaultShipping;
	}
}
