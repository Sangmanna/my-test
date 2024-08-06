package com.freightcom.clickship.model.marketplace.amazon.orderitems;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OrderItems")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItems implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="OrderItem")
	private List<OrderItem> listOrderItem;
	
	public OrderItems() {
		super();
		
	}
	
	public OrderItems(List<OrderItem> listOrderItem) {
		super();
		this.listOrderItem = listOrderItem;
	}

	public List<OrderItem> getListOrderItem() {
		return listOrderItem;
	}

	public void setListOrderItem(List<OrderItem> listOrderItem) {
		this.listOrderItem = listOrderItem;
	}
	
}
