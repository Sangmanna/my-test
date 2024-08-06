package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.order.GetOrderResult;
import com.freightcom.clickship.model.marketplace.amazon.orders.ResponseMetadata;

@XmlRootElement(name = "GetOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOrderResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="GetOrderResult")
	private GetOrderResult getOrderResult;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata responseMetadata;
	
	public GetOrderResponse() {
		super();
	}

	public GetOrderResult getGetOrderResult() {
		return getOrderResult;
	}

	public void setGetOrderResult(GetOrderResult getOrderResult) {
		this.getOrderResult = getOrderResult;
	}

	public ResponseMetadata getResponseMetadata() {
		return responseMetadata;
	}

	public void setResponseMetadata(ResponseMetadata responseMetadata) {
		this.responseMetadata = responseMetadata;
	}

}
