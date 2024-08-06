package com.freightcom.clickship.model.carrier.freightcom.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesRepRequest {

	@JsonProperty("ID")
	private String id;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("ContactName")
	private String contactName;

	@JsonProperty("EmailAddress")
	private String emailAddress;

	@JsonProperty("RegistrationSource")
	private String registrationSource;

	@JsonProperty("BillingType")
	private String billingType;

	@JsonProperty("SalesAgent")
	private String salesAgent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public void setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
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
}
