package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile implements Serializable {
	
	private static final long serialVersionUID = -470520919050914823L;

	@XmlAttribute(name = "City")
	private String city;

	@XmlAttribute(name = "Email")
	private String email;

	@XmlAttribute(name = "Phone")
	private String phone;

	@XmlAttribute(name = "Address")
	private String address;

	@XmlAttribute(name = "Contact")
	private String contact;

	@XmlAttribute(name = "Country")
	private String country;

	@XmlAttribute(name = "Province")
	private String province;

	@XmlAttribute(name = "PostalCode")
	private String postalCode;

	@XmlAttribute(name = "BusinessName")
	private String businessName;

	@XmlAttribute(name = "BillingType")
	private String billingType;
	
	@XmlAttribute(name = "SalesAgent")
	private String salesAgent;

	@XmlAttribute(name = "TotalCredit")
	private String totalCredit;
	
	@XmlAttribute(name = "CreditUsed")
	private String creditUsed;
	
	@XmlAttribute(name = "CreditAvailable")
	private String creditAvailable;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public String getSalesAgent() {
		return salesAgent;
	}

	public void setSalesAgent(String salesAgent) {
		this.salesAgent = salesAgent;
	}

	public String getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(String totalCredit) {
		this.totalCredit = totalCredit;
	}

	public String getCreditUsed() {
		return creditUsed;
	}

	public void setCreditUsed(String creditUsed) {
		this.creditUsed = creditUsed;
	}

	public String getCreditAvailable() {
		return creditAvailable;
	}

	public void setCreditAvailable(String creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

}
