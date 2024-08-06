package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ReverbShippingAddress {
	@JsonProperty("name")
	private String name;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("region")
	private String region;
	@JsonProperty("locality")
	private String locality;
	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("display_location")
	private String displayLocation;
	@JsonProperty("id")
	private String id;
	@JsonProperty("primary")
	private boolean primary;
	@JsonProperty("street_address")
	private String streetAddress;
	@JsonProperty("extended_address")
	private String extendedAddress;
	@JsonProperty("postal_code")
	private String postalCode;
	@JsonProperty("unformatted_phone")
	private String unformattedPhone;
	@JsonProperty("complete_shipping_address")
	private boolean completeShippingAddress;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDisplayLocation() {
		return displayLocation;
	}
	public void setDisplayLocation(String displayLocation) {
		this.displayLocation = displayLocation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getExtendedAddress() {
		return extendedAddress;
	}
	public void setExtendedAddress(String extendedAddress) {
		this.extendedAddress = extendedAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getUnformattedPhone() {
		return unformattedPhone;
	}
	public void setUnformattedPhone(String unformattedPhone) {
		this.unformattedPhone = unformattedPhone;
	}
	public boolean isCompleteShippingAddress() {
		return completeShippingAddress;
	}
	public void setCompleteShippingAddress(boolean completeShippingAddress) {
		this.completeShippingAddress = completeShippingAddress;
	}
}
