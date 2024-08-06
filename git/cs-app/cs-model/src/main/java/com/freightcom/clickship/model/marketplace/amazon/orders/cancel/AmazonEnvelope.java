package com.freightcom.clickship.model.marketplace.amazon.orders.cancel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.orders.fulfillment.Header;

@XmlRootElement(name="AmazonEnvelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class AmazonEnvelope {
	
	@XmlElement(name="Header")
	private Header header; 
	
	@XmlElement(name="MessageType")
	private String messageType;
	
	@XmlElement(name="Message")
	private OrderAcknowledgementMessage message;
	
	public AmazonEnvelope() {
		
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public OrderAcknowledgementMessage getMessage() {
		return message;
	}

	public void setMessage(OrderAcknowledgementMessage message) {
		this.message = message;
	}

}
