package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.freightcom.net/XMLSchema", name = "Freightcom")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateCustomerRequest extends FreightcomAuth implements Serializable {

	private static final long serialVersionUID = -5190540986830637651L;

	@XmlElement(name= "UpdateCustomerRequest")
	private FCCustomer updateCustomer;
	
	public UpdateCustomerRequest() {
		super();
	}

	public UpdateCustomerRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FCCustomer getUpdateCustomer() {
		return updateCustomer;
	}

	public void setUpdateCustomer(FCCustomer updateCustomer) {
		this.updateCustomer = updateCustomer;
	}
}
