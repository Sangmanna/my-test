package com.freightcom.clickship.model.marketplace.amazon.reports;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetReportScheduleListResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportScheduleListResult implements Serializable {
	
	private static final long serialVersionUID = -1846969589128544030L;

	@XmlElement(name="ReportSchedule")
	private ReportSchedule reportSchedule;
	
	@XmlElement(name="HasNext")
	private boolean hasNext;

	public ReportSchedule getReportSchedule() {
		return reportSchedule;
	}

	public void setReportSchedule(ReportSchedule reportSchedule) {
		this.reportSchedule = reportSchedule;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

}
