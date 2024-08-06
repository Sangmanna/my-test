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
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;

@Entity
@Table(name = "shipment_tax")
public class ShipmentTax extends BaseEntity implements CustomerAssociateEntity{

	private static final long serialVersionUID = -3937502878554288849L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipment_id")
	@JsonIgnore
	private Shipment shipment;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "price")
	private Double price;

	public ShipmentTax() {

	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public ShipmentTax setId(String id) {
		this.id = id;
		return this;
	}
	
	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
