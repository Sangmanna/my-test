package com.freightcom.clickship.model.order;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightcom.clickship.model.CommonDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -3156771884618322759L;
	
	private String orderNumber;
	private String carrierName;
	private String confirmationNumber;
	private Boolean status;
	private Date pickupStart;
	private Date pickupEnd;
	private String location;
	private String orderId;
	private String shipmentId;
	private String phone;
	private String contactName;
	private String shipmentType; // this filed added to fix bulk-shipping error
	private String pickUpInstructions;
	private PickupDateTimeForCarrierDTO forCarrier;

	private String pickupDropOffDate;
	private String pickupNearPostalCode;

	// for UI purpose
	private String pickupDate;
	private String pickupTime;
	private String closeTime;

	public String getOrderNumber() {
		return orderNumber;
	}

	public PickupDTO setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public PickupDTO setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public PickupDTO setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
		return this;
	}

	public Boolean getStatus() {
		return status;
	}

	public PickupDTO setStatus(Boolean status) {
		this.status = status;
		return this;
	}

	public PickupDTO setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
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

	public String getLocation() {
		return location;
	}

	public PickupDTO setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getOrderId() {
		return orderId;
	}

	public PickupDTO setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public String getPhone() {
		return phone;
	}

	public PickupDTO setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getContactName() {
		return contactName;
	}

	public PickupDTO setContactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public PickupDTO setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
		return this;
	}

	public String getPickUpInstructions() {
		return pickUpInstructions;
	}

	public PickupDTO setPickUpInstructions(String pickUpInstructions) {
		this.pickUpInstructions = pickUpInstructions;
		return this;
	}

	public PickupDateTimeForCarrierDTO getForCarrier() {
		return forCarrier;
	}

	public void setForCarrier(PickupDateTimeForCarrierDTO forCarrier) {
		this.forCarrier = forCarrier;
	}	
		
	public String getPickupDropOffDate() {
		return pickupDropOffDate;
	}

	public PickupDTO setPickupDropOffDate(String pickupDropOffDate) {
		this.pickupDropOffDate = pickupDropOffDate;
		return this;
	}

	public String getPickupNearPostalCode() {
		return pickupNearPostalCode;
	}

	public PickupDTO setPickupNearPostalCode(String pickupNearPostalCode) {
		this.pickupNearPostalCode = pickupNearPostalCode;
		return this;
	}
	
	public String getPickupDate() {
		return pickupDate;
	}

	public PickupDTO setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
		return this;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public PickupDTO setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
		return this;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public PickupDTO setCloseTime(String closeTime) {
		this.closeTime = closeTime;
		return this;
	}

	@JsonSetter("forCarrier")
    public void setForCarrier(Object value) {
		ObjectMapper mapper = new ObjectMapper();
		if (value instanceof String) {
	        String stringValue = (String) value;
	        if (!stringValue.isEmpty()) {
	            // Use Jackson to deserialize the input value to an instance of PickupDateTimeForCarrierDTO
	            try {
	                forCarrier = mapper.readValue(stringValue, PickupDateTimeForCarrierDTO.class);
	            } catch (IOException e) {
	                throw new RuntimeException("Failed to deserialize forCarrier field", e);
	            }
	        } else {
	            forCarrier = null;
	        }
	    } else if(value != null) {
	        forCarrier = mapper.convertValue(value, PickupDateTimeForCarrierDTO.class);
	    } else {
	    	forCarrier = null;
	    }
    }
	
}
