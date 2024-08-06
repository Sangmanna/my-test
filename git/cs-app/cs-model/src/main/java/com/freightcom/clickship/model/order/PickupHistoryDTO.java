package com.freightcom.clickship.model.order;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class PickupHistoryDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -3578624972161583923L;

	private String orderNumber;
	private String pickupDate;
	private String pickupTime;
	private String location;
	private String carrierName;
	private String confirmationNumber;
	private String shipmentId;
	private boolean isCancel;

	public String getOrderNumber() {
		return orderNumber;
	}

	public PickupHistoryDTO setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public PickupHistoryDTO setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
		return this;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public PickupHistoryDTO setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public PickupHistoryDTO setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public PickupHistoryDTO setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public PickupHistoryDTO setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
		return this;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public PickupHistoryDTO setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public boolean isCancel() {
		return isCancel;
	}

	public PickupHistoryDTO setCancel(boolean isCancel) {
		this.isCancel = isCancel;
		return this;
	}
}
