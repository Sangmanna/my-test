package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PalletServiceDetailsDTO {

	@JsonProperty("limited_access_type")
	private String limitedAccessType;

	@JsonProperty("limited_access_other")
	private String limitesAccessOther;

	@JsonProperty("in_bond")
	private boolean inBond = false;

	@JsonProperty("in_bond_details")
	private InBondDetailsDTO inBondDetailsDTO;

	@JsonProperty("appointment_delivery")
	private boolean appointmentDelivery = false;

	@JsonProperty("protect_from_freeze")
	private boolean protectFromFreeze = false;

	@JsonProperty("threshold_pickup")
	private boolean thresholdPickup = false;

	@JsonProperty("threshold_delivery")
	private boolean thresholDelivery = false;
	
	@JsonProperty("trade_show_delivery")
	private boolean tradeShowDelivery = false;

	public String getLimitedAccessType() {
		return limitedAccessType;
	}

	public void setLimitedAccessType(String limitedAccessType) {
		this.limitedAccessType = limitedAccessType;
	}

	public String getLimitesAccessOther() {
		return limitesAccessOther;
	}

	public void setLimitesAccessOther(String limitesAccessOther) {
		this.limitesAccessOther = limitesAccessOther;
	}

	public boolean isInBond() {
		return inBond;
	}

	public void setInBond(boolean inBond) {
		this.inBond = inBond;
	}

	public InBondDetailsDTO getInBondDetailsDTO() {
		return inBondDetailsDTO;
	}

	public void setInBondDetailsDTO(InBondDetailsDTO inBondDetailsDTO) {
		this.inBondDetailsDTO = inBondDetailsDTO;
	}

	public boolean isAppointmentDelivery() {
		return appointmentDelivery;
	}

	public void setAppointmentDelivery(boolean appointmentDelivery) {
		this.appointmentDelivery = appointmentDelivery;
	}

	public boolean isProtectFromFreeze() {
		return protectFromFreeze;
	}

	public void setProtectFromFreeze(boolean protectFromFreeze) {
		this.protectFromFreeze = protectFromFreeze;
	}

	public boolean isThresholdPickup() {
		return thresholdPickup;
	}

	public void setThresholdPickup(boolean thresholdPickup) {
		this.thresholdPickup = thresholdPickup;
	}

	public boolean isThresholDelivery() {
		return thresholDelivery;
	}

	public void setThresholDelivery(boolean thresholDelivery) {
		this.thresholDelivery = thresholDelivery;
	}

	public boolean isTradeShowDelivery() {
		return tradeShowDelivery;
	}

	public void setTradeShowDelivery(boolean tradeShowDelivery) {
		this.tradeShowDelivery = tradeShowDelivery;
	}
	
	

}
