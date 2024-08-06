package com.freightcom.clickship.model.order;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class PickupDateTimeForCarrierDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -1363597528114465781L;

	private String pickupDate;
	private String pickupTime;
	private String closeTime;

	private String nextPickupDate;
	private String nextPickupTime;
	private String nextCloseTime;

	public String getPickupDate() {
		return pickupDate;
	}

	public PickupDateTimeForCarrierDTO setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
		return this;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public PickupDateTimeForCarrierDTO setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
		return this;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public PickupDateTimeForCarrierDTO setCloseTime(String closeTime) {
		this.closeTime = closeTime;
		return this;
	}

	public String getNextPickupDate() {
		return nextPickupDate;
	}

	public PickupDateTimeForCarrierDTO setNextPickupDate(String nextPickupDate) {
		this.nextPickupDate = nextPickupDate;
		return this;
	}

	public String getNextPickupTime() {
		return nextPickupTime;
	}

	public PickupDateTimeForCarrierDTO setNextPickupTime(String nextPickupTime) {
		this.nextPickupTime = nextPickupTime;
		return this;
	}

	public String getNextCloseTime() {
		return nextCloseTime;
	}

	public PickupDateTimeForCarrierDTO setNextCloseTime(String nextCloseTime) {
		this.nextCloseTime = nextCloseTime;
		return this;
	}

}
