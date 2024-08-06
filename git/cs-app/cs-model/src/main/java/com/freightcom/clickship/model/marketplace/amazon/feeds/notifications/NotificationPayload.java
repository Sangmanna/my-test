package com.freightcom.clickship.model.marketplace.amazon.feeds.notifications;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NotificationPayload")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationPayload implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="FeedProcessingFinishedNotification")
	private FeedProcessingFinishedNotification feedProcessingFinishedNotification;
	
	@XmlElement(name="ReportProcessingFinishedNotification")
	private ReportProcessingFinishedNotification reportProcessingFinishedNotification;
	
	public NotificationPayload() {
		
	}

	public FeedProcessingFinishedNotification getFeedProcessingFinishedNotification() {
		return feedProcessingFinishedNotification;
	}

	public void setFeedProcessingFinishedNotification(
			FeedProcessingFinishedNotification feedProcessingFinishedNotification) {
		this.feedProcessingFinishedNotification = feedProcessingFinishedNotification;
	}

	public ReportProcessingFinishedNotification getReportProcessingFinishedNotification() {
		return reportProcessingFinishedNotification;
	}

	public void setReportProcessingFinishedNotification(
			ReportProcessingFinishedNotification reportProcessingFinishedNotification) {
		this.reportProcessingFinishedNotification = reportProcessingFinishedNotification;
	}

}
