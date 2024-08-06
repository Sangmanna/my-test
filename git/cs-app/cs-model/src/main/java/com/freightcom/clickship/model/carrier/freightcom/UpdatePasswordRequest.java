package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.freightcom.net/XMLSchema", name = "Freightcom")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdatePasswordRequest extends FreightcomAuth implements Serializable {

	private static final long serialVersionUID = 9079848123628200784L;

	@XmlElement(name= "UpdateCustomerPasswordRequest")
	private UpdatePassword updatePassword;
	
	public UpdatePasswordRequest() {
		super();
	}

	public UpdatePasswordRequest(String username, String password) {
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

	public UpdatePassword getUpdatePassword() {
		return updatePassword;
	}

	public void setUpdatePassword(UpdatePassword updatePassword) {
		this.updatePassword = updatePassword;
	}
	
}
