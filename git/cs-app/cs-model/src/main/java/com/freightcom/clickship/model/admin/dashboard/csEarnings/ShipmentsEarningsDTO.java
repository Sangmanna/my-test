package com.freightcom.clickship.model.admin.dashboard.csEarnings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShipmentsEarningsDTO {

	private String date;
	private Double shippingCost;

	public String getDate() {
		return date;
	}

	public ShipmentsEarningsDTO(Object[] cols) {
		this.date = (String) cols[0];
		this.shippingCost = Double.valueOf((Float.valueOf(cols[1].toString())));
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}
	
	public LocalDate getParsedDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
		return LocalDate.parse(this.date, dtf);
	}

}
