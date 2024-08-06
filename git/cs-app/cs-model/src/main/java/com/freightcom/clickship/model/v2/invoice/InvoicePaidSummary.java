package com.freightcom.clickship.model.v2.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoicePaidSummary {

	private Summary summary;

	public Summary getSummary() {
		return summary;
	}

	public InvoicePaidSummary setSummary(Summary summary) {
		this.summary = summary;
		return this;
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Summary {
		
		private InvoiceStatus paid;
		
		private InvoiceStatus refund;

		public InvoiceStatus getPaid() {
			return paid;
		}

		public Summary setPaid(InvoiceStatus paid) {
			this.paid = paid;
			return this;
		}

		public InvoiceStatus getRefund() {
			return refund;
		}

		public Summary setRefund(InvoiceStatus refund) {
			this.refund = refund;
			return this;
		}
	}
}
