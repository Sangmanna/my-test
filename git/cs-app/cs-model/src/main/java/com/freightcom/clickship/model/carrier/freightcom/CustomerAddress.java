package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public abstract class CustomerAddress implements Serializable {

	private static final long serialVersionUID = 1211986982418677071L;

	@XmlAttribute(name = "address")
	protected String address;
	
	@XmlAttribute(name = "city")
	protected String city;
	
	@XmlAttribute(name = "province")
	protected String province;

	@XmlAttribute(name = "country")
	protected String country;

	@XmlAttribute(name = "postalCode")
	protected String postalCode;

	public String getAddress() {
		return address;
	}

	public CustomerAddress setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public CustomerAddress setCity(String city) {
		this.city = city;
		return this;
	}

	public String getProvince() {
		return province;
	}

	public CustomerAddress setProvince(String province) {
		this.province = province;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public CustomerAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public CustomerAddress setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

}
