package com.freightcom.clickship.model.marketplace;

public class MarketplaceFailureDTO {
	private String id;
	private String marketplaceId;
	private String failureType;
	private String referenceId;
	private String errorMessage;

	public String getId() {
		return id;
	}

	public MarketplaceFailureDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public MarketplaceFailureDTO setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	public String getFailureType() {
		return failureType;
	}

	public MarketplaceFailureDTO setFailureType(String failureType) {
		this.failureType = failureType;
		return this;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public MarketplaceFailureDTO setReferenceId(String referenceId) {
		this.referenceId = referenceId;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public MarketplaceFailureDTO setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

}
