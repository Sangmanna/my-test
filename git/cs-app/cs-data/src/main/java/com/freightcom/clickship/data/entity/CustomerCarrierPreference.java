package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "customer_carrier_preferences")
public class CustomerCarrierPreference extends BaseEntity {
	
	private static final long serialVersionUID = -1915078425096381280L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@Column(name = "service")
	private String service;

	@Column(name = "service_id")
	private String serviceId;

	@Column(name = "v2_service_id")
	private String v2ServiceId;

	@Column(name = "service_group_id")
	private String serviceGroupId;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "agree_terms")
	private Boolean isAgreeTerms;
	
	@Column(name = "carrier_account_number")
	private String carrierAccountNumber;
	
	@Column(name = "show_pickup_option")
	private Boolean showPickupOption;

	@Column(name = "pallet_carrier")
	private boolean palletCarrier;
	
	public CustomerCarrierPreference() {
		
	}
	
	public CustomerCarrierPreference(String id, Customer customer, String service, String serviceId, String v2ServiceId,
			String serviceGroupId, String shortName, Boolean status, Boolean isAgreeTerms, String carrierAccountNumber,
			Boolean showPickupOption, boolean palletCarrier) {
		super();
		this.id = id;
		this.customer = customer;
		this.service = service;
		this.serviceId = serviceId;
		this.v2ServiceId = v2ServiceId;
		this.serviceGroupId = serviceGroupId;
		this.shortName = shortName;
		this.status = status;
		this.isAgreeTerms = isAgreeTerms;
		this.carrierAccountNumber = carrierAccountNumber;
		this.showPickupOption = showPickupOption;
		this.palletCarrier = palletCarrier;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public CustomerCarrierPreference setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public CustomerCarrierPreference setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getService() {
		return service;
	}

	public CustomerCarrierPreference setService(String service) {
		this.service = service;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public CustomerCarrierPreference setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public CustomerCarrierPreference setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
		return this;
	}

	public String getShortName() {
		return shortName;
	}

	public CustomerCarrierPreference setShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	public Boolean getStatus() {
		return status;
	}

	public CustomerCarrierPreference setStatus(Boolean status) {
		this.status = status;
		return this;
	}

	public Boolean getIsAgreeTerms() {
		return isAgreeTerms;
	}

	public CustomerCarrierPreference setIsAgreeTerms(Boolean isAgreeTerms) {
		this.isAgreeTerms = isAgreeTerms;
		return this;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public CustomerCarrierPreference setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	}

	public String getV2ServiceId() {
		return v2ServiceId;
	}

	public CustomerCarrierPreference setV2ServiceId(String v2ServiceId) {
		this.v2ServiceId = v2ServiceId;
		return this;
	}
	
	public Boolean getShowPickupOption() {
		return showPickupOption;
	}

	public CustomerCarrierPreference setShowPickupOption(Boolean showPickupOption) {
		this.showPickupOption = showPickupOption;
		return this;
	}

	public boolean isPalletCarrier() {
		return palletCarrier;
	}

	public CustomerCarrierPreference setPalletCarrier(boolean palletCarrier) {
		this.palletCarrier = palletCarrier;
		return this;
	}
}
