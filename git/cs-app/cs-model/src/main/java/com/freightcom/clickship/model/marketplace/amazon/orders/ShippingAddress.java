package com.freightcom.clickship.model.marketplace.amazon.orders;


import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ShippingAddress")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShippingAddress implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Name")	
	private String name;

	@XmlElement(name="AddressLine1")	
	private String addressLine1;
	
	@XmlElement(name="Phone")
	private String phone;
	
	@XmlElement(name="City")	
	private String city;
	
	@XmlElement(name="PostalCode")	
	private String postalCode;
	
	@XmlElement(name="isAddressSharingConfidential")	
	private String isAddressSharingConfidential;
	
	@XmlElement(name="StateOrRegion")	
	private String stateOrRegion;
	
	@XmlElement(name="CountryCode")	
	private String countryCode;
	
	public ShippingAddress() {
		super();
	}
	
	public ShippingAddress(String name, String addressLine1, String phone, String city, String postalCode, String isAddressSharingConfidential,
			String stateOrRegion, String countryCode) {
		super();
		this.name = name;
		this.addressLine1 = addressLine1;
		this.phone = phone;
		this.city = city;
		this.postalCode = postalCode;
		this.isAddressSharingConfidential = isAddressSharingConfidential;
		this.stateOrRegion = stateOrRegion;
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String isAddressSharingConfidential() {
		return isAddressSharingConfidential;
	}

	public void setAddressSharingConfidential(String isAddressSharingConfidential) {
		this.isAddressSharingConfidential = isAddressSharingConfidential;
	}

	public String getStateOrRegion() {
		return stateOrRegion;
	}

	public void setStateOrRegion(String stateOrRegion) {
		this.stateOrRegion = stateOrRegion;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}	
	
}
