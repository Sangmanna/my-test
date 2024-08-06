package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoProductResponse implements Serializable {

	private static final long serialVersionUID = -4841529884015464927L;
	
	List<MagentoProduct> items;
	
	@JsonProperty("total_count")
	private Integer totalCount;
	
	@JsonProperty("search_criteria")
	private MagentoSearchCriteria searchCriteria;

	public List<MagentoProduct> getItems() {
		return items;
	}

	public MagentoProductResponse setItems(List<MagentoProduct> items) {
		this.items = items;
		return this;
	}

	public MagentoSearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	public MagentoProductResponse setSearchCriteria(MagentoSearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
		return this;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public MagentoProductResponse setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		return this;
	}
	
}
