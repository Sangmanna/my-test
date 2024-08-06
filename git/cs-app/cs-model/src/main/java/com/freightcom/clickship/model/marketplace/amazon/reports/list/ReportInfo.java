package com.freightcom.clickship.model.marketplace.amazon.reports.list;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReportInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportInfo implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name="ReportId")
	private String reportId;
	
	@XmlElement(name="ReportType")
	private String reportType;
	
	@XmlElement(name="Acknowledged")
	private String acknowledged;
	
	@XmlElement(name="AvailableDate")
	private String availableDate;
	
	@XmlElement(name="ReportRequestId")
	private String reportRequestId;
	
	public ReportInfo() {
		super();
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(String acknowledged) {
		this.acknowledged = acknowledged;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportRequestId() {
		return reportRequestId;
	}

	public void setReportRequestId(String reportRequestId) {
		this.reportRequestId = reportRequestId;
	}

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}
}
