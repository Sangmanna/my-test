package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ErrorReply")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorReply implements Serializable {

	private static final long serialVersionUID = 8175881455130578050L;

	@XmlElement(name= "Error")
	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	
}
