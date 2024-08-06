package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.MarketplaceRTRStatus;

@Repository
public interface MarketplaceRTRStatusRepoistory extends JpaRepository<MarketplaceRTRStatus, String> {
	
	public List<MarketplaceRTRStatus> findByTypeAndIntegrationStatusIsTrueAndRtrActivatedInCsIsTrue(String type);
	
}
