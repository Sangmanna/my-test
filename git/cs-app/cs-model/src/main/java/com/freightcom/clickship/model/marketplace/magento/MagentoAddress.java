package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoAddress implements Serializable {
	
	private static final long serialVersionUID = 8814458055010460767L;

	@JsonProperty("address_type")
	private String addressType;
	
	private String prefix;
	
	@JsonProperty("firstname")
	private String firstName;
	
	@JsonProperty("lastname")
	private String lastName;
	
	private String company;

	@JsonProperty("street")
	private List<String> address;

	private String city;

	private String region;
	
	@JsonProperty("region_code")
	private String regionCode;
	
	@JsonProperty("country_id")
	private String country;
	
	@JsonProperty("postcode")
	private String zipcode;
	
	private String email;	
	
	@JsonProperty("telephone")
	private String phone;

	public String getAddressType() {
		return addressType;
	}

	public MagentoAddress setAddressType(String addressType) {
		this.addressType = addressType;
		return this;
	}

	public String getPrefix() {
		return prefix;
	}

	public MagentoAddress setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public MagentoAddress setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public MagentoAddress setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public MagentoAddress setCompany(String company) {
		this.company = company;
		return this;
	}

	public List<String> getAddress() {
		return address;
	}

	public MagentoAddress setAddress(List<String> address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public MagentoAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public MagentoAddress setRegion(String region) {
		this.region = region;
		return this;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public MagentoAddress setRegionCode(String regionCode) {
		this.regionCode = regionCode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public MagentoAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getZipcode() {
		return zipcode;
	}

	public MagentoAddress setZipcode(String zipcode) {
		this.zipcode = zipcode;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public MagentoAddress setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public MagentoAddress setPhone(String phone) {
		this.phone = phone;
		return this;
	}

}
