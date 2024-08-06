package com.freightcom.clickship.model.carrier.freightcom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class ToAddress extends ShipAddress {

	public String getAddress1() {
		return address1;
	}

	public ToAddress setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public ToAddress setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getAttention() {
		return attention;
	}

	public ToAddress setAttention(String attention) {
		this.attention = attention;
		return this;
	}

	public String getCity() {
		return city;
	}

	public ToAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public ToAddress setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public ToAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ToAddress setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public ToAddress setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getState() {
		return state;
	}

	public ToAddress setState(String state) {
		this.state = state;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public ToAddress setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getInstructions() {
		return instructions;
	}

	public ToAddress setInstructions(String instructions) {
		this.instructions = instructions;
		return this;
	}
}
