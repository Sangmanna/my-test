package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethodGetDocumentIdResponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("number")
	private String number;

	@JsonProperty("date")
	private Date date;

	@JsonProperty("due-date")
	private Date dueDate;

	@JsonProperty("amount")
	private CostDTO amount;

	@JsonProperty("owing")
	private CostDTO owing;

	@JsonProperty("payments")
	private List<Payments> payments;

	@JsonProperty("line_Items")
	private List<LineItems> lineItems;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Payments {

		@JsonProperty("id")
		private String id;

		@JsonProperty("type")
		private String type;

		@JsonProperty("amount")
		private CostDTO amount;

		@JsonProperty("data")
		private Data data;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public CostDTO getAmount() {
			return amount;
		}

		public void setAmount(CostDTO amount) {
			this.amount = amount;
		}

		public Data getData() {
			return data;
		}

		public void setData(Data data) {
			this.data = data;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Data {

		@JsonProperty("credit_card_auth")
		private String creditCardAuth;

		@JsonProperty("credit_card_number")
		private String creditCardNumber;

		@JsonProperty("credit_card_reference")
		private String creditCardReference;

		public String getCreditCardAuth() {
			return creditCardAuth;
		}

		public void setCreditCardAuth(String creditCardAuth) {
			this.creditCardAuth = creditCardAuth;
		}

		public String getCreditCardNumber() {
			return creditCardNumber;
		}

		public void setCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
		}

		public String getCreditCardReference() {
			return creditCardReference;
		}

		public void setCreditCardReference(String creditCardReference) {
			this.creditCardReference = creditCardReference;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class LineItems {

		@JsonProperty("id")
		private String id;

		@JsonProperty("type")
		private String type;

		@JsonProperty("sub_type")
		private String subType;

		@JsonProperty("payment_id")
		private String paymentId;

		@JsonProperty("amount")
		private CostDTO amount;

		@JsonProperty("message")
		private String message;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getSubType() {
			return subType;
		}

		public void setSubType(String subType) {
			this.subType = subType;
		}

		public String getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(String paymentId) {
			this.paymentId = paymentId;
		}

		public CostDTO getAmount() {
			return amount;
		}

		public void setAmount(CostDTO amount) {
			this.amount = amount;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public CostDTO getAmount() {
		return amount;
	}

	public void setAmount(CostDTO amount) {
		this.amount = amount;
	}

	public CostDTO getOwing() {
		return owing;
	}

	public void setOwing(CostDTO owing) {
		this.owing = owing;
	}

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	public List<LineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItems> lineItems) {
		this.lineItems = lineItems;
	}

}
