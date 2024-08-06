package com.freightcom.clickship.model.carrier.freightcom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class FromAddress extends ShipAddress {

	@XmlAttribute(name = "id")
	private String id = "123";

	public String getId() {
		return id;
	}

	public FromAddress setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getAddress1() {
		return address1;
	}

	public FromAddress setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public FromAddress setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getAttention() {
		return attention;
	}

	public FromAddress setAttention(String attention) {
		this.attention = attention;
		return this;
	}

	public String getCity() {
		return city;
	}

	public FromAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public FromAddress setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public FromAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public FromAddress setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public FromAddress setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getState() {
		return state;
	}

	public FromAddress setState(String state) {
		this.state = state;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public FromAddress setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getInstructions() {
		return instructions;
	}

	public FromAddress setInstructions(String instructions) {
		this.instructions = instructions;
		return this;
	}

}
