package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixAddress {

	@JsonProperty("fullName")
	private WixFullName fullName;
//
//	@JsonProperty("street")
//	private String street;

	@JsonProperty("country")
	private String country;

	@JsonProperty("subdivision")
	private String subdivision;

	@JsonProperty("city")
	private String city;

	@JsonProperty("zipCode")
	private String zipCode;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("email")
	private String email;

	@JsonProperty("addressLine1")
	private String addressLine1;

	@JsonProperty("company")
	private String company;

	@JsonProperty("addressLine2")
	private String addressLine2;
	
	@JsonProperty("hint")
	private WixHint hint;
	

	public WixFullName getFullName() {
		return fullName;
	}

	public WixAddress setFullName(WixFullName fullName) {
		this.fullName = fullName;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public WixAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getSubdivision() {
		return subdivision;
	}

	public WixAddress setSubdivision(String subdivision) {
		this.subdivision = subdivision;
		return this;
	}

	public String getCity() {
		return city;
	}

	public WixAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public WixAddress setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public WixAddress setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public WixAddress setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public WixAddress setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public WixAddress setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public WixAddress setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

//	public String getStreet() {
//		return street;
//	}
//
//	public WixAddress setStreet(String street) {
//		this.street = street;
//		return this;
//	}

	public WixHint getHint() {
		return hint;
	}

	public WixAddress setHint(WixHint hint) {
		this.hint = hint;
		return this;
	}

}
