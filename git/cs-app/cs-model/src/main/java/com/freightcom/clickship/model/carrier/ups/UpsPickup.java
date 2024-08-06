
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "CloseTime", "PickupDate", "Date", "ReadyTime" })
public class UpsPickup implements Serializable {

	private static final long serialVersionUID = -5578273599248970266L;

	@JsonProperty("Date")
	private String date;
	
	@JsonProperty("ReadyTime")
	private String readyTime;
	
	@JsonProperty("PickupDate")
	private String pickupDate;
	
	@JsonProperty("CloseTime")
	private String closeTime;

	public String getDate() {
		return date;
	}

	public UpsPickup setDate(String date) {
		this.date = date;
		return this;
	}

	public String getReadyTime() {
		return readyTime;
	}

	public UpsPickup setReadyTime(String readyTime) {
		this.readyTime = readyTime;
		return this;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public UpsPickup setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
		return this;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public UpsPickup setCloseTime(String closeTime) {
		this.closeTime = closeTime;
		return this;
	}

}
