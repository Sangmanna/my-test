package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoOrderResponse implements Serializable {

	private static final long serialVersionUID = -5257820729224398524L;

	private List<MagentoOrder> items;
	
	@JsonProperty("total_count")
	private Integer totalCount;
	
	@JsonProperty("search_criteria")
	private MagentoSearchCriteria searchCriteria;

	public List<MagentoOrder> getItems() {
		return items;
	}

	public MagentoOrderResponse setItems(List<MagentoOrder> items) {
		this.items = items;
		return this;
	}

	public MagentoSearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	public MagentoOrderResponse setSearchCriteria(MagentoSearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
		return this;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public MagentoOrderResponse setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		return this;
	}
	
}
