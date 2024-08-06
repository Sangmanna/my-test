package com.freightcom.clickship.model.carrier;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class CarrierPickupDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -4163019465649855302L;

	private String confirmationNumber;
	
	private boolean cancelPickupStatus;

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public CarrierPickupDTO setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
		return this;
	}

	public boolean isCancelPickupStatus() {
		return cancelPickupStatus;
	}

	public CarrierPickupDTO setCancelPickupStatus(boolean cancelPickupStatus) {
		this.cancelPickupStatus = cancelPickupStatus;
		return this;
	}
	
}
