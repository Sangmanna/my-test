package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.reports.ReportScheduleCountResult;

@XmlRootElement(namespace = "http://mws.amazonaws.com/doc/2009-01-01/", name = "GetReportScheduleCountResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportScheduleCountResponse implements Serializable {

	private static final long serialVersionUID = 7502421251373602493L;

	@XmlElement(name="GetReportScheduleCountResult")
	private ReportScheduleCountResult reportScheduleCount;

	public ReportScheduleCountResult getReportScheduleCount() {
		return reportScheduleCount;
	}

	public void setReportScheduleCount(ReportScheduleCountResult reportScheduleCount) {
		this.reportScheduleCount = reportScheduleCount;
	}
	
}
