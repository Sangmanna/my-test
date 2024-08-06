package com.freightcom.clickship.model.marketplace.amazon;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.orders.fulfillment.Header;
import com.freightcom.clickship.model.marketplace.amazon.orders.fulfillment.Message;

@XmlRootElement(name="AmazonEnvelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class AmazonEnvelope {
	
	@XmlElement(name="Header")
	private Header header; 
	
	@XmlElement(name="MessageType")
	private String messageType;
	
	@XmlElement(name="Message")
	private Message message;
	
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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
