package com.freightcom.clickship.model.marketplace.amazon.feeds.notifications;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FeedProcessingFinishedNotification")
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedProcessingFinishedNotification implements Serializable {
	
	private static final long serialVersionUID = 3475492589419632357L;

	@XmlElement(name="SellerId")
	private String sellerId;
	@XmlElement(name="FeedSubmissionId")
	private String feedSubmissionId;
	@XmlElement(name="FeedType")
	private String feedType;
	@XmlElement(name="FeedProcessingStatus")
	private String feedProcessingStatus;
	
	public FeedProcessingFinishedNotification() {
			
	}
	
	
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getFeedSubmissionId() {
		return feedSubmissionId;
	}

	public void setFeedSubmissionId(String feedSubmissionId) {
		this.feedSubmissionId = feedSubmissionId;
	}

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	public String getFeedProcessingStatus() {
		return feedProcessingStatus;
	}

	public void setFeedProcessingStatus(String feedProcessingStatus) {
		this.feedProcessingStatus = feedProcessingStatus;
	}

	
}
