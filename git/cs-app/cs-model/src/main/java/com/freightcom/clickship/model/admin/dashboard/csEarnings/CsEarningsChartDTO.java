package com.freightcom.clickship.model.admin.dashboard.csEarnings;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CsEarningsChartDTO {

	private String category;
	private Double charge;
	private String day;
	private Double total;

	public CsEarningsChartDTO(Object[] cols) {
		super();
		this.category = (String) cols[0];
		this.charge = (Double) cols[1];
		this.day = (String) cols[2];
		this.total = (Double) cols[3];
	}

	public CsEarningsChartDTO(String category, Double charge, String day, Double total) {
		super();
		this.category = category;
		this.charge = charge;
		this.day = day;
		this.total = total;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public LocalDate getParsedDateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy HH:mm:ss");
		return LocalDate.parse(this.day, dtf);
	}
	
	public LocalDate getParsedDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
		return LocalDate.parse(this.day, dtf);
	}
	
	public int getHour() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy HH");
		return LocalDateTime.parse(this.day, dtf).getHour();
	}

}
