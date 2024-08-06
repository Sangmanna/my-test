package com.freightcom.clickship.data.entity.projection;

public interface UserMarketplacesProjection {
	
	public static final String SELECT = "SELECT mp.id AS marketplaceId, mp.aliasName AS aliasName, um.marketplace.id AS userMarketplaceId, mp.marketplaceType.name AS marketplaceType";

	public String getAliasName();
	
	public String getMarketplaceId();
	
	public String getMarketplaceType();

	public String getUserMarketplaceId();

}
