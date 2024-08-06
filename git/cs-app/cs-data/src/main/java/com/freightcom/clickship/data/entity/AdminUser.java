package com.freightcom.clickship.data.entity;

import java.util.Date;

import jakarta.persistence.Transient;

import com.freightcom.clickship.data.entity.common.BaseEntity;

public class AdminUser extends BaseEntity {

	private static final long serialVersionUID = -8504606635990095695L;

	private String username;
	private String password;
	private String agentName;
	private String email;
	private String userRole;
	private String notes;
	private Date lastLogin;

	public AdminUser() {
		
	}
	
	public AdminUser(Object[] columns) {
		super();
		this.username = (String)columns[0];
		this.password = (String) columns[1];
		this.userRole = (String) columns[2];
		this.agentName = (String) columns[3];
		this.email = (String) columns[4];
	}

	public AdminUser(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public AdminUser setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public AdminUser setPassword(String password) {
		this.password = password;
		return this;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public AdminUser setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public AdminUser setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public AdminUser setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public String getUserRole() {
		return userRole;
	}

	public AdminUser setUserRole(String userRole) {
		this.userRole = userRole;
		return this;
	}
	
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	@Transient
	public String getId() {
		return null;
	}
	
	@Transient
	public BaseEntity setId(String id) {
		return null;
	}
	
}
