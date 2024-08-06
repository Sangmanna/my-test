package com.freightcom.clickship.model.carrier.freightcom.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingTypeChangeRequest {
	@JsonProperty("CustomerID")
	private String customerId;

	@JsonProperty("OldBillingType")
	private String oldBillingType;

	@JsonProperty("NewBillingType")
	private String newBillingType;

	@JsonProperty("OldPaymentID")
	private String oldPaymentId;

	@JsonProperty("NewPaymentID")
	private String newPaymentId;

	@JsonProperty("Label")
	private String label;

	@JsonProperty("UpdatedTime")
	private String updatedTime;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOldBillingType() {
		return oldBillingType;
	}

	public void setOldBillingType(String oldBillingType) {
		this.oldBillingType = oldBillingType;
	}

	public String getNewBillingType() {
		return newBillingType;
	}

	public void setNewBillingType(String newBillingType) {
		this.newBillingType = newBillingType;
	}

	public String getOldPaymentId() {
		return oldPaymentId;
	}

	public void setOldPaymentId(String oldPaymentId) {
		this.oldPaymentId = oldPaymentId;
	}

	public String getNewPaymentId() {
		return newPaymentId;
	}

	public void setNewPaymentId(String newPaymentId) {
		this.newPaymentId = newPaymentId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
}