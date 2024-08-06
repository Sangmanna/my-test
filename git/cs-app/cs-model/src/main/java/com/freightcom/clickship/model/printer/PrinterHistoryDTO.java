package com.freightcom.clickship.model.printer;

import java.util.Date;

public class PrinterHistoryDTO {

	private String id;
	
	private String message;
	
	private String status;
	
	private String jobName;
	
	private Date createdDate;
	
	private String labelType;
	
	private String printerName;

	private Integer labelCount;
	
	public String getId() {
		return id;
	}

	public PrinterHistoryDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getLabelType() {
		return labelType;
	}

	public PrinterHistoryDTO setLabelType(String labelType) {
		this.labelType = labelType;
		return this;
	}
	
	public String getPrinterName() {
		return printerName;
	}

	public PrinterHistoryDTO setPrinterName(String printerName) {
		this.printerName = printerName;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public PrinterHistoryDTO setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getJobName() {
		return jobName;
	}

	public PrinterHistoryDTO setJobName(String jobName) {
		this.jobName = jobName;
		return this;
	}

	public Integer getLabelCount() {
		return labelCount;
	}

	public PrinterHistoryDTO setLabelCount(Integer labelCount) {
		this.labelCount = labelCount;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public PrinterHistoryDTO setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public PrinterHistoryDTO setMessage(String message) {
		this.message = message;
		return this;
	}
	
}
