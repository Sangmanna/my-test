package com.freightcom.clickship.model.admin.dashboard.shipments;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShipmentsCountByMonthDTO {

	private BigInteger month;

	private String day;

	private BigInteger count;

	private LocalDate date;

	public ShipmentsCountByMonthDTO(Object[] columns) {
		super();
		this.month = (BigInteger) columns[0];
		this.day = (String) columns[1];
		if(columns[2] instanceof BigDecimal) {
			this.count = ((BigDecimal) columns[2]).toBigInteger();
		}else{
			this.count = (BigInteger) columns[2];
		}
	}

	public int getMonth() {
		return month.intValueExact();
	}

	public void setMonth(BigInteger month) {
		this.month = month;
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
		/* date format from database: "d-M-yyyy" */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
		return LocalDate.parse(this.day, dtf);
	}
}
