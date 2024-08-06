package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceType;
import com.freightcom.clickship.model.admin.dashboard.stores.MarketplaceTableDTO;
import com.freightcom.clickship.model.admin.dashboard.stores.StoreCountsByWeekOrMonth;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;

public interface MarketplaceService {

	public void save(Marketplace marketplace);
	
	public Marketplace findByStoreUrl(String url);
	
	public Marketplace findById(String marketplaceId);
	
	public Marketplace findById(Customer customer, String marketplaceId);
	
	public MarketplaceDTO disableStore(String marketplaceId);
	
	public List<Marketplace> findAllActiveMarketplaces(Customer customer);
	
	public MarketplaceDTO enableStore(Customer customer, String marketplaceId);
	
	public MarketplaceDTO disableStore(Customer customer, String marketplaceId);
	
	public void deleteStore(String marketplaceId, boolean processOnMarketplaceEnd) throws Exception;
	
	public MarketplaceDTO getMarketplaceDto(String marketplaceId);
	
	public MarketplaceDTO getMarketplaceDto(Marketplace marketplace);
	
	public void recordFailure(String marketplaceId, String...strings);
	
	public void disableMarketplaceIfNecessary(Marketplace marketplace);
	
	public void recordFailure(Marketplace marketplace, String...strings);
	
	public List<MarketplaceDTO> getMarketplacesByCustomer(Customer customer);
	
	public List<MarketplaceDTO> getActiveMarketplaces(Customer loginCustomer);
	
	public List<MarketplaceDTO> getMarketplacesByCustomerId(String customerId);
	
	public void recordFailure(String marketplaceId, Exception e, String...strings);
	
	public void recordFailure(Marketplace marketplace, Exception e, String...strings);
	
	public List<MarketplaceDTO> getActiveMarketplacesByType(List<MarketplaceType> marketplaceTypeList);
	
	// TODO lets talk with jaimin about this methods
	
	public List<String> getListOfStoreTypesAndCounts(Customer customer);
	
	public List<MarketplaceTableDTO> getMarketplaceTable(String from, String to, String agentName);
	
	public List<StoreCountsByWeekOrMonth> getStoreIntegratedInDay(String from, String to, String agentName);
	
	public List<StoreCountsByWeekOrMonth> getStoreIntegratedCountsBySixMonths(String from, String to, String agentName);

	public List<StoreCountsByWeekOrMonth> getStoreIntegratedCountsByWeekOrMonth(String from, String to, String agentName);
	
	public List<Marketplace> getMarketplacesByMarketplaceType(MarketplaceType marketplaceType);

	public List<List<String>> getIntegrationsByMarketplaces(String fromDate, String toDate, String agentName);

	public Marketplace findByMarketplaceTypeAndUsername(MarketplaceType marketplaceType, String instanceId);
	
	public Marketplace getIntegratedMarketplaceByStoreUrl(String url);

	public List<StoreCountsByWeekOrMonth> getStoreIntegratedByDateRange(String from, String to, String agentName);
	
	public List<Marketplace> findByDefaultAddressAndCustomer(CustomerAddress defaultAddress, Customer customer);
	
	public void recordFailureWithoutNotification(String marketplaceId, String failureType, String referenceId, String errorMessage);
}
