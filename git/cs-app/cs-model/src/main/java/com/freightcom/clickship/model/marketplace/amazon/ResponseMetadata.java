package com.freightcom.clickship.model.marketplace.amazon;


import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResponseMetadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseMetadata implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="RequestId")
	private String RequestId;
	
	public ResponseMetadata() {
		super();
	}
	
	public ResponseMetadata(String RequestId) {
		super();
		this.RequestId = RequestId;
	}

	public String getRequestId() {
		return RequestId;
	}

	public void setRequestId(String RequestId) {
		this.RequestId = RequestId;
	}
	
	@Override
	public String toString() {
		return "ResponseMetadata [RequestId="+RequestId+"]";
	}
	
}
