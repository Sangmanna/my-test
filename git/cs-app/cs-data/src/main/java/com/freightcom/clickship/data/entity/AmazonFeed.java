package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "amazon_feed")
public class AmazonFeed extends BaseEntity {
	
	private static final long serialVersionUID = 6666769753014415452L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "feed_submission_id")
	private String feedSubmissionId;
	
	@Column(name = "feed_type")
	private String feedType;
	
	@Column(name = "submitted_date")
	private String submittedDate;
	
	@Column(name = "feed_processing_status")
	private String feedProcessingStatus;
	
	@Column(name = "request_id")
	private String requestId;
	
	@Column(name = "response_verified")
	private boolean responseVerified;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, updatable = false)
	@JsonIgnore
	private Order order;
	
	public AmazonFeed() {
		super();
	}

	public String getId() {
		return id;
	}

	public AmazonFeed setId(String id) {
		this.id = id;
		return this;
	}

	public String getFeedSubmissionId() {
		return feedSubmissionId;
	}

	public AmazonFeed setFeedSubmissionId(String feedSubmissionId) {
		this.feedSubmissionId = feedSubmissionId;
		return this;
	}

	public String getFeedType() {
		return feedType;
	}

	public AmazonFeed setFeedType(String feedType) {
		this.feedType = feedType;
		return this;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public AmazonFeed setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
		return this;
	}

	public String getFeedProcessingStatus() {
		return feedProcessingStatus;
	}

	public AmazonFeed setFeedProcessingStatus(String feedProcessingStatus) {
		this.feedProcessingStatus = feedProcessingStatus;
		return this;
	}

	public String getRequestId() {
		return requestId;
	}

	public AmazonFeed setRequestId(String requestId) {
		this.requestId = requestId;
		return this;
	}

	public boolean isResponseVerified() {
		return responseVerified;
	}

	public AmazonFeed setResponseVerified(boolean responseVerified) {
		this.responseVerified = responseVerified;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public AmazonFeed setOrder(Order order) {
		this.order = order;
		return this;
	}

}
