package com.freightcom.clickship.model.carrier.freightcom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CustomerDetailsRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDetails {

	@XmlAttribute
	private String validate = "true";

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}
	
}
