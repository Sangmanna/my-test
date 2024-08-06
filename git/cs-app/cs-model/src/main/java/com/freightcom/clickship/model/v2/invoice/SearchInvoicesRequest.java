package com.freightcom.clickship.model.v2.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.claim.SearchClaimRequest.Pagination;
import com.freightcom.clickship.model.v2.claim.SearchClaimRequest.SortOrder;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchInvoicesRequest {

	@JsonProperty("criteria")
	private InvoiceSearchCriteria criteria;
	
	@JsonProperty("sort_orders")
    private List<SortOrder> sortOrder;
	
	@JsonProperty("pagination")
    private Pagination pagination;

	public InvoiceSearchCriteria getCriteria() {
		return criteria;
	}

	public SearchInvoicesRequest setCriteria(InvoiceSearchCriteria criteria) {
		this.criteria = criteria;
		return this;
	}

	public List<SortOrder> getSortOrder() {
		return sortOrder;
	}

	public SearchInvoicesRequest setSortOrder(List<SortOrder> sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public SearchInvoicesRequest setPagination(Pagination pagination) {
		this.pagination = pagination;
		return this;
	}
	
}
