package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PickupAvailability {

	@JsonProperty("date")
	private Date date;

	@JsonProperty("open_time")
	private TimeOfDay openTime;

	@JsonProperty("close_time")
	private TimeOfDay closeTime;

	public Date getDate() {
		return date;
	}

	public PickupAvailability setDate(Date date) {
		this.date = date;
		return this;
	}

	public TimeOfDay getOpenTime() {
		return openTime;
	}

	public PickupAvailability setOpenTime(TimeOfDay openTime) {
		this.openTime = openTime;
		return this;
	}

	public TimeOfDay getCloseTime() {
		return closeTime;
	}

	public PickupAvailability setCloseTime(TimeOfDay closeTime) {
		this.closeTime = closeTime;
		return this;
	}

}
