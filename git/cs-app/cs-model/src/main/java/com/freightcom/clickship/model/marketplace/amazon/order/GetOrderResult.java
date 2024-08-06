package com.freightcom.clickship.model.marketplace.amazon.order;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetOrderResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOrderResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Orders")
	private Orders orders;
	
	public GetOrderResult() {
		super();
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
