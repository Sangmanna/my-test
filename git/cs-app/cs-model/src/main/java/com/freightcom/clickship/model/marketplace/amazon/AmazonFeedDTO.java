package com.freightcom.clickship.model.marketplace.amazon;

public class AmazonFeedDTO {

	private String requestId;

	private String feedType;

	private String submittedDate;

	private String feedSubmissionId;

	private boolean responseVerified = false;

	private String feedProcessingStatus;

	public AmazonFeedDTO() {

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

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public boolean isResponseVerified() {
		return responseVerified;
	}

	public void setResponseVerified(boolean responseVerified) {
		this.responseVerified = responseVerified;
	}
}
