package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.MarketplaceAppInstallRequest;
import com.freightcom.clickship.data.entity.MarketplaceType;

@Repository
public interface MarketplaceAppInstallRequestsRepository extends JpaRepository<MarketplaceAppInstallRequest, String> {

	public MarketplaceAppInstallRequest findByStoreId(String instanceId);
	
	public MarketplaceAppInstallRequest findByMarketplaceTypeAndStoreId(MarketplaceType type, String storeId);

}
