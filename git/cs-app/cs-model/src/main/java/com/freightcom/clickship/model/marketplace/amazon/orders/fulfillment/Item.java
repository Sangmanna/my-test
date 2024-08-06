package com.freightcom.clickship.model.marketplace.amazon.orders.fulfillment;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	
	@XmlElement(name="AmazonOrderItemCode")
	private String amazonOrderItemCode;
	
	@XmlElement(name="Quantity")
	private int quantity;
	

	public Item() {
		
	}


	public String getAmazonOrderItemCode() {
		return amazonOrderItemCode;
	}


	public void setAmazonOrderItemCode(String amazonOrderItemCode) {
		this.amazonOrderItemCode = amazonOrderItemCode;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
