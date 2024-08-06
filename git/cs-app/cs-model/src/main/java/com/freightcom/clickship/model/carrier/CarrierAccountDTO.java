package com.freightcom.clickship.model.carrier;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class CarrierAccountDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -9065724620589111157L;

	private String id;

	private String customerId;
	
	private String carrierAccountNumber;

	private String carrierContractId;
	
	private String carrierNickname;

	private String carrierName;

	private String carrierCode;
	
	private String carrierToken;

	private String carrierKey;

	private String carrierUsername;

	private String carrierPassword;

	private String contactFirstName;

	private String contactLastName;

	private String companyName;

	private String address1;

	private String address2;

	private String city;

	private String provinceState;

	private String postalCode;

	private String country;

	private String phone;
	
	private String email;
	
	private boolean active;
	
	private boolean negotiatedRates;

	private boolean transmitShipments;

	/**
	 * @deprecated will be removed sometime soon. customer_peference shipping label setting will overwrite
	 */
	private boolean fullSizeLabels;
	
	private boolean autoRequestReturnLabels;
	
	private boolean paperlessCustomsInvoice;
	
	private String image = "";

	public String getId() {
		return id;
	}

	public CarrierAccountDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public CarrierAccountDTO setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public CarrierAccountDTO setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	}

	public String getCarrierContractId() {
		return carrierContractId;
	}

	public CarrierAccountDTO setCarrierContractId(String carrierContractId) {
		this.carrierContractId = carrierContractId;
		return this;
	}

	public String getCarrierNickname() {
		return carrierNickname;
	}

	public CarrierAccountDTO setCarrierNickname(String carrierNickname) {
		this.carrierNickname = carrierNickname;
		return this;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public CarrierAccountDTO setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public CarrierAccountDTO setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
		return this;
	}

	public String getCarrierToken() {
		return carrierToken;
	}

	public CarrierAccountDTO setCarrierToken(String carrierToken) {
		this.carrierToken = carrierToken;
		return this;
	}

	public String getCarrierKey() {
		return carrierKey;
	}

	public CarrierAccountDTO setCarrierKey(String carrierKey) {
		this.carrierKey = carrierKey;
		return this;
	}

	public String getCarrierUsername() {
		return carrierUsername;
	}

	public CarrierAccountDTO setCarrierUsername(String carrierUsername) {
		this.carrierUsername = carrierUsername;
		return this;
	}

	public String getCarrierPassword() {
		return carrierPassword;
	}

	public CarrierAccountDTO setCarrierPassword(String carrierPassword) {
		this.carrierPassword = carrierPassword;
		return this;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public CarrierAccountDTO setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
		return this;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public CarrierAccountDTO setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
		return this;
	}

	public String getCompanyName() {
		return companyName;
	}

	public CarrierAccountDTO setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public CarrierAccountDTO setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public CarrierAccountDTO setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getCity() {
		return city;
	}

	public CarrierAccountDTO setCity(String city) {
		this.city = city;
		return this;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public CarrierAccountDTO setProvinceState(String provinceState) {
		this.provinceState = provinceState;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public CarrierAccountDTO setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public CarrierAccountDTO setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public CarrierAccountDTO setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public CarrierAccountDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public boolean isActive() {
		return active;
	}

	public CarrierAccountDTO setActive(boolean active) {
		this.active = active;
		return this;
	}

	public boolean isNegotiatedRates() {
		return negotiatedRates;
	}

	public CarrierAccountDTO setNegotiatedRates(boolean negotiatedRates) {
		this.negotiatedRates = negotiatedRates;
		return this;
	}

	public boolean isTransmitShipments() {
		return transmitShipments;
	}

	public CarrierAccountDTO setTransmitShipments(boolean transmitShipments) {
		this.transmitShipments = transmitShipments;
		return this;
	}

	public boolean isFullSizeLabels() {
		return fullSizeLabels;
	}

	public CarrierAccountDTO setFullSizeLabels(boolean fullSizeLabels) {
		this.fullSizeLabels = fullSizeLabels;
		return this;
	}

	public boolean isAutoRequestReturnLabels() {
		return autoRequestReturnLabels;
	}

	public CarrierAccountDTO setAutoRequestReturnLabels(boolean autoRequestReturnLabels) {
		this.autoRequestReturnLabels = autoRequestReturnLabels;
		return this;
	}

	public String getImage() {
		return image;
	}

	public CarrierAccountDTO setImage(String image) {
		this.image = image;
		return this;
	}

	public boolean isPaperlessCustomsInvoice() {
		return paperlessCustomsInvoice;
	}

	public CarrierAccountDTO setPaperlessCustomsInvoice(boolean paperlessCustomsInvoice) {
		this.paperlessCustomsInvoice = paperlessCustomsInvoice;
		return this;
	}

}