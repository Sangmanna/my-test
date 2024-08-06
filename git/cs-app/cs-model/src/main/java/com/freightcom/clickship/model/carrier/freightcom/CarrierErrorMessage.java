	package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CarrierErrorMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarrierErrorMessage implements Serializable {

	private static final long serialVersionUID = 7305551297505972502L;

	@XmlAttribute(name = "size")
	private int size;
	
	@XmlAttribute(name = "errorMessage0")
	private String errorMessage0;
	
	@XmlAttribute(name = "errorMessage1")
	private String errorMessage1;

	public int getSize() {
		return size;
	}

	public CarrierErrorMessage setSize(int size) {
		this.size = size;
		return this;
	}

	public String getErrorMessage0() {
		return errorMessage0;
	}

	public CarrierErrorMessage setErrorMessage0(String errorMessage0) {
		this.errorMessage0 = errorMessage0;
		return this;
	}

	public String getErrorMessage1() {
		return errorMessage1;
	}

	public CarrierErrorMessage setErrorMessage1(String errorMessage1) {
		this.errorMessage1 = errorMessage1;
		return this;
	}
	
}
