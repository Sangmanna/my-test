package com.freightcom.clickship.model.customer.customerpreferences;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class CourierBrokerPreferencesDTO implements Serializable {
	
	private static final long serialVersionUID = -5339068242705296705L;
	
	private String id;
	
	private String emailAddress;
	
	private String phoneNumber;
	
	private String phoneNumberExt;
	
	private String brokerName;
	
	private String accountNumber;
	
	private String faxNumber;
	
	private String usmcaNumber;
	
	private String fdaNumber;
	
	private boolean useCarrierBroker = true;
	
	private String carrierEmailAddress;

	private String carrierPhoneNumber;

	private String carrierPhoneNumberExt;

	public String getId() {
		return id;
	}

	public CourierBrokerPreferencesDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public CourierBrokerPreferencesDTO setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public CourierBrokerPreferencesDTO setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getPhoneNumberExt() {
		return phoneNumberExt;
	}

	public CourierBrokerPreferencesDTO setPhoneNumberExt(String phoneNumberExt) {
		this.phoneNumberExt = phoneNumberExt;
		return this;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public CourierBrokerPreferencesDTO setBrokerName(String brokerName) {
		this.brokerName = brokerName;
		return this;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public CourierBrokerPreferencesDTO setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public CourierBrokerPreferencesDTO setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
		return this;
	}

	public String getUsmcaNumber() {
		return usmcaNumber;
	}

	public CourierBrokerPreferencesDTO setUsmcaNumber(String usmcaNumber) {
		this.usmcaNumber = usmcaNumber;
		return this;
	}

	public String getFdaNumber() {
		return fdaNumber;
	}

	public CourierBrokerPreferencesDTO setFdaNumber(String fdaNumber) {
		this.fdaNumber = fdaNumber;
		return this;
	}

	public boolean isUseCarrierBroker() {
		return useCarrierBroker;
	}

	public CourierBrokerPreferencesDTO setUseCarrierBroker(boolean useCarrierBroker) {
		this.useCarrierBroker = useCarrierBroker;
		return this;
	}

	public String getCarrierEmailAddress() {
		return carrierEmailAddress;
	}

	public void setCarrierEmailAddress(String carrierEmailAddress) {
		this.carrierEmailAddress = carrierEmailAddress;
	}

	public String getCarrierPhoneNumber() {
		return carrierPhoneNumber;
	}

	public void setCarrierPhoneNumber(String carrierPhoneNumber) {
		this.carrierPhoneNumber = carrierPhoneNumber;
	}

	public String getCarrierPhoneNumberExt() {
		return carrierPhoneNumberExt;
	}

	public void setCarrierPhoneNumberExt(String carrierPhoneNumberExt) {
		this.carrierPhoneNumberExt = carrierPhoneNumberExt;
	}
	
}
