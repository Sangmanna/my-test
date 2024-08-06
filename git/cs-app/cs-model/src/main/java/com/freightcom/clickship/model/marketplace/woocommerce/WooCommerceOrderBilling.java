package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceOrderBilling implements Serializable {
	
	private static final long serialVersionUID = -4800920608711234676L;

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
	
	private String email;
	
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public WooCommerceOrderBilling setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public WooCommerceOrderBilling setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public WooCommerceOrderBilling setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public WooCommerceOrderBilling setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public WooCommerceOrderBilling setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getCity() {
		return city;
	}

	public WooCommerceOrderBilling setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public WooCommerceOrderBilling setState(String state) {
		this.state = state;
		return this;
	}

	public String getPostcode() {
		return postcode;
	}

	public WooCommerceOrderBilling setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public WooCommerceOrderBilling setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public WooCommerceOrderBilling setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public WooCommerceOrderBilling setPhone(String phone) {
		this.phone = phone;
		return this;
	}

}