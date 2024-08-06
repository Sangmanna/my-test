package com.freightcom.clickship.model.carrier;

import java.io.Serializable;
import java.util.List;

import com.freightcom.clickship.model.CommonDTO;

public class CarrierDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -2851732754270662239L;

	private String id;
	
	private String imageName;
	
	private String shortName;

	private String serviceId;

	private String serviceGroupId;

	private String serviceIdentifier;

	private boolean status;
	
	private boolean isAgreeTerms;
	
	private boolean showPickupOption;
	
	private boolean isDisplayToCustomer;
	
	private boolean showInsuranceOption;
	
	private String carrierAccountNumber;
	
	private List<CustomerCarrierPreferenceDTO> customerCarrierPreferences;

	public String getId() {
		return id;
	}

	public CarrierDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getImageName() {
		return imageName;
	}

	public CarrierDTO setImageName(String imageName) {
		this.imageName = imageName;
		return this;
	}

	public String getShortName() {
		return shortName;
	}

	public CarrierDTO setShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public CarrierDTO setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public CarrierDTO setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
		return this;
	}

	public String getServiceIdentifier() {
		return serviceIdentifier;
	}

	public CarrierDTO setServiceIdentifier(String serviceIdentifier) {
		this.serviceIdentifier = serviceIdentifier;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public CarrierDTO setStatus(boolean status) {
		this.status = status;
		return this;
	}

	public boolean isAgreeTerms() {
		return isAgreeTerms;
	}

	public CarrierDTO setAgreeTerms(boolean isAgreeTerms) {
		this.isAgreeTerms = isAgreeTerms;
		return this;
	}

	public boolean isShowPickupOption() {
		return showPickupOption;
	}

	public CarrierDTO setShowPickupOption(boolean showPickupOption) {
		this.showPickupOption = showPickupOption;
		return this;
	}

	public boolean isDisplayToCustomer() {
		return isDisplayToCustomer;
	}

	public CarrierDTO setDisplayToCustomer(boolean isDisplayToCustomer) {
		this.isDisplayToCustomer = isDisplayToCustomer;
		return this;
	}

	public boolean isShowInsuranceOption() {
		return showInsuranceOption;
	}

	public CarrierDTO setShowInsuranceOption(boolean showInsuranceOption) {
		this.showInsuranceOption = showInsuranceOption;
		return this;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public CarrierDTO setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	}

	public List<CustomerCarrierPreferenceDTO> getCustomerCarrierPreferences() {
		return customerCarrierPreferences;
	}

	public CarrierDTO setCustomerCarrierPreferences(List<CustomerCarrierPreferenceDTO> customerCarrierPreferences) {
		this.customerCarrierPreferences = customerCarrierPreferences;
		return this;
	}

}