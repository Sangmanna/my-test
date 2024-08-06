package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "CustomerDetailsRequestReply")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDetailsResponse implements Serializable {

	private static final long serialVersionUID = 9079848123628200784L;
	
	@XmlElement(name= "Profile")
	private Profile profile;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}
