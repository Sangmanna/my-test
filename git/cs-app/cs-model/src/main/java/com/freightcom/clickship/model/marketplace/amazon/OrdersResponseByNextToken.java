package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.orders.OrdersResultByNextToken;

@XmlRootElement(name = "ListOrdersByNextTokenResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersResponseByNextToken implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="ListOrdersByNextTokenResult")
	private OrdersResultByNextToken ordersResult;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata responseMetadata;
	
	public OrdersResponseByNextToken() {
		super();
	}
	
	public OrdersResponseByNextToken(OrdersResultByNextToken ordersResult, ResponseMetadata responseMetadata) {
		super();
		this.ordersResult = ordersResult;
		this.responseMetadata = responseMetadata;
	}

	public OrdersResultByNextToken getOrdersResult() {
		return ordersResult;
	}

	public void setOrdersResult(OrdersResultByNextToken ordersResult) {
		this.ordersResult = ordersResult;
	}

	public ResponseMetadata getResponseMetadata() {
		return responseMetadata;
	}

	public void setResponseMetadata(ResponseMetadata responseMetadata) {
		this.responseMetadata = responseMetadata;
	}
	
	
	
}
