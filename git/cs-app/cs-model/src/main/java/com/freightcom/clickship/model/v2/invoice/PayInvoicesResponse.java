package com.freightcom.clickship.model.v2.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.carrier.freightcom.v2.FCMoney;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayInvoicesResponse {

	@JsonProperty("total_paid")
	private FCMoney totalPaid;

	@JsonProperty("invoices_updated")
	private List<InvoiceData> invoicesUpdated;

	@JsonProperty("document_id")
	private String documentId;

	@JsonProperty("error")
	private String error;

	@JsonProperty("currency")
	private String currency;
}
