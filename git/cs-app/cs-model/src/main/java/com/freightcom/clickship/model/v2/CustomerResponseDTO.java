package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponseDTO {
	
	@JsonProperty("customer_id")
	private String customerId;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("contact_name")
	private String contactName;
	@JsonProperty("email_address")
	private String emailAddress;
	@JsonProperty("address")
	private Address address;
	@JsonProperty("phone_number")
	private PhoneNumber phoneNumber;
	@JsonProperty("billing_type")
	private String billingType;
	@JsonProperty("sales_agent")
	private String salesAgent;
	@JsonProperty("total_credit")
	private Money totalCredit;
	@JsonProperty("credit_used")
	private Money creditUsed;
	@JsonProperty("credit_available")
	private Money creditAvailable;
	@JsonProperty("registration_source")
	private String registrationSource;
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
// 	keep the code. CP-818
//	@JsonProperty("state")
//	private String state;

	public String getCustomerId() {
		return customerId;
	}

	public CustomerResponseDTO setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public CustomerResponseDTO setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getId() {
		return id;
	}

	public CustomerResponseDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public CustomerResponseDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getContactName() {
		return contactName;
	}

	public CustomerResponseDTO setContactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public CustomerResponseDTO setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public CustomerResponseDTO setAddress(Address address) {
		this.address = address;
		return this;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public CustomerResponseDTO setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getBillingType() {
		return billingType;
	}

	public CustomerResponseDTO setBillingType(String billingType) {
		this.billingType = billingType;
		return this;
	}

	public String getSalesAgent() {
		return salesAgent;
	}

	public CustomerResponseDTO setSalesAgent(String salesAgent) {
		this.salesAgent = salesAgent;
		return this;
	}

	public Money getTotalCredit() {
		return totalCredit;
	}

	public CustomerResponseDTO setTotalCredit(Money totalCredit) {
		this.totalCredit = totalCredit;
		return this;
	}

	public Money getCreditUsed() {
		return creditUsed;
	}

	public CustomerResponseDTO setCreditUsed(Money creditUsed) {
		this.creditUsed = creditUsed;
		return this;
	}

	public Money getCreditAvailable() {
		return creditAvailable;
	}

	public CustomerResponseDTO setCreditAvailable(Money creditAvailable) {
		this.creditAvailable = creditAvailable;
		return this;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public CustomerResponseDTO setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// keep the code. CP-818
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
}
