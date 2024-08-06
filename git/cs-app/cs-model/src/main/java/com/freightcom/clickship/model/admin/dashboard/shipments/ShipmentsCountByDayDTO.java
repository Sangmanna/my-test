package com.freightcom.clickship.model.admin.dashboard.shipments;

import java.math.BigInteger;

public class ShipmentsCountByDayDTO {

	private int day;

	private int hour;

	private BigInteger count;

	public ShipmentsCountByDayDTO(Object[] columns) {
		super();
		this.day = (int) columns[0];
		this.hour = (int) columns[1];
		this.count = (BigInteger) columns[2];
	}

	public ShipmentsCountByDayDTO(int day, int hour, Long count) {
		super();
		this.day = day;
		this.hour = hour;
		this.count = BigInteger.valueOf(count);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getCount() {
		return count.intValueExact();
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

}
