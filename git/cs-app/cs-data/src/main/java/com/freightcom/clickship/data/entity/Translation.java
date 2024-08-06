package com.freightcom.clickship.data.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "translation")
public class Translation { 
	
	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@Column(name = "en")
	private String en;
	
	@Column(name = "fr")
	private String fr;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "verified")
	private boolean verified = false;
	
	@Column(name = "created_datetime")
	@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date createdDatetime;
	
	@Column(name = "update_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	public Date updateDatetime;
	
	@Column(name = "updated_by")
	@LastModifiedBy
	public String updatedBy;

	public String getId() {
		return id;
	}

	public Translation setId(String id) {
		this.id = id;
		return this;
	}

	public String getEn() {
		return en;
	}

	public Translation setEn(String en) {
		this.en = en;
		return this;
	}

	public String getFr() {
		return fr;
	}

	public Translation setFr(String fr) {
		this.fr = fr;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Translation setUrl(String url) {
		this.url = url;
		return this;
	}

	public boolean isVerified() {
		return verified;
	}

	public Translation setVerified(boolean verified) {
		this.verified = verified;
		return this;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
