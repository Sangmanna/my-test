package com.freightcom.clickship.model.marketplace.amazon.orders;


import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PaymentMethodDetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="PaymentMethodDetail")
	private String paymentMethodDetail;
	
	public PaymentMethodDetails() {
		super();
	}
	
	public PaymentMethodDetails(String paymentMethodDetail) {
		super();
		this.paymentMethodDetail = paymentMethodDetail;
		
	}

	public String getPaymentMethodDetail() {
		return paymentMethodDetail;
	}

	public void setPaymentMethodDetail(String paymentMethodDetail) {
		this.paymentMethodDetail = paymentMethodDetail;
	}
	
	

}
