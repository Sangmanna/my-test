package com.freightcom.clickship.data.entity;

import java.util.Date;

import jakarta.persistence.Basic;
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

@Entity
@Table(name = "pickup")
public class Pickup extends BaseEntity {
	
	private static final long serialVersionUID = 7445434489817488839L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "shipment_id", nullable = false)
	@JsonIgnore
	private Shipment shipment;

	@Column(name = "location")
	private String location;

	@Basic
	@Column(name = "pickup_start")
	private Date pickupStart;

	@Basic
	@Column(name = "pickup_end")
	private Date pickupEnd;

	@Column(name = "confirmation_number")
	private String confirmationNumber;

	@Column(name = "status")
	private boolean status;
	
	@Column(name = "pick_up_instructions")
	private String pickUpInstructions;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}
	
	public Date getPickupTime() {
		return pickupEnd;
	}

	public Pickup setPickupTime(Date pickupTime) {
		this.pickupEnd = pickupTime;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public Pickup setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public Pickup setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public Pickup setStatus(boolean status) {
		this.status = status;
		return this;
	}
	
	public Shipment getShipment() {
		return shipment;
	}

	public Pickup setShipment(Shipment shipment) {
		this.shipment = shipment;
		return this;
	}

	public String getPickUpInstructions() {
		return pickUpInstructions;
	}

	public Pickup setPickUpInstructions(String pickUpInstructions) {
		this.pickUpInstructions = pickUpInstructions;
		return this;
	}

	public String getContactName() {
		return contactName;
	}

	public Pickup setContactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Pickup setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public Date getPickupStart() {
		return pickupStart;
	}

	public void setPickupStart(Date pickupStart) {
		this.pickupStart = pickupStart;
	}

	public Date getPickupEnd() {
		return pickupEnd;
	}

	public void setPickupEnd(Date pickupEnd) {
		this.pickupEnd = pickupEnd;
	}
}
