package com.freightcom.clickship.model.marketplace.amazon.feeds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SubmitFeedResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubmitFeedResponse {
	
	@XmlElement(name="SubmitFeedResult")
	private SubmitFeedResult submitFeedResult;
	
	@XmlElement(name="ResponseMetadata")
	private ResponseMetadata ResponseMetadata;
	
	public SubmitFeedResponse() {
			
	}
	
	public SubmitFeedResult getSubmitFeedResult() {
		return submitFeedResult;
	}

	public void setSubmitFeedResult(SubmitFeedResult submitFeedResult) {
		this.submitFeedResult = submitFeedResult;
	}

	public ResponseMetadata getResponseMetadata() {
		return ResponseMetadata;
	}

	public void setResponseMetadata(ResponseMetadata responseMetadata) {
		ResponseMetadata = responseMetadata;
	}

	

}
