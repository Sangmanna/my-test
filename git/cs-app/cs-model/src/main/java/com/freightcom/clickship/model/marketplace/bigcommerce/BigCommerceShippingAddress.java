package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceShippingAddress implements Serializable {

	private static final long serialVersionUID = 622012385096943606L;

	@JsonProperty("id")
	private int id;

	@JsonProperty("order_id")
	private int orderId;

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

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("country")
	private String country;

	@JsonProperty("country_iso2")
	private String countryIso2;

	@JsonProperty("state")
	private String state;

	@JsonProperty("email")
	private String email;

	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("shipping_method")
	private String shippingMethod;
	
	@JsonProperty("shipping_quotes")
	private BigCommerceAddress shippingQuotes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryIso2() {
		return countryIso2;
	}

	public void setCountryIso2(String countryIso2) {
		this.countryIso2 = countryIso2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public BigCommerceAddress getShippingQuotes() {
		return shippingQuotes;
	}

	public void setShippingQuotes(BigCommerceAddress shippingQuotes) {
		this.shippingQuotes = shippingQuotes;
	}

}
