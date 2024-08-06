package com.freightcom.clickship.model.marketplace.woocommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceStoreAddress {
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
	
	private String currency;

	public String getAddressLine1() {
		return addressLine1;
	}

	public WooCommerceStoreAddress setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public WooCommerceStoreAddress setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	public String getCity() {
		return city;
	}

	public WooCommerceStoreAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public WooCommerceStoreAddress setState(String state) {
		this.state = state;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public WooCommerceStoreAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public WooCommerceStoreAddress setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
