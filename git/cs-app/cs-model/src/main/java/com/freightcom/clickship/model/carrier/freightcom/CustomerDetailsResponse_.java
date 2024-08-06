package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.freightcom.net/XMLSchema", name = "Freightcom")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDetailsResponse_ extends Freightcom implements Serializable {

	private static final long serialVersionUID = 9079848123628200784L;
	
	@XmlElement(name= "success")
	private boolean success;
	
	@XmlElement(name= "CustomerDetailsRequestReply")
	private CustomerDetailsResponse response;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public CustomerDetailsResponse getResponse() {
		return response;
	}

	public void setResponse(CustomerDetailsResponse response) {
		this.response = response;
	}
	
}
