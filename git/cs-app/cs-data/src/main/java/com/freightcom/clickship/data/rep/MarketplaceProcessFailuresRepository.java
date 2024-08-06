package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProcessFailure;

@Repository
public interface MarketplaceProcessFailuresRepository extends JpaRepository<MarketplaceProcessFailure, String> {
	
	public List<MarketplaceProcessFailure> findAllByMarketplaceOrderByCreatedDatetimeDesc(Marketplace findById);

	public List<MarketplaceProcessFailure> findAllByMarketplaceOrderByCreatedDatetimeDesc(Marketplace findById, Pageable pageable);
	
}
