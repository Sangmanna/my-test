package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.carrier.freightcom.v2.FCBillingType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FcV2customer {

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
	
	@JsonProperty("sign_up_code")
	private String signUpCode;
	
	@JsonProperty("phone_number")
	private PhoneNumber phoneNumber;
	
	@JsonProperty("registration_source")
	private String registrationSource;
	
	@JsonProperty("billing_type")
	private FCBillingType billingType;
	
	@JsonProperty("sales_agent")
	private String salesAgent;
	
	@JsonProperty("username")
	private String userName;
	@JsonProperty("password")
	private String password;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("language")
	private String language;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("login_id")
	private String loginId;
	
	
	public String getSignUpCode() {
		return signUpCode;
	}
	public void setSignUpCode(String signUpCode) {
		this.signUpCode = signUpCode;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public FcV2customer setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
		return this;
	}
}
