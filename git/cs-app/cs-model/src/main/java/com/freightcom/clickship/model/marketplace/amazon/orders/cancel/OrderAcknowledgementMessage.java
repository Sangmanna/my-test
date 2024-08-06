package com.freightcom.clickship.model.marketplace.amazon.orders.cancel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Message")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderAcknowledgementMessage {
	
	@XmlElement(name="MessageID")
	private String messageId;
	
	@XmlElement(name="OrderAcknowledgement")
	private OrderAcknowledgement orderAcknowledgement;
	
	public OrderAcknowledgementMessage() {
		
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public OrderAcknowledgement getOrderAcknowledgement() {
		return orderAcknowledgement;
	}

	public void setOrderAcknowledgement(OrderAcknowledgement orderAcknowledgement) {
		this.orderAcknowledgement = orderAcknowledgement;
	}
	
	
	
	

}
