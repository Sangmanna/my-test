package com.freightcom.clickship.model.marketplace.amazon.orders;


import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListOrdersByNextTokenResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersResultByNextToken implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Orders")
	private Orders orders;
	
	@XmlElement(name="NextToken")
	private String nextToken;
	
	@XmlElement(name = "CreatedBefore")
	private String createdBefore;
	
	public OrdersResultByNextToken() {
		super();
	}
	
	public OrdersResultByNextToken(Orders orders) {
		super();
		this.orders = orders;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getNextToken() {
		return nextToken;
	}

	public void setNextToken(String nextToken) {
		this.nextToken = nextToken;
	}

	public String getCreatedBefore() {
		return createdBefore;
	}

	public void setCreatedBefore(String createdBefore) {
		this.createdBefore = createdBefore;
	}
	
}
