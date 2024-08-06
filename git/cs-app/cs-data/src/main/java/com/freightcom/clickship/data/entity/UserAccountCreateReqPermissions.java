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
import com.freightcom.clickship.model.customer.userrole.Permissions;

@Entity
@Table(name = "user_account_create_request_permissions")
public class UserAccountCreateReqPermissions extends BaseEntity {

	private static final long serialVersionUID = -8504606635995295695L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_account_create_request_id", updatable = false)
	@JsonIgnore
	private UserAccountCreateReq userAccountCreateReq;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id", updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "permission_type", nullable = false)
	private String permissionType;
	
	@Column(name = "permission_name", nullable = false)
	private String permissionName;
	
	@Column(name = "permission_value", nullable = false)
	private String permissionValue;
	
	public UserAccountCreateReqPermissions() {
		super();
	}
	
	public UserAccountCreateReqPermissions(UserAccountCreateReq req, Permissions type, String name, String value) {
		super();
		this.email = req.getEmail();
		this.userAccountCreateReq = req;
		this.customer = req.getCustomer();
		
		this.permissionType = type.toString();
		this.permissionName = name;
		this.permissionValue = value;
	}

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public UserAccountCreateReq getUserAccountCreateReq() {
		return userAccountCreateReq;
	}

	public UserAccountCreateReqPermissions setUserAccountCreateReq(UserAccountCreateReq userAccountCreateReq) {
		this.userAccountCreateReq = userAccountCreateReq;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public UserAccountCreateReqPermissions setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserAccountCreateReqPermissions setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public UserAccountCreateReqPermissions setPermissionType(String permissionType) {
		this.permissionType = permissionType;
		return this;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public UserAccountCreateReqPermissions setPermissionName(String permissionName) {
		this.permissionName = permissionName;
		return this;
	}

	public String getPermissionValue() {
		return permissionValue;
	}

	public UserAccountCreateReqPermissions setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
		return this;
	}

}
