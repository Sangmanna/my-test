package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.freightcom.net/XMLSchema", name = "Freightcom")
@XmlAccessorType(XmlAccessType.FIELD)
public class FCCreditCardRequest extends FreightcomAuth implements Serializable {

	private static final long serialVersionUID = 4316633291858438982L;
	
	@XmlElement(name= "CSCreditCardRequest")
	private FCCreditCard creditCard;

	public FCCreditCardRequest() {
		super();
	}

	public FCCreditCardRequest(String username, String password) {
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

	public FCCreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(FCCreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}
