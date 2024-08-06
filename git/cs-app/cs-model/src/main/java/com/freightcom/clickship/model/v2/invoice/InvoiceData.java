package com.freightcom.clickship.model.v2.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.Date;
import com.freightcom.clickship.model.v2.Money;
import com.freightcom.clickship.model.v2.PaymentData;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceData {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("type")
	private String type; 
	
	@JsonProperty("generate_request_id")
	private String requestId;
	
	@JsonProperty("number")
	private String number;
	
	@JsonProperty("customer_id")
	private String customerId;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("due_state")
	private String status;
	
	@JsonProperty("due_date")
	private String dueDate;

	@JsonProperty("urgent_date")
	private String urgentDate;

	@JsonProperty("paid_date")
	private String paidDate;
	
	@JsonProperty("date_in_invoicing_location")
	private Date dateInInvoicingLocation;
	
	@JsonProperty("cancelled")
	private Boolean cancelled;
	
	@JsonProperty("amount")
	private Money amount;
	
	@JsonProperty("owing")
	private Money owing;
	
	@JsonProperty("credits")
	private Money credits;

	@JsonProperty("packaging_types")
	private List<String> packagingTypes;
	
	@JsonProperty("service_ids")
	private Services services;

	@JsonProperty("payment_data")
	private PaymentData paymentData;

}
