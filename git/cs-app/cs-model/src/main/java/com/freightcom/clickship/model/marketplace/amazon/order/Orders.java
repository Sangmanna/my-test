package com.freightcom.clickship.model.marketplace.amazon.order;

import java.io.Serializable;

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
	private AmazonOrder order;
	
	public Orders() {
		super();
	}
	
	public Orders(AmazonOrder order) {
		super();
		this.order = order;
	}

	public AmazonOrder getOrder() {
		return order;
	}

	public void setOrder(AmazonOrder order) {
		this.order = order;
	}

}
