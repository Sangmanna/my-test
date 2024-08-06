package com.freightcom.clickship.model.marketplace.amazon.orders.fulfillment;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="OrderFulfillment")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderFulfillment {
	
	@XmlElement(name="AmazonOrderID")
	private String amazonOrderId;
	
	@XmlElement(name="FulfillmentDate")
	private String fulfillmentDate;

	@XmlElement(name="FulfillmentData")
	private FulfillmentData fulfillmentData;
	
	@XmlElement(name="Item")
	private List<Item> item;
	
	public OrderFulfillment() {
		
	}

	public String getAmazonOrderId() {
		return amazonOrderId;
	}

	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}

	public String getFulfillmentDate() {
		return fulfillmentDate;
	}

	public void setFulfillmentDate(String fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}

	public FulfillmentData getFulfillmentData() {
		return fulfillmentData;
	}

	public void setFulfillmentData(FulfillmentData fulfillmentData) {
		this.fulfillmentData = fulfillmentData;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	
	
}
