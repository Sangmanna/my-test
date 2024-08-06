package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.orderitems.ListOrderItemsResult;

@XmlRootElement(name = "ListOrderItemsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListOrderItemsResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="ListOrderItemsResult")
	private ListOrderItemsResult listOrderItemsResult;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata responseMetadata;
	
	public ListOrderItemsResponse() {
		super();
	}
	
	public ListOrderItemsResponse(ListOrderItemsResult listOrderItemsResult,
			ResponseMetadata responseMetadata) {
		super();
		this.listOrderItemsResult = listOrderItemsResult;
		this.responseMetadata = responseMetadata;
	}

	public ListOrderItemsResult getListOrderItemsResult() {
		return listOrderItemsResult;
	}

	public void setListOrderItemsResult(ListOrderItemsResult listOrderItemsResult) {
		this.listOrderItemsResult = listOrderItemsResult;
	}

	public ResponseMetadata getResponseMetadata() {
		return responseMetadata;
	}

	public void setResponseMetadata(ResponseMetadata responseMetadata) {
		this.responseMetadata = responseMetadata;
	}
	
	
}
