package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoSearchCriteria implements Serializable {

	private static final long serialVersionUID = -3591483640206514371L;

	@JsonProperty("page_size")
	private Integer pageSize;
	
	@JsonProperty("sort_orders")
	private Object sortOrders;
	
	@JsonProperty("current_page")
	private Integer currentPage;

	@JsonProperty("filter_groups")
	private Object filterGroups;

	public Integer getPageSize() {
		return pageSize;
	}

	public MagentoSearchCriteria setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public Object getSortOrders() {
		return sortOrders;
	}

	public MagentoSearchCriteria setSortOrders(Object sortOrders) {
		this.sortOrders = sortOrders;
		return this;
	}

	public Object getFilterGroups() {
		return filterGroups;
	}

	public MagentoSearchCriteria setFilterGroups(Object filterGroups) {
		this.filterGroups = filterGroups;
		return this;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public MagentoSearchCriteria setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		return this;
	}

}
