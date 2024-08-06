package com.freightcom.clickship.model.order;

import java.io.Serializable;
import java.util.Date;

public class PickupWhileShipmentDTO implements Serializable {
	private static final long serialVersionUID = -1214513347229957349L;
	
	private String pickupLocation;
    private String contactName;
    private PhoneNumberDTO contactPhoneNumber;

    private DateDTO date;
    private TimeDTO readyAt;
    private TimeDTO readyUntil;

    // CS DB save. It has datetime in DB. So these fields required for CS UI
    private Date pickupStartDateForCS;
    private Date pickupEndDateForCS;

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public PhoneNumberDTO getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(PhoneNumberDTO contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public DateDTO getDate() {
        return date;
    }

    public void setDate(DateDTO date) {
        this.date = date;
    }

    public TimeDTO getReadyAt() {
        return readyAt;
    }

    public void setReadyAt(TimeDTO readyAt) {
        this.readyAt = readyAt;
    }

    public TimeDTO getReadyUntil() {
        return readyUntil;
    }

    public void setReadyUntil(TimeDTO readyUntil) {
        this.readyUntil = readyUntil;
    }

    public Date getPickupStartDateForCS() {
        return pickupStartDateForCS;
    }

    public void setPickupStartDateForCS(Date pickupStartDateForCS) {
        this.pickupStartDateForCS = pickupStartDateForCS;
    }

    public Date getPickupEndDateForCS() {
        return pickupEndDateForCS;
    }

    public void setPickupEndDateForCS(Date pickupEndDateForCS) {
        this.pickupEndDateForCS = pickupEndDateForCS;
    }
}
