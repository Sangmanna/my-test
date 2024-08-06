package com.freightcom.clickship.model.marketplace.amazon.orderitems;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "CODFeeDiscount")
@XmlAccessorType(XmlAccessType.FIELD)
public class CODFeeDiscount {
	@XmlElement(name="Amount")
	private String amount;
	@XmlElement(name="CurrencyCode")
	private String currencyCode;
	
	public CODFeeDiscount() {
		super();
	}
	
	public CODFeeDiscount(String amount, String currencyCode) {
		super();
		this.amount = amount;
		this.currencyCode = currencyCode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}	
}
