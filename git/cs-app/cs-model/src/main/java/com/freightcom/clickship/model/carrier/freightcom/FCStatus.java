package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Status")
@XmlAccessorType(XmlAccessType.FIELD)
public class FCStatus implements Serializable {

	private static final long serialVersionUID = -4704156201013202954L;

	@XmlAttribute(name = "statusId")
	private String statusId;
	
	@XmlAttribute(name = "statusName")
	private String statusName;

	public String getStatusId() {
		return statusId;
	}

	public FCStatus setStatusId(String statusId) {
		this.statusId = statusId;
		return this;
	}

	public String getStatusName() {
		return statusName;
	}

	public FCStatus setStatusName(String statusName) {
		this.statusName = statusName;
		return this;
	}
	
}
