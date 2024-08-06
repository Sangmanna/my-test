package com.freightcom.clickship.model.marketplace.amazon.orders.cancel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="OrderAcknowledgement")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderAcknowledgement {
	
	@XmlElement(name="AmazonOrderID")
	private String amazonOrderId;
	
	@XmlElement(name="StatusCode")
	private String statusCode;
	
	@XmlElement(name="Item")
	private Item itemCancel;
	
	public OrderAcknowledgement() {
		
	}

	public String getAmazonOrderId() {
		return amazonOrderId;
	}

	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Item getItemCancel() {
		return itemCancel;
	}

	public void setItemCancel(Item itemCancel) {
		this.itemCancel = itemCancel;
	}
	
	
	
	
	

}
