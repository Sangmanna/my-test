package com.freightcom.clickship.data.entity;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "jwt")
public class JWT {

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class )
	@Column(name = "id", nullable = false, updatable = false)
	String id;

	@Column(name = "username", nullable = false, updatable = false)
	String username;

	@Column(name = "jwt", nullable = false)
	String jwt;

	@Column(name = "expire_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date expireDatetime;

	public JWT() {
		super();
	}
	
	public JWT(String username, String jwt) {
		this.username = username;
		this.jwt = jwt;
	}
	
	@PrePersist
	public void setExpireDatetime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 18000); // this needs to be the same as in
											// SecurityConstants.ACCESS_TOKEN_VALIDITY_SECONDS, 5 * 60 * 60 = 18000
		expireDatetime = cal.getTime();
	}

	public String getId() {
		return id;
	}

	public JWT setId(String id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public JWT setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getJwt() {
		return jwt;
	}

	public JWT setJwt(String jwt) {
		this.jwt = jwt;
		return this;
	}

	public Date getExpireDatetime() {
		return expireDatetime;
	}

	public JWT setExpireDatetime(Date expireDatetime) {
		this.expireDatetime = expireDatetime;
		return this;
	}

}
