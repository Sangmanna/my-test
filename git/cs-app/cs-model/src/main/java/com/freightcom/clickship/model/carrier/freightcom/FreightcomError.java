package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.freightcom.net/XMLSchema", name = "Freightcom")
@XmlAccessorType(XmlAccessType.FIELD)
public class FreightcomError extends Freightcom implements Serializable {

	private static final long serialVersionUID = -2328261347057685432L;
	
	@XmlElement(name= "test")
	private String test;
	
	@XmlElement(name= "success")
	private boolean success;
	
	@XmlElement(name= "ErrorReply")
	private ErrorReply errorReply;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ErrorReply getErrorReply() {
		return errorReply;
	}

	public void setErrorReply(ErrorReply errorReply) {
		this.errorReply = errorReply;
	}

}
