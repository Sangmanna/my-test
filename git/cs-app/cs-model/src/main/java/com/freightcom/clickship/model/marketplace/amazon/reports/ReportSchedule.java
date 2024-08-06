package com.freightcom.clickship.model.marketplace.amazon.reports;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReportSchedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportSchedule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name="ReportType")
	private String reportType;
	
	@XmlElement(name="Schedule")
	private String schedule;

	@XmlElement(name="ScheduledDate")
	private String scheduledDate;
	
	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public ReportSchedule() {
		super();
	}
}
