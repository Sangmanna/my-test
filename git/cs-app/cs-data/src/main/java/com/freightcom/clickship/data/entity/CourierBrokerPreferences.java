package com.freightcom.clickship.data.entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "courier_broker_preferences")
public class CourierBrokerPreferences implements Serializable {

	private static final long serialVersionUID = 4150090382588993259L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "shipping_preferences_id")
	private ShippingPreferences shippingPreference;

	@Column(name = "use_carrier_broker", nullable = false)
	private boolean useCarrierBroker = true;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "phone_number_ext")
	private String phoneNumberExt;

	@Column(name = "broker_name")
	private String brokerName;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "fax_number")
	private String faxNumber;

	@Column(name = "usmca_number")
	private String usmcaNumber;

	@Column(name = "fda_number")
	private String fdaNumber;
	
	@Column(name = "carrier_email_address")
	private String carrierEmailAddress;

	@Column(name = "carrier_phone_number")
	private String carrierPhoneNumber;

	@Column(name = "carrier_phone_number_ext")
	private String carrierPhoneNumberExt;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ShippingPreferences getShippingPreference() {
		return shippingPreference;
	}

	public void setShippingPreference(ShippingPreferences shippingPreference) {
		this.shippingPreference = shippingPreference;
	}
	

	public boolean isUseCarrierBroker() {
		return useCarrierBroker;
	}

	public void setUseCarrierBroker(boolean useCarrierBroker) {
		this.useCarrierBroker = useCarrierBroker;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberExt() {
		return phoneNumberExt;
	}

	public void setPhoneNumberExt(String phoneNumberExt) {
		this.phoneNumberExt = phoneNumberExt;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getUsmcaNumber() {
		return usmcaNumber;
	}

	public void setUsmcaNumber(String usmcaNumber) {
		this.usmcaNumber = usmcaNumber;
	}

	public String getFdaNumber() {
		return fdaNumber;
	}

	public void setFdaNumber(String fdaNumber) {
		this.fdaNumber = fdaNumber;
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
