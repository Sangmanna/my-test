package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class UpdatePassword implements Serializable {
	
	private static final long serialVersionUID = 4391912170611990710L;
	
	@XmlAttribute
	private String newPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public UpdatePassword setNewPassword(String newPassword) {
		this.newPassword = newPassword;
		return this;
	}

}
