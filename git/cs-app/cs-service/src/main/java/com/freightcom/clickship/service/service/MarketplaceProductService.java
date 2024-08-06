package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;

public interface MarketplaceProductService {
	
	public void delete(MarketplaceProduct obj);
	
	public void deleteAll(List<MarketplaceProduct> deleteList);
	
	public void restoreProductById(String marketplaceProductId);
	
	public MarketplaceProduct save(MarketplaceProduct marketplaceProduct);

	public String getDeletedNonVariantProductIdByExternalProductId(String marketplaceId, String externalProductId);
	
	public MarketplaceProduct getActiveNonVariantProductByExternalProductId(String marketplaceId, String externalProductId);
	
	public MarketplaceProduct getActiveNonVariantProductByExternalProductIdStr(String marketplaceId, String externalProductId);
	
	public List<MarketplaceProduct> getAllProductsByMarketpalceAndExternalProductId(Marketplace marketplace, Long externalProductId);
	
	public List<MarketplaceProduct> getAllProductsByMarketplaceAndExternalProductIdStr(Marketplace marketplace, String externalProductId);
	
	public MarketplaceProduct getActiveProductByExternalProductIdAndVariantId(String marketplaceId, String externalProductId, String variantId);

	public MarketplaceProduct getActiveProductByExternalProductIdStrAndVariantId(Marketplace marketplace, String externalProductIdStr, String variantId);
	
}
