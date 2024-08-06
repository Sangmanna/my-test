package com.freightcom.clickship.model.v2.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.v2.invoice.SearchInvoiceResponse.Data_.Page;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OriginalInvoiceResponse {

	 private Page page;

	public Page getPage() {
		return page;
	}

	public OriginalInvoiceResponse setPage(Page page) {
		this.page = page;
		return this;
	}
	 
}
