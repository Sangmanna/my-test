package com.freightcom.clickship.service.dao;

import java.util.List;

import com.freightcom.clickship.model.admin.dashboard.stores.MarketplaceTableDTO;
import com.freightcom.clickship.model.admin.dashboard.stores.StoreCountsByWeekOrMonth;

public interface MarketplaceDao {
	
	public void deleteMarketplace(String marketplaceId);

	public List<MarketplaceTableDTO> getMarketplaceTables(String from, String to,  String agentName);

	public List<StoreCountsByWeekOrMonth> getStoresIntegratedInDay(String from, String to, String agentName);
	
	public List<StoreCountsByWeekOrMonth> getStoresIntegratedInSixMonths(String from, String to, String agentName);
	
	public List<StoreCountsByWeekOrMonth> getStoresIntegratedInWeekOrMonth(String from, String to, String agentName);

	public List<List<String>> getCountsByMarketplaceType(String fromDate, String toDate, String agentName);

	public List<StoreCountsByWeekOrMonth> getStoresIntegratedByDateRange(String from, String to, String agentName);

}
