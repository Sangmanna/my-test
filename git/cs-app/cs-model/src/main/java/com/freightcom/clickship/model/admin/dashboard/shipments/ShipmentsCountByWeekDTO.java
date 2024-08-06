package com.freightcom.clickship.model.admin.dashboard.shipments;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShipmentsCountByWeekDTO {

	private BigInteger week;

	private String day;

	private BigInteger count;

	private LocalDate date;

	public ShipmentsCountByWeekDTO(Object[] columns) {
		super();
		this.week = (BigInteger) columns[0];
		this.day = (String) columns[1];
		if(columns[2] instanceof BigDecimal) {
			this.count = ((BigDecimal) columns[2]).toBigInteger();
		}else{
			this.count = (BigInteger) columns[2];
		}
	}

	public int getWeek() {
		return week.intValueExact();
	}

	public void setWeek(BigInteger week) {
		this.week = week;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getCount() {
		return count.intValueExact();
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getParsedDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
		return LocalDate.parse(this.day, dtf);
	}

}
