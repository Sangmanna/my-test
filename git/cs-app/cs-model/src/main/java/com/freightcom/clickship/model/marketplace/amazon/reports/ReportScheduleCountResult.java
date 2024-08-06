package com.freightcom.clickship.model.marketplace.amazon.reports;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetReportScheduleCountResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportScheduleCountResult implements Serializable {
	
	private static final long serialVersionUID = -3549681145905265930L;

	@XmlElement(name="Count")
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
