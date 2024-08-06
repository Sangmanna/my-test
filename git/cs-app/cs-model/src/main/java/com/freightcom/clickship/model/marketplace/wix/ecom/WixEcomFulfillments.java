package com.freightcom.clickship.model.marketplace.wix.ecom;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomFulfillments {

	@JsonProperty("orderId")
	private String orderId;

	@JsonProperty("fulfillment")
	private WixEcomFulfillment fulfillment;

	@JsonProperty("fulfillments")
	private List<WixEcomFulfillment> fulfillments;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public WixEcomFulfillment getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(WixEcomFulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

	public List<WixEcomFulfillment> getFulfillments() {
		return fulfillments;
	}

	public void setFulfillments(List<WixEcomFulfillment> fulfillments) {
		this.fulfillments = fulfillments;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomFulfillment {

		@JsonProperty("lineItems")
		private List<WixEcomLineItems> lineItems;

		@JsonProperty("status")
		private String status;

		@JsonProperty("completed")
		private Boolean completed;

		@JsonProperty("trackingInfo")
		private WixEcomTrackingInfo trackingInfo;

		public List<WixEcomLineItems> getLineItems() {
			return lineItems;
		}

		public void setLineItems(List<WixEcomLineItems> lineItems) {
			this.lineItems = lineItems;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Boolean getCompleted() {
			return completed;
		}

		public void setCompleted(Boolean completed) {
			this.completed = completed;
		}

		public WixEcomTrackingInfo getTrackingInfo() {
			return trackingInfo;
		}

		public void setTrackingInfo(WixEcomTrackingInfo trackingInfo) {
			this.trackingInfo = trackingInfo;
		}
	}
}
