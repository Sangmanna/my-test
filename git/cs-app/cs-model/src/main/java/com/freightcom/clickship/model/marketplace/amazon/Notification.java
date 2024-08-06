package com.freightcom.clickship.model.marketplace.amazon;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.freightcom.clickship.model.marketplace.amazon.feeds.notifications.NotificationMetadata;
import com.freightcom.clickship.model.marketplace.amazon.feeds.notifications.NotificationPayload;

@XmlRootElement(name = "Notification")
@XmlAccessorType(XmlAccessType.FIELD)
public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="NotificationMetaData")
	private NotificationMetadata notificationMetadata;
	
	@XmlElement(name="NotificationPayload")
	private NotificationPayload notificationPayload;
	
	public Notification() {
		
	}

	public NotificationMetadata getNotificationMetadata() {
		return notificationMetadata;
	}

	public void setNotificationMetadata(NotificationMetadata notificationMetadata) {
		this.notificationMetadata = notificationMetadata;
	}

	public NotificationPayload getNotificationPayload() {
		return notificationPayload;
	}

	public void setNotificationPayload(NotificationPayload notificationPayload) {
		this.notificationPayload = notificationPayload;
	}

}
