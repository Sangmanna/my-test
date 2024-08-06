package com.freightcom.clickship.model.v2;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Address
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T20:40:42.594Z[GMT]")

public class Address {
	
	@JsonProperty("address_line1")
	private String addressLine1 = null;

	@JsonProperty("address_line2")
	private String addressLine2 = null;

	@JsonProperty("unit_number")
	private String unitNumber = null;
	
	@JsonProperty("buzzer_code")
	private String buzzerCode = null;

	@JsonProperty("city")
	private String city = null;

	@JsonProperty("region")
	private String region = null;

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("postal_code")
	private String postalCode = null;
	
	@JsonProperty("validated")
	private boolean validated = false;

	public Address addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public Address addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Address unitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
		return this;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public Address city(String city) {
		this.city = city;
		return this;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address region(String region) {
		this.region = region;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Address country(String country) {
		this.country = country;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return Objects.equals(this.addressLine1, address.addressLine1)
				&& Objects.equals(this.addressLine2, address.addressLine2)
				&& Objects.equals(this.unitNumber, address.unitNumber) && Objects.equals(this.city, address.city)
				&& Objects.equals(this.region, address.region) && Objects.equals(this.country, address.country)
				&& Objects.equals(this.postalCode, address.postalCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressLine1, addressLine2, unitNumber, city, region, country, postalCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Address {\n");

		sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
		sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
		sb.append("    unitNumber: ").append(toIndentedString(unitNumber)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    region: ").append(toIndentedString(region)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public String getBuzzerCode() {
		return buzzerCode;
	}

	public void setBuzzerCode(String buzzerCode) {
		this.buzzerCode = buzzerCode;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
	
}
