package com.freightcom.clickship.model.customer.customerpreferences;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class PickupPreferenceDTO extends CommonDTO implements Serializable {
	private static final long serialVersionUID = -9174813451334152030L;
	
	private String id;
	private String carrierName;
	private String contactName;
	private String phoneNumber;
	private String pickupLocation;
	private String readyTime;
	private String closeTime;
	private String instruction;
	private boolean applyForAllCarriers = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getReadyTime() {
		return readyTime;
	}

	public void setReadyTime(String readyTime) {
		this.readyTime = readyTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	
	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public boolean isApplyForAllCarriers() {
		return applyForAllCarriers;
	}

	public void setApplyForAllCarriers(boolean applyForAllCarriers) {
		this.applyForAllCarriers = applyForAllCarriers;
	}
}
