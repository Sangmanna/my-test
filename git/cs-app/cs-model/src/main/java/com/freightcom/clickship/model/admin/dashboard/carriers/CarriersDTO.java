package com.freightcom.clickship.model.admin.dashboard.carriers;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CarriersDTO {

	private String day;
	
	private String name;
	
	private BigInteger count;
	
	private String shipmentType;

	
	
	public CarriersDTO(String day, String name, BigInteger count) {
		super();
		this.day = day;
		this.name = name;
		this.count = count;
	}
	
	public CarriersDTO(Object[] cols) {
		super();
		this.day = (String) cols[0];
		this.name = (String) cols[1];
		this.count = (BigInteger) cols[2];
		this.shipmentType = (String) cols[3];
	}

	public CarriersDTO(Object name, Object count) {
		this.name = (String) name;
		this.count = (BigInteger) count;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}
	
	
	
	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public Integer getHourOfDay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy HH:mm:ss");
		return LocalDateTime.parse(this.day, dtf).getHour(); 
	}
	
	public LocalDate getParsedDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
		return LocalDate.parse(this.day, dtf);
	}
	
}
