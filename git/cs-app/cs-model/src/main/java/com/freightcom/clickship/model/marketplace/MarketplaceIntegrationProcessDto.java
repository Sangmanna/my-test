package com.freightcom.clickship.model.marketplace;

import java.io.Serializable;

public class MarketplaceIntegrationProcessDto implements Serializable {
	
	private static final long serialVersionUID = 8791543186824969680L;

	private long stage;
	
	private String processUpdate;
	
	private String marketplaceId;
	
	private MarketplaceDTO marketplace;

	public long getStage() {
		return stage;
	}

	public MarketplaceIntegrationProcessDto setStage(long stage) {
		this.stage = stage;
		return this;
	}
	
	public String getMarketplaceId() {
		return marketplaceId;
	}
	
	public MarketplaceIntegrationProcessDto setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	public MarketplaceDTO getMarketplace() {
		return marketplace;
	}

	public MarketplaceIntegrationProcessDto setMarketplace(MarketplaceDTO marketplace) {
		this.marketplace = marketplace;
		this.marketplaceId  = marketplace.getId();
		return this;
	}

	public String getProcessUpdate() {
		return processUpdate;
	}

	public MarketplaceIntegrationProcessDto setProcessUpdate(String processUpdate) {
		this.processUpdate = processUpdate;
		return this;
	}

}
