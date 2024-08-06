package com.freightcom.clickship.model.marketplace.wix.ecom;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomOrderTransactions {

	@JsonProperty("orderId")
	private String orderId;

	@JsonProperty("payments")
	private List<WixEcomPayments> payments;

	@JsonProperty("refunds")
	private List<WixEcomRefunds> refunds;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<WixEcomPayments> getPayments() {
		return payments;
	}

	public void setPayments(List<WixEcomPayments> payments) {
		this.payments = payments;
	}

	public List<WixEcomRefunds> getRefunds() {
		return refunds;
	}

	public void setRefunds(List<WixEcomRefunds> refunds) {
		this.refunds = refunds;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomPayments {

		@JsonProperty("id")
		private String id;

		@JsonProperty("amount")
		private WixEcomAmount amount;

		@JsonProperty("regularPaymentDetails")
		private WixRegularPaymentDetails regularPaymentDetails;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public WixEcomAmount getAmount() {
			return amount;
		}

		public void setAmount(WixEcomAmount amount) {
			this.amount = amount;
		}

		public WixRegularPaymentDetails getRegularPaymentDetails() {
			return regularPaymentDetails;
		}

		public void setRegularPaymentDetails(WixRegularPaymentDetails regularPaymentDetails) {
			this.regularPaymentDetails = regularPaymentDetails;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomRefunds {

		@JsonProperty("id")
		private String id;

		@JsonProperty("transactions")
		private List<WixEcomTransactions> transactions;

		@JsonProperty("details")
		private WixEcomRefundDetails details;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public List<WixEcomTransactions> getTransactions() {
			return transactions;
		}

		public void setTransactions(List<WixEcomTransactions> transactions) {
			this.transactions = transactions;
		}

		public WixEcomRefundDetails getDetails() {
			return details;
		}

		public void setDetails(WixEcomRefundDetails details) {
			this.details = details;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixRegularPaymentDetails {

		@JsonProperty("status")
		private String status;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomTransactions {

		@JsonProperty("amount")
		private WixEcomAmount amount;

		@JsonProperty("refundStatus")
		private String refundStatus;

		public WixEcomAmount getAmount() {
			return amount;
		}

		public void setAmount(WixEcomAmount amount) {
			this.amount = amount;
		}

		public String getRefundStatus() {
			return refundStatus;
		}

		public void setRefundStatus(String refundStatus) {
			this.refundStatus = refundStatus;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomRefundDetails {

		@JsonProperty("items")
		private List<WixEcomLineItems> items;

		public List<WixEcomLineItems> getItems() {
			return items;
		}

		public void setItems(List<WixEcomLineItems> items) {
			this.items = items;
		}
	}
}
