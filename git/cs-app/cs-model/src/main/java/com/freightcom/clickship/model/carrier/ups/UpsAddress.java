package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "AddressLine",
    "City",
    "StateProvinceCode",
    "CountryCode",
    "PostalCode",
    "ResidentialIndicator"
})
public class UpsAddress implements Serializable {

	private static final long serialVersionUID = -5927605270858043564L;

	@JsonProperty("AddressLine")
	private List<String> addressLine = null;

	@JsonProperty("City")
	private String city;

//	@JsonProperty("CompanyName")
//	private String companyName;
//
//	@JsonProperty("ContactName")
//	private String contactName;

	@JsonProperty("CountryCode")
	private String countryCode;

//	@JsonProperty("Phone")
//	private UpsPhone phone;

	@JsonProperty("PostalCode")
	private String postalCode;

	@JsonProperty("ResidentialIndicator")
	private String residentialIndicator;

	@JsonProperty("StateProvinceCode")
	private String stateProvince;

	public List<String> getAddressLine() {
		return addressLine;
	}

	public UpsAddress setAddressLine(List<String> addressLine) {
		this.addressLine = addressLine;
		return this;
	}

	public UpsAddress addAddressLine(String addressLine) {
		if (this.addressLine == null) {
			setAddressLine(new ArrayList<String>());
		}
		this.addressLine.add(addressLine);
		return this;
	}

	public String getCity() {
		return city;
	}

	public UpsAddress setCity(String city) {
		this.city = city;
		return this;
	}

//	public String getCompanyName() {
//		return companyName;
//	}
//
//	public UpsAddress setCompanyName(String companyName) {
//		this.companyName = companyName;
//		return this;
//	}
//
//	public String getContactName() {
//		return contactName;
//	}
//
//	public UpsAddress setContactName(String contactName) {
//		this.contactName = contactName;
//		return this;
//	}

	public String getCountryCode() {
		return countryCode;
	}

	public UpsAddress setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

//	public UpsPhone getPhone() {
//		return phone;
//	}
//
//	public UpsAddress setPhone(UpsPhone phone) {
//		this.phone = phone;
//		return this;
//	}

	public String getPostalCode() {
		return postalCode;
	}

	public UpsAddress setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getResidentialIndicator() {
		return residentialIndicator;
	}

	public UpsAddress setResidentialIndicator(String residentialIndicator) {
		this.residentialIndicator = residentialIndicator;
		return this;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public UpsAddress setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
		return this;
	}


}
