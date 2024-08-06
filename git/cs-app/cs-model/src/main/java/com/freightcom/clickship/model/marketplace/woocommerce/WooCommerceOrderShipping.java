package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceOrderShipping implements Serializable {
	
	private static final long serialVersionUID = 4590836086103912634L;

	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	private String company;
	
	@JsonProperty("address_1")
	private String address1;

	@JsonProperty("address_2")
	private String address2;
	
	private String city;
	
	private String state;
	
	private String postcode;
	
	private String country;

	public String getFirstName() {
		return firstName;
	}

	public WooCommerceOrderShipping setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public WooCommerceOrderShipping setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public WooCommerceOrderShipping setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public WooCommerceOrderShipping setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public WooCommerceOrderShipping setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getCity() {
		return city;
	}

	public WooCommerceOrderShipping setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public WooCommerceOrderShipping setState(String state) {
		this.state = state;
		return this;
	}

	public String getPostcode() {
		return postcode;
	}

	public WooCommerceOrderShipping setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public WooCommerceOrderShipping setCountry(String country) {
		this.country = country;
		return this;
	}

}