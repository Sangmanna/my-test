package com.freightcom.clickship.model.admin.dashboard.stores;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StoreCountsByWeekOrMonth {

	private String day;

	private String storeName;

	private BigInteger count;

	public StoreCountsByWeekOrMonth(Object[] columns) {
		super();
		
		this.day = (String) columns[0];
		this.storeName = (String) columns[1];
		this.count = (BigInteger) columns[2];
	}
	
	public StoreCountsByWeekOrMonth(Object storeName, Object count) {
		super();
		this.storeName = (String) storeName;
		this.count = (BigInteger) count;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public BigInteger getCount() {
		return count;
	}
	
	public int getCountIntVal() {
		return count.intValueExact();
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

	public Integer getHourOfDay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy HH");
		return LocalDateTime.parse(this.day, dtf).getHour(); 
	}
	
	public LocalDate getParsedDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
		return LocalDate.parse(this.day, dtf);
	}
}
