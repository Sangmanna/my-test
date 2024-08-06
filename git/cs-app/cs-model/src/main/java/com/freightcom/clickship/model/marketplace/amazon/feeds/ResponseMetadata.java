package com.freightcom.clickship.model.marketplace.amazon.feeds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ResponseMetadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseMetadata {
	
	@XmlElement(name="RequestId")
	private String requestId;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
