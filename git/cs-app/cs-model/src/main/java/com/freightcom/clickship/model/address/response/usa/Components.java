
package com.freightcom.clickship.model.address.response.usa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freightcom.clickship.model.CommonDTO;

import java.io.Serializable;

@JsonPropertyOrder({ "urbanization", "primary_number", "street_name", "street_predirection", "street_postdirection",
		"street_suffix", "secondary_number", "secondary_designator", "extra_secondary_number","extra_secondary_designator", 
		"pmb_designator","pmb_number", "city_name",
		"state_abbreviation", "zipcode", "plus4_code", "delivery_point", "delivery_point_check_digit" })
public class Components extends CommonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5968899398807190090L;
	@JsonProperty("urbanization")
	private String urbanization;
	@JsonProperty("primary_number")
	private String primaryNumber;
	@JsonProperty("street_name")
	private String streetName;
	@JsonProperty("street_predirection")
	private String streetPredirection;
	@JsonProperty("street_postdirection")
	private String streetPostdirection;
	@JsonProperty("street_suffix")
	private String streetSuffix;
	@JsonProperty("extra_secondary_number")
	private String extraSecondaryNumber;
	@JsonProperty("secondary_number")
	private String secondaryNumber;
	@JsonProperty("secondary_designator")
	private String secondaryDesignator;
	@JsonProperty("extra_secondary_designator")
	private String extraSecondaryDesignator;
	@JsonProperty("city_name")
	private String cityName;
	@JsonProperty("pmb_designator")
	private String pmbDesignator;
	@JsonProperty("pmb_number")
	private String pmbNumber;
	@JsonProperty("state_abbreviation")
	private String stateAbbreviation;
	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("plus4_code")
	private String plus4Code;
	@JsonProperty("delivery_point")
	private String deliveryPoint;
	@JsonProperty("delivery_point_check_digit")
	private String deliveryPointCheckDigit;

	public String getPrimaryNumber() {
		return primaryNumber;
	}

	public Components setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
        return this;
	}

	public String getUrbanization() {
		return urbanization;
	}

	public Components setUrbanization(String urbanization) {
		this.urbanization = urbanization;
        return this;
	}

	public String getStreetName() {
		return streetName;
	}

	public Components setStreetName(String streetName) {
		this.streetName = streetName;
        return this;
	}

	public String getStreetPredirection() {
		return streetPredirection;
	}

	public Components setStreetPredirection(String streetPredirection) {
		this.streetPredirection = streetPredirection;
        return this;
	}

	public String getStreetPostdirection() {
		return streetPostdirection;
	}

	public Components setStreetPostdirection(String streetPostdirection) {
		this.streetPostdirection = streetPostdirection;
        return this;
	}

	public String getStreetSuffix() {
		return streetSuffix;
	}

	public Components setStreetSuffix(String streetSuffix) {
		this.streetSuffix = streetSuffix;
        return this;
	}

	public String getSecondaryNumber() {
		return secondaryNumber;
	}

	public Components setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
        return this;
	}

	public String getExtraSecondaryNumber() {
		return extraSecondaryNumber;
	}

	public Components setExtraSecondaryNumber(String extraSecondaryNumber) {
		this.extraSecondaryNumber = extraSecondaryNumber;
        return this;
	}

	public String getSecondaryDesignator() {
		return secondaryDesignator;
	}

	public Components setSecondaryDesignator(String secondaryDesignator) {
		this.secondaryDesignator = secondaryDesignator;
        return this;
	}

	public String getExtraSecondaryDesignator() {
		return extraSecondaryDesignator;
	}

	public Components setExtraSecondaryDesignator(String extraSecondaryDesignator) {
		this.extraSecondaryDesignator = extraSecondaryDesignator;
        return this;
	}

	public String getCityName() {
		return cityName;
	}

	public Components setCityName(String cityName) {
		this.cityName = cityName;
        return this;
	}
	public String getPmbDesignator() {
		return pmbDesignator;
	}

	public Components setPmbDesignator(String pmbDesignator) {
		this.pmbDesignator = pmbDesignator;
        return this;
	}
	public String getPmbNumber() {
		return pmbNumber;
	}

	public Components setPmbNumber(String pmbNumber) {
		this.pmbNumber = pmbNumber;
        return this;
	}

	public String getStateAbbreviation() {
		return stateAbbreviation;
	}

	public Components setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
        return this;
	}

	public String getZipcode() {
		return zipcode;
	}

	public Components setZipcode(String zipcode) {
		this.zipcode = zipcode;
        return this;
	}

	public String getPlus4Code() {
		return plus4Code;
	}

	public Components setPlus4Code(String plus4Code) {
		this.plus4Code = plus4Code;
        return this;
	}

	public String getDeliveryPoint() {
		return deliveryPoint;
	}

	public Components setDeliveryPoint(String deliveryPoint) {
		this.deliveryPoint = deliveryPoint;
        return this;
	}

	public String getDeliveryPointCheckDigit() {
		return deliveryPointCheckDigit;
	}

	public Components setDeliveryPointCheckDigit(String deliveryPointCheckDigit) {
		this.deliveryPointCheckDigit = deliveryPointCheckDigit;
        return this;
	}


}
