package com.freightcom.clickship.service.dao;

import java.util.List;

import com.freightcom.clickship.model.product.ProductUpdateDTO;

public interface MarketplaceProductDao {
	
	public void restoreProductById(String marketplaceProductId);
	
	public String checkProductIsActive(String marketplaceId, String externalProductId);
	
	public String checkProductStrIsActive(String marketplaceId, String externalProductId);
	
	public String checkProductVariantIsActive(String marketplaceId, String externalProductId, String vairantId);
	
	public String getDeletedNonVariantProductIdByExternalProductId(String marketplaceId, String externalProductId);
	
	public List<ProductUpdateDTO> getMarketplaceProducts(String customerId, String marketplaceId);
 
}
