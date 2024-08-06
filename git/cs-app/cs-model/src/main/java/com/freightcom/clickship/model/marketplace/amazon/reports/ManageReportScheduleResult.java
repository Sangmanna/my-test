package com.freightcom.clickship.model.marketplace.amazon.reports;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ManageReportScheduleResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManageReportScheduleResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name="ReportSchedule")
	private List<ReportSchedule> reportSchedule;
	
	@XmlElement(name="Count")
	private String count;
	
	public List<ReportSchedule> getReportSchedule() {
		return reportSchedule;
	}

	public void setReportSchedule(List<ReportSchedule> reportSchedule) {
		this.reportSchedule = reportSchedule;
	}

	public ManageReportScheduleResult() {
		super();
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}
