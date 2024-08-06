package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceWebhooks;

@Repository
public interface MarketplaceWebhooksRepository extends JpaRepository<MarketplaceWebhooks, String> {
	
	public List<MarketplaceWebhooks> findAllByMarketplace(Marketplace marketplace);
	
}