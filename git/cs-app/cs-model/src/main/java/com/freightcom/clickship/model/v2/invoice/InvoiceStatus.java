package com.freightcom.clickship.model.v2.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.v2.Date;
import com.freightcom.clickship.model.v2.Money;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceStatus {

	@JsonProperty("min_date")
	private Date minDate;

	@JsonProperty("max_date")
	private Date maxDate;

	@JsonProperty("num_invoices")
	private Integer numOfInvoices;

	@JsonProperty("totals_map")
	private TotalsMap totalsMap;

	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class TotalsMap {

		@JsonProperty("cad")
		private Money cad;
		
		@JsonProperty("usd")
		private Money usd;
	}
}
