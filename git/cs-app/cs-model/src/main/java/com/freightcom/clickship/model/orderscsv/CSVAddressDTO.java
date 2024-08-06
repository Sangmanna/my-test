package com.freightcom.clickship.model.orderscsv;

import java.util.ArrayList;
import java.util.List;

import com.freightcom.clickship.model.KeyValue;

public class CSVAddressDTO {

	private String businessName;

	private String customerName;

	private String customerEmail;

	private String phoneNumber;

	private String addressLine1;

	private String addressLine2;

	private String postalCode;

	private String country;

	private String province;

	private String city;
	
	private String orderNotes;
	
	private List<KeyValue> errorMsgs = new ArrayList<>();
	
	public List<KeyValue> getErrorMsgs() {
		return errorMsgs;
	}

	public CSVAddressDTO setErrorMsgs(List<KeyValue> errorMsgs) {
		this.errorMsgs = errorMsgs;
		return this;
	}

	public void addErrorMsg(KeyValue errorMsg) {
		this.errorMsgs.add(errorMsg);
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOrderNotes() {
		return orderNotes;
	}

	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}

}
