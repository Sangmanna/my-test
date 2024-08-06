package com.freightcom.clickship.model.marketplace.amazon.orders.fulfillment;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
	
	@XmlElement(name="MessageID")
	private String messageId;
	
	@XmlElement(name="OrderFulfillment")
	private OrderFulfillment orderFulfillment;
	
	
	public Message() {
		
	}

	public String getMessageId() {
		return messageId;
	}


	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	public OrderFulfillment getOrderFulfillment() {
		return orderFulfillment;
	}


	public void setOrderFulfillment(OrderFulfillment orderFulfillment) {
		this.orderFulfillment = orderFulfillment;
	}
	

}
