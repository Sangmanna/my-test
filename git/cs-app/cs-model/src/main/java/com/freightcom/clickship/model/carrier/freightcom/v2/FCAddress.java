package com.freightcom.clickship.model.carrier.freightcom.v2;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FCAddress implements Serializable {

	private static final long serialVersionUID = -1675860263412997369L;

	@JsonProperty("address_line_1")
	private String addressLine1 = "";

	@JsonProperty("address_line_2")
	private String addressLine2;

	@JsonProperty("unit_number")
	private String unitNumber;

	@JsonProperty("city")
	private String city = "";

	@JsonProperty("region")
	private String region = "";

	@JsonProperty("country")
	private String country = "";

	@JsonProperty("postal_code")
	private String postalCode = "";

	public FCAddress addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public FCAddress addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public FCAddress unitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
		return this;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public FCAddress city(String city) {
		this.city = city;
		return this;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public FCAddress region(String region) {
		this.region = region;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public FCAddress country(String country) {
		this.country = country;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public FCAddress postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
