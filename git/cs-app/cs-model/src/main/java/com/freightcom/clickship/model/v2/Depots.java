package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Depots {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("address")
	private Address address;
	
	@JsonProperty("distance")
	private Distance distance;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("operating_hours")
	private List<OperatingHours> operatingHours;

	public String getName() {
		return name;
	}

	public Depots setName(String name) {
		this.name = name;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Depots setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public Depots setAddress(Address address) {
		this.address = address;
		return this;
	}

	public Distance getDistance() {
		return distance;
	}

	public Depots setDistance(Distance distance) {
		this.distance = distance;
		return this;
	}

	public List<OperatingHours> getOperatingHours() {
		return operatingHours;
	}

	public Depots setOperatingHours(List<OperatingHours> operatingHours) {
		this.operatingHours = operatingHours;
		return this;
	}

}
