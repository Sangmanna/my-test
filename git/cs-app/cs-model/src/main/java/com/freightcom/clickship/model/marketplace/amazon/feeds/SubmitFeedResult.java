package com.freightcom.clickship.model.marketplace.amazon.feeds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SubmitFeedResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubmitFeedResult {
	
	@XmlElement(name="FeedSubmissionInfo")
	private FeedSubmissionInfo feedSubmissionInfo;

	public FeedSubmissionInfo getFeedSubmissionInfo() {
		return feedSubmissionInfo;
	}

	public void setFeedSubmissionInfo(FeedSubmissionInfo feedSubmissionInfo) {
		this.feedSubmissionInfo = feedSubmissionInfo;
	}

}
