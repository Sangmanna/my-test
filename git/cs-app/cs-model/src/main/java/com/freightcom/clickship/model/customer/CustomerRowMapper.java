package com.freightcom.clickship.model.customer;

public class CustomerRowMapper {

	private String id;
	
	private String email;
	
	private String phone;
	
	private String username;
	
	private String password;
	
	private String lastName;
	
	private String firstName;
	
	private String chargebeeId;
	
	private String businessName;
	
	private String fcBillingType;
	
	private String chargebeeSubscriptionId;
	
	private String registrationSource;

	public CustomerRowMapper(String username, String password, String id, String businessName, String firstName,
			String lastName, String email, String phone, String fcBillingType, String chargebeeId,
			String chargebeeSubscriptionId, String registrationSource) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.businessName = businessName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.fcBillingType = fcBillingType;
		this.chargebeeId = chargebeeId;
		this.chargebeeSubscriptionId = chargebeeSubscriptionId;
		this.registrationSource = registrationSource;
	}

	public String getId() {
		return id;
	}

	public CustomerRowMapper setId(String id) {
		this.id = id;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public CustomerRowMapper setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public CustomerRowMapper setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public CustomerRowMapper setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public CustomerRowMapper setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public CustomerRowMapper setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getFcBillingType() {
		return fcBillingType;
	}

	public CustomerRowMapper setFcBillingType(String fcBillingType) {
		this.fcBillingType = fcBillingType;
		return this;
	}

	public String getChargebeeId() {
		return chargebeeId;
	}

	public CustomerRowMapper setChargebeeId(String chargebeeId) {
		this.chargebeeId = chargebeeId;
		return this;
	}

	public String getChargebeeSubscriptionId() {
		return chargebeeSubscriptionId;
	}

	public CustomerRowMapper setChargebeeSubscriptionId(String chargebeeSubscriptionId) {
		this.chargebeeSubscriptionId = chargebeeSubscriptionId;
		return this;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public CustomerRowMapper setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public CustomerRowMapper setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public CustomerRowMapper setPassword(String password) {
		this.password = password;
		return this;
	}

}
