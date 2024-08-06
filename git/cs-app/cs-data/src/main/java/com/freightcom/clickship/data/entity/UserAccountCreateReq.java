package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "user_account_create_request")
public class UserAccountCreateReq extends BaseEntity {

	private static final long serialVersionUID = -8504606635995295695L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id", updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_defined_role")
	private String userDefinedRole;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "uuid", nullable = false)
	private String uuid;
	
	@Transient
	private String confirmationUrl;
	
	public UserAccountCreateReq() {
		super();
	}
	
	public UserAccountCreateReq(Customer customer) {
		super();
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public UserAccountCreateReq setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UserAccountCreateReq setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UserAccountCreateReq setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getUserDefinedRole() {
		return userDefinedRole;
	}

	public UserAccountCreateReq setUserDefinedRole(String userDefinedRole) {
		this.userDefinedRole = userDefinedRole;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserAccountCreateReq setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public UserAccountCreateReq setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getUuid() {
		return uuid;
	}

	public UserAccountCreateReq setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public String getConfirmationUrl() {
		return confirmationUrl;
	}

	public UserAccountCreateReq setConfirmationUrl(String confirmationUrl) {
		this.confirmationUrl = confirmationUrl;
		return this;
	}

}
