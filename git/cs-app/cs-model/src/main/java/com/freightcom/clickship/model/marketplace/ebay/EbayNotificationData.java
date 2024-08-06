package com.freightcom.clickship.model.marketplace.ebay;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EbayNotificationData implements Serializable {

	private static final long serialVersionUID = 2870529010144272957L;
	
	private String notificationId;
	
	private long publishAttemptCount;

	@JsonProperty("eventDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date eventDate;
	
	@JsonProperty("publishDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date publishDate;
	
	private EbayNotification data;

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public long getPublishAttemptCount() {
		return publishAttemptCount;
	}

	public void setPublishAttemptCount(long publishAttemptCount) {
		this.publishAttemptCount = publishAttemptCount;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public EbayNotification getData() {
		return data;
	}

	public void setData(EbayNotification data) {
		this.data = data;
	}
	
}

