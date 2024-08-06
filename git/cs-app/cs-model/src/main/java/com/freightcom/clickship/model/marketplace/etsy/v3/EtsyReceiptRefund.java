package com.freightcom.clickship.model.marketplace.etsy.v3;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyReceiptRefund implements Serializable {

	private static final long serialVersionUID = -3045906893179269311L;

	@JsonProperty("reason")
	private String reason;

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("amount")
	private EtsyPrice amount;
	
	@JsonProperty("created_timestamp")
	private Long createdTimestamp;

	@JsonProperty("note_from_issuer")
	private String noteFromIssuer;

	public String getReason() {
		return reason;
	}

	public EtsyReceiptRefund setReason(String reason) {
		this.reason = reason;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public EtsyReceiptRefund setStatus(String status) {
		this.status = status;
		return this;
	}

	public EtsyPrice getAmount() {
		return amount;
	}

	public EtsyReceiptRefund setAmount(EtsyPrice amount) {
		this.amount = amount;
		return this;
	}

	public Long getCreatedTimestamp() {
		return createdTimestamp;
	}

	public EtsyReceiptRefund setCreatedTimestamp(Long createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
		return this;
	}

	public String getNoteFromIssuer() {
		return noteFromIssuer;
	}

	public EtsyReceiptRefund setNoteFromIssuer(String noteFromIssuer) {
		this.noteFromIssuer = noteFromIssuer;
		return this;
	}

}
