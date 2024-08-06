package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "RegisterCustomerRequestReply")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisterCustomerResponse implements Serializable {

	private static final long serialVersionUID = 9079848123628200784L;

	@XmlElement(name= "Customer")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
