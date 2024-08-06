package com.freightcom.clickship.model.v2.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.Money;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payments {

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("document_id")
	private String documentId;

	@JsonProperty("customer_id")
	private String customerId;

	@JsonProperty("shipment_id")
	private String shipmentId;

	@JsonProperty("amount")
	private Money amount;

	@JsonProperty("when")
	private String when;

	@JsonProperty("comment")
	private String comment;

}
