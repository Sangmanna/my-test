package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyRefundOrder implements Serializable {

	private static final long serialVersionUID = 639023746976329220L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("order_id")
	private Long orderId;
	
	@JsonProperty("refund_line_items")
	private List<ShopifyRefundOrderLineItem> refundLineItems;
	
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

	public ShopifyRefundOrder setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public ShopifyRefundOrder setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getNote() {
		return note;
	}

	public ShopifyRefundOrder setNote(String note) {
		this.note = note;
		return this;
	}

	public Date getProcessedDate() {
		return processedDate;
	}

	public ShopifyRefundOrder setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public ShopifyRefundOrder setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public ShopifyRefundOrder setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public List<ShopifyRefundOrderLineItem> getRefundLineItems() {
		return refundLineItems;
	}

	public ShopifyRefundOrder setRefundLineItems(List<ShopifyRefundOrderLineItem> refundLineItems) {
		this.refundLineItems = refundLineItems;
		return this;
	}
	
}
