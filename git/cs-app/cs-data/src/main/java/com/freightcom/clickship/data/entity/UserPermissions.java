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
@Table(name = "user_permissions")
public class UserPermissions extends BaseEntity {

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
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "username", updatable = false)
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "permission_id", updatable = false)
	@JsonIgnore
	private Permissions permission;
	
	@Column(name = "permission_type", nullable = false)
	private String permissionType;
	
	@Column(name = "permission_name", nullable = false)
	private String permissionName;
	
	@Column(name = "permission_value", nullable = false)
	private String permissionValue;
	
	public UserPermissions() {
		super();
	}

	public UserPermissions(User user, Permissions permission) {
		super();
		this.user = user;
		this.customer = user.getCustomer();
		
		this.permission = permission;
		this.permissionType = permission.getType();
		this.permissionName = permission.getName();
		this.permissionValue = permission.getValue();
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

	public UserPermissions setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public User getUser() {
		return user;
	}

	public UserPermissions setUser(User user) {
		this.user = user;
		return this;
	}
	
	public Permissions getPermission() {
		return permission;
	}

	public UserPermissions setPermission(Permissions permission) {
		this.permission = permission;
		return this;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public UserPermissions setPermissionType(String permissionType) {
		this.permissionType = permissionType;
		return this;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public UserPermissions setPermissionName(String permissionName) {
		this.permissionName = permissionName;
		return this;
	}

	public String getPermissionValue() {
		return permissionValue;
	}

	public UserPermissions setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
		return this;
	}

}
