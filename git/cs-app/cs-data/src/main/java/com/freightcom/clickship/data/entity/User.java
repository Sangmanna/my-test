package com.freightcom.clickship.data.entity;

import java.util.Date;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "user")
@SQLRestriction("deleted <> 1")
public class User extends BaseEntity {

	private static final long serialVersionUID = -8504606635995295695L;

	@Id
	@Column(name = "username", nullable = false, updatable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "password_changed_date")
	private Date passwordChangedDate;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", updatable = false)
	@JsonIgnore
	private Customer customer;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "notes")
	private String notes;

	@Column(name = "validated")
	private Boolean validated = false;
	
	@Column(name = "deleted")
	private Boolean deleted = false;
	
	@Column(name = "active")
	private Boolean active = true;

	@Column(name = "last_login")
	private Date lastLogin;

	@Column(name = "user_role")
	private String userRole;
	
	@Column(name = "user_defined_role")
	private String userDefinedRole;
	
	@Column(name = "fc_user_id")
	private String fcUserId;
	
	@Column(name = "wrong_password_login_count")
	private int wrongPasswordLoginCount;

	public User() {
		
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public User setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public User setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public Boolean isValidated() {
		return validated;
	}

	public User setValidated(Boolean validated) {
		this.validated = validated;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public User setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public String getUserRole() {
		return userRole;
	}

	public User setUserRole(String userRole) {
		this.userRole = userRole;
		return this;
	}

	public Boolean getValidated() {
		return validated;
	}
	
	@Transient
	public String getId() {
		return null;
	}
	
	@Transient
	public BaseEntity setId(String id) {
		return null;
	}
	
	public String getFcUserId() {
		return fcUserId;
	}
	
	public User setFcUserId(String fcUserId) {
		this.fcUserId = fcUserId;
		return this;
	}
	
	public int getWrongPasswordLoginCount() {
		return wrongPasswordLoginCount;
	}
	
	public User setWrongPasswordLoginCount(int wrongPasswordLoginCount) {
		this.wrongPasswordLoginCount = wrongPasswordLoginCount;
		return this;
	}
	
	public Date getPasswordChangedDate() {
		return passwordChangedDate;
	}
	
	public User setPasswordChangedDate(Date passwordChangedDate) {
		this.passwordChangedDate = passwordChangedDate;
		return this;
	}
	
	public String getUserDefinedRole() {
		return userDefinedRole;
	}
	
	public User setUserDefinedRole(String userDefinedRole) {
		this.userDefinedRole = userDefinedRole;
		return this;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}
	
	public User setDeleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public User setActive(Boolean active) {
		this.active = active;
		return this;
	}
}
