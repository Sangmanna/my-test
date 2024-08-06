package com.freightcom.clickship.model.marketplace.amazon.reports.list;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetReportListResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class Report implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name="HasNext")
	private String hasNext;
	
	@XmlElement(name="NextToken")
	private String nextToken;
	
	@XmlElement(name="ReportInfo")
	private List<ReportInfo> reportInfo;
	
	public Report() {
		super();
	}

	public String getNextToken() {
		return nextToken;
	}

	public void setNextToken(String nextToken) {
		this.nextToken = nextToken;
	}

	public String getHasNext() {
		return hasNext;
	}

	public void setHasNext(String hasNext) {
		this.hasNext = hasNext;
	}

	public List<ReportInfo> getReportInfo() {
		return reportInfo;
	}

	public void setReportInfo(List<ReportInfo> reportInfo) {
		this.reportInfo = reportInfo;
	}
}
