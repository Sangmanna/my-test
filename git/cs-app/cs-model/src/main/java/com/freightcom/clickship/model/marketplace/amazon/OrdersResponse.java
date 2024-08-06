package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.orders.OrdersResult;

@XmlRootElement(name = "ListOrdersResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="ListOrdersResult")
	private OrdersResult ordersResult;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata responseMetadata;
	
	public OrdersResponse() {
		super();
	}
	
	public OrdersResponse(OrdersResult ordersResult, ResponseMetadata responseMetadata) {
		super();
		this.ordersResult = ordersResult;
		this.responseMetadata = responseMetadata;
	}

	public OrdersResult getOrdersResult() {
		return ordersResult;
	}

	public void setOrdersResult(OrdersResult ordersResult) {
		this.ordersResult = ordersResult;
	}

	public ResponseMetadata getResponseMetadata() {
		return responseMetadata;
	}

	public void setResponseMetadata(ResponseMetadata responseMetadata) {
		this.responseMetadata = responseMetadata;
	}
	
	
	
}
