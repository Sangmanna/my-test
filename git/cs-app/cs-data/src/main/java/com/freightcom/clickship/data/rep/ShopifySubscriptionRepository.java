package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.ShopifySubscription;

@Repository
public interface ShopifySubscriptionRepository extends JpaRepository<ShopifySubscription, String> {
	
	public List<ShopifySubscription> findByCustomerAndAddonTypeAndStatus(Customer customer, String addonType, String status);
	
	public List<ShopifySubscription> findByMarketplaceAndAddonTypeAndStatus(Marketplace marketplace, String addonType, String status);
	
	public List<ShopifySubscription> findByMarketplaceAndShopifySubscriptionId(Marketplace marketplace, String shopifySubscriptionId);
	
	public ShopifySubscription findByCustomerAndAddonTypeAndAddonIdAndStatus(Customer customer, String addonType, String addonId, String status);
	
	public ShopifySubscription findByCustomerAndAddonTypeAndAddonNameAndStatus(Customer customer, String addonType, String addonName, String status);
	
	public ShopifySubscription findByMarketplaceAndAddonTypeAndAddonIdAndStatus(Marketplace marketplace, String addonType, String addonId, String status);
	
	public ShopifySubscription findByMarketplaceAndAddonTypeAndShopifySubscriptionId(Marketplace marketplace, String addonType, String shopifySubscriptionId);
	
	public List<ShopifySubscription> findByCustomerAndAddonTypeAndAddonIdInAndStatus(Customer customer, String addonType, List<String> addonIds, String status);
	
}