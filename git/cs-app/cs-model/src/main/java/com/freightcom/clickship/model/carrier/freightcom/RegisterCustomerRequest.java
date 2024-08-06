package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.freightcom.net/XMLSchema", name = "Freightcom")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisterCustomerRequest extends Freightcom implements Serializable {

	private static final long serialVersionUID = 9079848123628200784L;

	@XmlElement(name= "RegisterCustomerRequest")
	private FCCustomer registerCustomer;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public FCCustomer getRegisterCustomer() {
		return registerCustomer;
	}

	public void setRegisterCustomer(FCCustomer registerCustomer) {
		this.registerCustomer = registerCustomer;
	}
	
}
