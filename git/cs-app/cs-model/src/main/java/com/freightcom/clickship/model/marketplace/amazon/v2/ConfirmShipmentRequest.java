package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfirmShipmentRequest {
	private String marketplaceId;
    private PackageDetail packageDetail;
    
	public String getMarketplaceId() {
		return marketplaceId;
	}
	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	public PackageDetail getPackageDetail() {
		return packageDetail;
	}
	public void setPackageDetail(PackageDetail packageDetail) {
		this.packageDetail = packageDetail;
	}   
}
