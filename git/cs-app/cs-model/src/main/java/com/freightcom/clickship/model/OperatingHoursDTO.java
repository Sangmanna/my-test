package com.freightcom.clickship.model;

import java.util.Date;

public class OperatingHoursDTO {
	
	private String day;
	private Date openTime;
	private Date closeTime;

	public String getDay() {
		return day;
	}

	public OperatingHoursDTO setDay(String day) {
		this.day = day;
		return this;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public OperatingHoursDTO setOpenTime(Date openTime) {
		this.openTime = openTime;
		return this;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public OperatingHoursDTO setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
		return this;
	}

}
