package com.freightcom.clickship.model.v2.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceStaticSummary {

	@JsonProperty("summary")
	private Summary summary;

	public Summary getSummary() {
		return summary;
	}

	public InvoiceStaticSummary setSummary(Summary summary) {
		this.summary = summary;
		return this;
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Summary {
		
		private InvoiceStatus upcoming;
		
		private InvoiceStatus overdue;
		
		private InvoiceStatus urgent;

		public InvoiceStatus getUpcoming() {
			return upcoming;
		}

		public Summary setUpcoming(InvoiceStatus upcoming) {
			this.upcoming = upcoming;
			return this;
		}

		public InvoiceStatus getOverdue() {
			return overdue;
		}

		public Summary setOverdue(InvoiceStatus overdue) {
			this.overdue = overdue;
			return this;
		}

		public InvoiceStatus getUrgent() {
			return urgent;
		}

		public Summary setUrgent(InvoiceStatus urgent) {
			this.urgent = urgent;
			return this;
		}
	}
}
