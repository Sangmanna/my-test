package com.freightcom.clickship.model.carrier;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class CustomerCarrierPreferenceDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -1352449380529790470L;

	private String id;
	
	private String service;
	
	private String shortName;

	private String serviceId;
	
	private String serviceGroupId;
	
	private String carrierAccountNumber;

	private boolean status;

	private boolean isAgreeTerms;

	public String getId() {
		return id;
	}

	public CustomerCarrierPreferenceDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getService() {
		return service;
	}

	public CustomerCarrierPreferenceDTO setService(String service) {
		this.service = service;
		return this;
	}

	public String getShortName() {
		return shortName;
	}

	public CustomerCarrierPreferenceDTO setShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public CustomerCarrierPreferenceDTO setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public CustomerCarrierPreferenceDTO setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
		return this;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public CustomerCarrierPreferenceDTO setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public CustomerCarrierPreferenceDTO setStatus(boolean status) {
		this.status = status;
		return this;
	}

	public boolean isAgreeTerms() {
		return isAgreeTerms;
	}

	public CustomerCarrierPreferenceDTO setAgreeTerms(boolean isAgreeTerms) {
		this.isAgreeTerms = isAgreeTerms;
		return this;
	}
	
}
