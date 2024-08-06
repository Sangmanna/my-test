package com.freightcom.clickship.data.entity;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "verificationtoken")
public class VerificationToken extends BaseEntity {

	private static final long serialVersionUID = -3003403000053546822L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "token")
	private String token;

	@Column(name = "username")
	private String username;

	@Column(name = "expirydate")
	private Date expiryDate;

	public VerificationToken() {
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public VerificationToken setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
		return this;
	}

	public String getId() {
		return id;
	}

	public VerificationToken setId(String id) {
		this.id = id;
		return this;
	}

	public String getToken() {
		return token;
	}

	public VerificationToken setToken(String token) {
		this.token = token;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public VerificationToken setUsername(String username) {
		this.username = username;
		return this;
	}

	public VerificationToken setExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		this.expiryDate = cal.getTime();
		return this;
	}
}