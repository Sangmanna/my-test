package com.freightcom.clickship.model.marketplace.amazon.orderitems;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListOrderItemsResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListOrderItemsResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="AmazonOrderId")
	private String amazonOrderId;
	
	@XmlElement(name="OrderItems")
	private List<OrderItems> listOrderItems;
	
	public ListOrderItemsResult() {
		super();
	}
	
	public ListOrderItemsResult(String amazonOrderId, List<OrderItems> listOrderItems) {
		super();
		this.amazonOrderId = amazonOrderId;
		this.listOrderItems = listOrderItems;
		
	}

	public String getAmazonOrderId() {
		return amazonOrderId;
	}

	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}

	public List<OrderItems> getListOrderItems() {
		return listOrderItems;
	}

	public void setListOrderItems(List<OrderItems> listOrderItems) {
		this.listOrderItems = listOrderItems;
	}
}
