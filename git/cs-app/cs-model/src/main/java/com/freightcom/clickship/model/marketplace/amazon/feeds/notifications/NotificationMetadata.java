package com.freightcom.clickship.model.marketplace.amazon.feeds.notifications;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NotificationMetaData")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationMetadata implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="NotificationType")
	private String notificationType;
	
	@XmlElement(name="PayloadVersion")
	private String payloadVersion;
	
	@XmlElement(name="UniqueId")
	private String uniqueId;
	
	@XmlElement(name="PublishTime")
	private String publishTime;
	
	@XmlElement(name="SellerId")
	private String sellerId;
	
	public NotificationMetadata() {
		
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getPayloadVersion() {
		return payloadVersion;
	}

	public void setPayloadVersion(String payloadVersion) {
		this.payloadVersion = payloadVersion;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	

}
