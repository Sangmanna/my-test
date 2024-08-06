package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "shipment_additional_services")
public class ShipmentAdditionalServices extends BaseEntity {

	private static final long serialVersionUID = -3764300951424523113L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne
	@JoinColumn(name = "shipment_id", updatable = false, nullable = false)
	private Shipment shipment;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "field_name")
	private String fieldName;

	@Column(name = "value")
	private String value;

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

	public ShipmentAdditionalServices setShipment(Shipment shipment) {
		this.shipment = shipment;
		return this;
	}

	public String getDisplayName() {
		return displayName;
	}

	public ShipmentAdditionalServices setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	public String getFieldName() {
		return fieldName;
	}

	public ShipmentAdditionalServices setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public String getValue() {
		return value;
	}

	public ShipmentAdditionalServices setValue(String value) {
		this.value = value;
		return this;
	}

}
