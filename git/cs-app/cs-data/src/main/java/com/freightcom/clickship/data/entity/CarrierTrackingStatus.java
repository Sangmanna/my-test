package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "carrier_tracking_status")
public class CarrierTrackingStatus  extends BaseEntity {

	private static final long serialVersionUID = 5785837617095253427L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)	
	private String id;	
	
	@Column(name = "carrier", nullable = false)
	private String carrier;

	@Column(name = "status_code", nullable = false)
	private String statusCode;
	
	@Column(name = "status", nullable = false)
	private String status;	
	
	@Column(name = "status_description", nullable = false)
	private String statusDescription;

	public String getId() {
		return id;
	}

	public CarrierTrackingStatus setId(String id) {
		this.id = id;
		return this;
	}

	public String getCarrier() {
		return carrier;
	}

	public CarrierTrackingStatus setCarrier(String carrier) {
		this.carrier = carrier;
		return this;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public CarrierTrackingStatus setStatusCode(String statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public CarrierTrackingStatus setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public CarrierTrackingStatus setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
		return this;
	}


}
