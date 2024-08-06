package com.freightcom.clickship.model.marketplace.amazon.feeds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FeedSubmissionInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedSubmissionInfo {
	
	
	@XmlElement(name="FeedSubmissionId")
	private String feedSubmissionId;
	@XmlElement(name="FeedType")
	private String feedType;
	@XmlElement(name="SubmittedDate")
	private String submittedDate;
	@XmlElement(name="FeedProcessingStatus")
	private String feedProcessingStatus;
	
	public FeedSubmissionInfo() {
		
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

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getFeedProcessingStatus() {
		return feedProcessingStatus;
	}

	public void setFeedProcessingStatus(String feedProcessingStatus) {
		this.feedProcessingStatus = feedProcessingStatus;
	}

}
