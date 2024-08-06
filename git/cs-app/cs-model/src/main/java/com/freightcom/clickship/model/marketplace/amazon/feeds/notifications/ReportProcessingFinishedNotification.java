package com.freightcom.clickship.model.marketplace.amazon.feeds.notifications;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReportProcessingFinishedNotification")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportProcessingFinishedNotification implements Serializable {
	
	private static final long serialVersionUID = 3475492589419632357L;

	@XmlElement(name="SellerId")
	private String sellerId;
	
	@XmlElement(name="ReportRequestId")
	private String reportRequestId;
	
	@XmlElement(name="ReportId")
	private String reportId;
	
	@XmlElement(name="ReportType")
	private String reportType;
	
	@XmlElement(name="ReportProcessingStatus")
	private String reportProcessingStatus;
	
	public ReportProcessingFinishedNotification() {
			
	}
	
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getReportRequestId() {
		return reportRequestId;
	}

	public void setReportRequestId(String reportRequestId) {
		this.reportRequestId = reportRequestId;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportProcessingStatus() {
		return reportProcessingStatus;
	}

	public void setReportProcessingStatus(String reportProcessingStatus) {
		this.reportProcessingStatus = reportProcessingStatus;
	}
	
}
