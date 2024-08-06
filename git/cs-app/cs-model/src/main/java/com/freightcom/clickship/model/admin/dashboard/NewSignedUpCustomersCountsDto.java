package com.freightcom.clickship.model.admin.dashboard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewSignedUpCustomersCountsDto {

	private Long  count;
	
	private String date;

	public Long getCount() {
		return count;
	}

	public NewSignedUpCustomersCountsDto(Object[] obj) {
		super();
		this.count = Long.valueOf(obj[0].toString());
		this.date = obj[1].toString();
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public LocalDate getParsedDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
		return LocalDate.parse(this.date, dtf);
	}
	
}
