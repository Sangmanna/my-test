package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "marketplace_process_failures")
public class MarketplaceProcessFailure extends BaseEntity {

	private static final long serialVersionUID = 3466639965957887342L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_id", updatable = false, nullable=false)
	private Marketplace marketplace;
	
	@Column(name = "failure_type")
	private String failureType;

	@Column(name = "reference_id")
	private String referenceId;

	@Column(name = "error")
	private String errorMessage;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public MarketplaceProcessFailure setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public String getFailureType() {
		return failureType;
	}

	public MarketplaceProcessFailure setFailureType(String failureType) {
		this.failureType = failureType;
		return this;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public MarketplaceProcessFailure setReferenceId(String referenceId) {
		this.referenceId = referenceId;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public MarketplaceProcessFailure setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
}