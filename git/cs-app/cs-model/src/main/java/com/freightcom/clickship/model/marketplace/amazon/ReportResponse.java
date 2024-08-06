package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.reports.list.Report;

@XmlRootElement(name = "GetReportListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportResponse implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="GetReportListResult")
	private Report report;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata response;
	
	public ReportResponse() {
		super();
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report reportResult) {
		this.report = reportResult;
	}

	public ResponseMetadata getResponse() {
		return response;
	}

	public void setResponse(ResponseMetadata response) {
		this.response = response;
	}
}
