package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceAddress {
	
	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("company")
	private String company;

	@JsonProperty("street_1")
	private String street1;

	@JsonProperty("street_2")
	private String street2;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("country")
	private String country;

	@JsonProperty("country_iso2")
	private String countryIso2;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("resource")
	private String resource;

	public String getFirstName() {
		return firstName;
	}

	public BigCommerceAddress setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public BigCommerceAddress setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public BigCommerceAddress setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getStreet1() {
		return street1;
	}

	public BigCommerceAddress setStreet1(String street1) {
		this.street1 = street1;
		return this;
	}

	public String getStreet2() {
		return street2;
	}

	public BigCommerceAddress setStreet2(String street2) {
		this.street2 = street2;
		return this;
	}

	public String getCity() {
		return city;
	}

	public BigCommerceAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public BigCommerceAddress setState(String state) {
		this.state = state;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public BigCommerceAddress setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public BigCommerceAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getCountryIso2() {
		return countryIso2;
	}

	public BigCommerceAddress setCountryIso2(String countryIso2) {
		this.countryIso2 = countryIso2;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public BigCommerceAddress setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public BigCommerceAddress setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public BigCommerceAddress setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getResource() {
		return resource;
	}

	public BigCommerceAddress setResource(String resource) {
		this.resource = resource;
		return this;
	}
	
}
