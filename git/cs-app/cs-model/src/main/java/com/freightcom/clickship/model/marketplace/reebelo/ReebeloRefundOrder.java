package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloRefundOrder implements Serializable {

	private static final long serialVersionUID = 639023746976329220L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("order_id")
	private Long orderId;
	
	@JsonProperty("refund_line_items")
	private List<ReebeloRefundOrderLineItem> refundLineItems;
	
	@JsonProperty("processed_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date processedDate;
	
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public ReebeloRefundOrder setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public ReebeloRefundOrder setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getNote() {
		return note;
	}

	public ReebeloRefundOrder setNote(String note) {
		this.note = note;
		return this;
	}

	public Date getProcessedDate() {
		return processedDate;
	}

	public ReebeloRefundOrder setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public ReebeloRefundOrder setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public ReebeloRefundOrder setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public List<ReebeloRefundOrderLineItem> getRefundLineItems() {
		return refundLineItems;
	}

	public ReebeloRefundOrder setRefundLineItems(List<ReebeloRefundOrderLineItem> refundLineItems) {
		this.refundLineItems = refundLineItems;
		return this;
	}
	
}
