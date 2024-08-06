package com.freightcom.clickship.model.marketplace.amazon.orders;


import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.AmazonOrder;

@XmlRootElement(name = "Orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "Order")
	private List<AmazonOrder> listOrders;
	
	public Orders() {
		super();
	}
	
	public Orders(List<AmazonOrder> listOrders) {
		super();
		this.listOrders = listOrders;
	}

	public List<AmazonOrder> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<AmazonOrder> listOrders) {
		this.listOrders = listOrders;
	}
}
