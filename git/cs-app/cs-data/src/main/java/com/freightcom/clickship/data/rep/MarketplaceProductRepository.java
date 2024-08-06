package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;

@Repository
public interface MarketplaceProductRepository extends JpaRepository<MarketplaceProduct, String> {
	
	public List<MarketplaceProduct> findByCustomer(Customer customer);
	
	public List<MarketplaceProduct> findAllByMarketplace(Marketplace marketplace);
	
	public MarketplaceProduct findByMarketplaceAndSku(Marketplace marketplace, String sku);
	
	public MarketplaceProduct findByMarketplaceAndUpc(Marketplace marketplace, String asin);
	
	public List<MarketplaceProduct> findTop10ByCustomerAndImageUrlIsNotNull(Customer customer);
	
	public List<MarketplaceProduct> findAllByMarketplaceAndExternalProductId(Marketplace marketplace, Long externalProductId);
	
	public List<MarketplaceProduct> findAllByMarketplaceAndExternalProductIdStr(Marketplace marketplace, String externalProductId);
	
	public MarketplaceProduct findByMarketplaceAndExternalProductIdAndVariantId(Marketplace marketplace, Long externalProductId, String variantId);

	public MarketplaceProduct findByMarketplaceAndExternalProductIdStrAndVariantId(Marketplace marketplace, String externalProductId, String variantId);

	public MarketplaceProduct findByMarketplaceAndVariantId(Marketplace marketplace, String externalProductId);
	
}