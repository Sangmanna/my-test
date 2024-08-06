package com.freightcom.clickship.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "insurance")
public class Insurance extends BaseEntity {
	
	private static final long serialVersionUID = 8363435315532857043L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class )
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shipment_id", updatable = false)
	@JsonIgnore
	private Shipment shipment;
	
	@Column(name = "internal_order_number")
	private String internalOrderNumber;
	
	@Column(name = "insured_amount")
	private Double insuredAmount;
	
	@Column(name = "insurance_cost")
	private Double insuranceCost;
	
	@Column(name = "insured_by")
	private String insuredBy;
	
	@Column(name = "voided")
	private Boolean voided;
	
	@Column(name = "voided_date")
	private Date voidedDate;
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}
	
	public Shipment getShipment() {
		return shipment;
	}

	public Insurance setShipment(Shipment shipment) {
		this.shipment = shipment;
		return this;
	}

	public String getInternalOrderNumber() {
		return internalOrderNumber;
	}

	public Insurance setInternalOrderNumber(String internalOrderNumber) {
		this.internalOrderNumber = internalOrderNumber;
		return this;
	}

	public Double getInsuredAmount() {
		return insuredAmount;
	}

	public Insurance setInsuredAmount(Double insuredAmount) {
		this.insuredAmount = insuredAmount;
		return this;
	}

	public Double getInsuranceCost() {
		return insuranceCost;
	}

	public Insurance setInsuranceCost(Double insuranceCost) {
		this.insuranceCost = insuranceCost;
		return this;
	}

	public String getInsuredBy() {
		return insuredBy;
	}

	public Insurance setInsuredBy(String insuredBy) {
		this.insuredBy = insuredBy;
		return this;
	}

	public Boolean getVoided() {
		return voided;
	}

	public Insurance setVoided(Boolean voided) {
		this.voided = voided;
		return this;
	}

	public Date getVoidedDate() {
		return voidedDate;
	}

	public Insurance setVoidedDate(Date voidedDate) {
		this.voidedDate = voidedDate;
		return this;
	}

}
