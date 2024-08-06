package com.freightcom.clickship.model.shipment;

import java.util.Date;

public class TrackingInformationDTO {
	
	private String name;
	
	private Date datetime;
	
	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
