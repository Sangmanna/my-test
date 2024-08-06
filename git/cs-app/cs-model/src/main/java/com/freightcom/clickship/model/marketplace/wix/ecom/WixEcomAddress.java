package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomAddress {

	@JsonProperty("country")
	private String country;

	@JsonProperty("subdivision")
	private String subdivision;

	@JsonProperty("city")
	private String city;

	@JsonProperty("postalCode")
	private String postalCode;

	@JsonProperty("addressLine")
	private String addressLine;

	@JsonProperty("addressLine2")
	private String addressLine2;

	@JsonProperty("countryFullname")
	private String countryFullname;

	@JsonProperty("subdivisionFullname")
	private String subdivisionFullname;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountryFullname() {
		return countryFullname;
	}

	public void setCountryFullname(String countryFullname) {
		this.countryFullname = countryFullname;
	}

	public String getSubdivisionFullname() {
		return subdivisionFullname;
	}

	public void setSubdivisionFullname(String subdivisionFullname) {
		this.subdivisionFullname = subdivisionFullname;
	}
}
