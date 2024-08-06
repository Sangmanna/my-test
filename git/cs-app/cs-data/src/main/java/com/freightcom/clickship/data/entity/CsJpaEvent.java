package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "cs_jpa_events")
public class CsJpaEvent extends BaseEntity {

	private static final long serialVersionUID = 5882427048258051056L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@Column(name = "type")
	private String type;

	@Column(name = "action")
	private String action;
	
	@Column(name = "ref_key_1")
	private String refKey1;
	
	@Column(name = "ref_key_2")
	private String refKey2;
	
	@Column(name = "ref_key_3")
	private String refKey3;
	
	@Column(name = "status")
	private String status = "scheduled";
	
	@Column(name = "retry_count")
	private int retryCount = 0;

	public String getId() {
		return id;
	}

	public CsJpaEvent setId(String id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public CsJpaEvent setType(String type) {
		this.type = type;
		return this;
	}

	public String getAction() {
		return action;
	}

	public CsJpaEvent setAction(String action) {
		this.action = action;
		return this;
	}

	public String getRefKey1() {
		return refKey1;
	}

	public CsJpaEvent setRefKey1(String refKey1) {
		this.refKey1 = refKey1;
		return this;
	}

	public String getRefKey2() {
		return refKey2;
	}

	public CsJpaEvent setRefKey2(String refKey2) {
		this.refKey2 = refKey2;
		return this;
	}

	public String getRefKey3() {
		return refKey3;
	}

	public CsJpaEvent setRefKey3(String refKey3) {
		this.refKey3 = refKey3;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public CsJpaEvent setStatus(String status) {
		this.status = status;
		return this;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public CsJpaEvent setRetryCount(int retryCount) {
		this.retryCount = retryCount;
		return this;
	}

}
