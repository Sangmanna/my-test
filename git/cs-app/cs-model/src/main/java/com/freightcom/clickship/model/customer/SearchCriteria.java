package com.freightcom.clickship.model.customer;

public class SearchCriteria {

	private String key;
	
	private String value;
	
	private Integer limit;
	
	private Integer offset;
	
	private String operator;
	
	private String marketplaceId;

	private String perkName;

	public String getKey() {
		return key;
	}

	public SearchCriteria setKey(String key) {
		this.key = key;
		return this;
	}

	public String getOperator() {
		return operator;
	}

	public SearchCriteria setOperator(String operator) {
		this.operator = operator;
		return this;
	}

	public String getValue() {
		return value;
	}

	public SearchCriteria setValue(String value) {
		this.value = value;
		return this;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public SearchCriteria setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	public Integer getLimit() {
		return limit;
	}

	public SearchCriteria setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public Integer getOffset() {
		return offset;
	}

	public SearchCriteria setOffset(Integer offset) {
		this.offset = offset;
		return this;
	}

	public String getPerkName() {
		return perkName;
	}

	public SearchCriteria setPerkName(String perkName) {
		this.perkName = perkName;
		return this;
	}
}
