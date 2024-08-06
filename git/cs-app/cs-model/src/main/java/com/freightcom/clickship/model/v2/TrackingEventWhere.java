package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackingEventWhere {
	@JsonProperty("city")
	String city;

	@JsonProperty("region")
	String region;
	
	@JsonProperty("country")
	String country;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
