package com.freightcom.clickship.model.carrier.freightcom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CSCreditCardRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class FCCreditCard {

	@XmlAttribute(name = "ccNumber")
	private String number;
	
	@XmlAttribute(name = "ccExpiryMonth")
	private String month;
	
	@XmlAttribute(name = "ccExpiryYear")
	private String year;
	
	@XmlAttribute(name = "ccCvd")
	private String cvv;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
