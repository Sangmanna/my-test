package com.freightcom.clickship.model.marketplace.amazon.reports;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ManageReportScheduleResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManageReportScheduleResponse implements Serializable {
	
	private static final long serialVersionUID = 7224182600843738767L;

	@XmlElement(name="ManageReportScheduleResult")
	private ManageReportScheduleResult manageReportScheduleResult;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata responseMetadata;
	
	public ManageReportScheduleResponse() {
		super();
	}

	public ManageReportScheduleResult getManageReportScheduleResult() {
		return manageReportScheduleResult;
	}



	public void setManageReportScheduleResult(ManageReportScheduleResult manageReportScheduleResult) {
		this.manageReportScheduleResult = manageReportScheduleResult;
	}



	public ResponseMetadata getResponseMetadata() {
		return responseMetadata;
	}

	public void setResponseMetadata(ResponseMetadata responseMetadata) {
		this.responseMetadata = responseMetadata;
	}

}
