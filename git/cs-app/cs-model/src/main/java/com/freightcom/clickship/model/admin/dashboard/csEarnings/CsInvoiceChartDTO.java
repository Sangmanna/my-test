package com.freightcom.clickship.model.admin.dashboard.csEarnings;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CsInvoiceChartDTO {
	private String day;
	private Double total;
	private int term;
	
	public CsInvoiceChartDTO(Object[] cols) {
		super();
		this.term = Integer.parseInt((String)cols[0]);
		this.day = (String) cols[1];
		this.total = (Double) cols[2];
	}
	
	public CsInvoiceChartDTO(String day, Double total) {
		super();
		this.day = day;
		this.total = total;
	}
	
	public CsInvoiceChartDTO(Double total) {
		super();
		this.total = total;
	}
	
	public CsInvoiceChartDTO(String term, String day, Double total) {
		super();
		this.term =  Integer.parseInt(term);
		this.day = day;
		this.total = total;
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
	
	
	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
	
	public static List<CsInvoiceChartDTO> setTermForList(List<CsInvoiceChartDTO> csList,int term) {
		csList.forEach(t -> t.setTerm(term));
		return csList;
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
