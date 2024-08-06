package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperatingHours {

	@JsonProperty("day")
	private String day;

	@JsonProperty("open")
	private TimeOfDay open;

	@JsonProperty("close")
	private TimeOfDay close;

	public String getDay() {
		return day;
	}

	public OperatingHours setDay(String day) {
		this.day = day;
		return this;
	}

	public TimeOfDay getOpen() {
		return open;
	}

	public OperatingHours setOpen(TimeOfDay open) {
		this.open = open;
		return this;
	}

	public TimeOfDay getClose() {
		return close;
	}

	public OperatingHours setClose(TimeOfDay close) {
		this.close = close;
		return this;
	}

}
