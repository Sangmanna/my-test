package com.freightcom.clickship.model.carrier.freightcom.v2;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FreightcomCustomer implements Serializable {

	private static final long serialVersionUID = 3497442304596612541L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("login_id")
	private String loginId;
	
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("customer_id")
	private String customerId;
	
	@JsonProperty("username")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("old_password")
	private String oldPassword;
	
	@JsonProperty("new_password")
	private String newPassword;

	@JsonProperty("name")
	private String businessName;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("contact_name")
	private String contactName;

	@JsonProperty("email_address")
	private String email;

	@JsonProperty("address")
	private FCAddress address;

	@JsonProperty("phone_number")
	private FCPhoneNumber phone;

	@JsonProperty("billing_type")
	private FCBillingType billingType;
	
	@JsonProperty("sales_agent")
	private String salesAgent;
	
	@JsonProperty("total_credit")
	private FCMoney totalCredit;
	
	@JsonProperty("credit_used")
	private FCMoney creditUsed;
	
	@JsonProperty("credit_available")
	private FCMoney creditAvailable;
	
	@JsonProperty("sign_up_code")
	private String signUpCode;
	
	@JsonProperty("language")
	private String language;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("registration_source")
	private String registrationSource;

	@JsonProperty("invoice_preference")
	private FCInvoicePreferenceType invoicePreferenceType;
	
	private boolean isV2Customer;

	public String getId() {
		return id;
	}

	public FreightcomCustomer setId(String id) {
		this.id = id;
		return this;
	}

	public String getLoginId() {
		return loginId;
	}

	public FreightcomCustomer setLoginId(String loginId) {
		this.loginId = loginId;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public FreightcomCustomer setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public FreightcomCustomer setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public String getContactName() {
		return contactName;
	}

	public FreightcomCustomer setContactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public FreightcomCustomer setEmail(String email) {
		this.email = email;
		return this;
	}

	public FCAddress getAddress() {
		return address;
	}

	public FreightcomCustomer setAddress(FCAddress address) {
		this.address = address;
		return this;
	}

	public FCPhoneNumber getPhone() {
		return phone;
	}

	public FreightcomCustomer setPhone(FCPhoneNumber phone) {
		this.phone = phone;
		return this;
	}

	public FCBillingType getBillingType() {
		return billingType;
	}

	public FreightcomCustomer setBillingType(FCBillingType billingType) {
		this.billingType = billingType;
		return this;
	}

	public String getSalesAgent() {
		return salesAgent;
	}

	public FreightcomCustomer setSalesAgent(String salesAgent) {
		this.salesAgent = salesAgent;
		return this;
	}

	public FCMoney getTotalCredit() {
		return totalCredit;
	}

	public FreightcomCustomer setTotalCredit(FCMoney totalCredit) {
		this.totalCredit = totalCredit;
		return this;
	}

	public FCMoney getCreditUsed() {
		return creditUsed;
	}

	public FreightcomCustomer setCreditUsed(FCMoney creditUsed) {
		this.creditUsed = creditUsed;
		return this;
	}

	public FCMoney getCreditAvailable() {
		return creditAvailable;
	}

	public FreightcomCustomer setCreditAvailable(FCMoney creditAvailable) {
		this.creditAvailable = creditAvailable;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public FreightcomCustomer setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public FreightcomCustomer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public FreightcomCustomer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getSignUpCode() {
		return signUpCode;
	}

	public FreightcomCustomer setSignUpCode(String signUpCode) {
		this.signUpCode = signUpCode;
		return this;
	}

	public String getLanguage() {
		return language;
	}

	public FreightcomCustomer setLanguage(String language) {
		this.language = language;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public FreightcomCustomer setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public FreightcomCustomer setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public FreightcomCustomer setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public FreightcomCustomer setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public FreightcomCustomer setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
		return this;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public FreightcomCustomer setNewPassword(String newPassword) {
		this.newPassword = newPassword;
		return this;
	}

	public FCInvoicePreferenceType getInvoicePreferenceType() {
		return invoicePreferenceType;
	}

	public FreightcomCustomer setInvoicePreferenceType(FCInvoicePreferenceType invoicePreferenceType) {
		this.invoicePreferenceType = invoicePreferenceType;
		return this;
	}

	public boolean isV2Customer() {
		return isV2Customer;
	}

	public void setV2Customer(boolean isV2Customer) {
		this.isV2Customer = isV2Customer;
	}

}
