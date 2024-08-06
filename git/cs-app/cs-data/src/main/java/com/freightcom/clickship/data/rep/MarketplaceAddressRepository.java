package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceAddress;

@Repository
public interface MarketplaceAddressRepository extends JpaRepository<MarketplaceAddress, String> {
	
	public void deleteByCustomerAddress(CustomerAddress customerAddress);
	
	public List<MarketplaceAddress> findAllByMarketplace(Marketplace marketplace);
	
	public MarketplaceAddress findByMarketplaceAndCustomerAddress(Marketplace marketplace, CustomerAddress customerAddress);
}
