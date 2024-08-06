package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.reports.ReportScheduleListResult;

@XmlRootElement(namespace = "http://mws.amazonaws.com/doc/2009-01-01/", name = "GetReportScheduleListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportScheduleListResponse implements Serializable {

	private static final long serialVersionUID = 7502421251373602493L;

	@XmlElement(name="GetReportScheduleListResult")
	private ReportScheduleListResult reportScheduleResult;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata respose;

	public ReportScheduleListResult getReportScheduleResult() {
		return reportScheduleResult;
	}

	public void setReportScheduleResult(ReportScheduleListResult reportScheduleResult) {
		this.reportScheduleResult = reportScheduleResult;
	}

	public ResponseMetadata getRespose() {
		return respose;
	}

	public void setRespose(ResponseMetadata respose) {
		this.respose = respose;
	}
	
}
