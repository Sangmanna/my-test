package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceType;

@Repository
public interface MarketplaceRepository extends JpaRepository<Marketplace, String> {
	
	public Marketplace findByStoreUrl(String url);
	
	public List<Marketplace> findAllByCustomer(Customer customer);
	
	public Marketplace findByCustomerAndId(Customer customer, String id);

	public Marketplace findByStoreUrlAndIntegrationSuccessTrue(String url);

	public Marketplace findTopByCustomerAndIsImportingTrue(Customer customer);

	public Marketplace getByStoreUrlAndCustomer(String url, Customer customer);

	public List<Marketplace> findByCustomerAndActiveTrue(Customer loginCustomer);
	
	public List<Marketplace> findAllByMarketplaceType(MarketplaceType marketplaceType);
	
	public List<Marketplace> findByCustomerAndIntegrationSuccessTrue(Customer loginCustomer);
	
	Marketplace findByMarketplaceTypeAndUsername(MarketplaceType marketplaceType, String username);
	
	Marketplace findByMarketplaceTypeAndUsernameAndIntegrationSuccessTrue(MarketplaceType marketplaceType, String username);

	public List<Marketplace> findByCustomerAndDefaultAddress(Customer customer, CustomerAddress defaultAddress);

	public List<Marketplace> findAllByCustomerAndMarketplaceType(Customer customer, MarketplaceType marketplaceType);
	
	public List<Marketplace> getByMarketplaceTypeInAndIntegrationSuccessTrueAndActiveTrueAndPrevJobExecDateIsNotNull(List<MarketplaceType> list);
	
	@Modifying
	@Query("UPDATE Marketplace m SET m.marketplaceType =:type WHERE m.id=:id")
	public void updateMarketplaceTypeId(@Param("id") String marketpalceId, @Param("type") MarketplaceType marketpalceType);
	
	@Query("SELECT mp"
			+ " FROM Marketplace mp "
			+ " JOIN UserMarketplaces um ON mp.id = um.marketplace.id"
			+ " WHERE mp.integrationSuccess is true AND mp.isDeleted is false AND mp.customer.id = :customerId AND um.user.username=:username")
	public List<Marketplace> getUserMarketplaces(String customerId, String username);

	public Marketplace findByUsername(String shopId);

	@Query("SELECT m.id FROM MarketplaceSetting ms, Marketplace m " 
			+ "WHERE m.customer.id = :customerId " 
			+ "AND m.active = true " 
			+ "AND ms.realtimeRatesCheckout = true "
			+ "AND m = ms.marketplace")
	public List<String> findRTREnabledMarketplaceIdsByCustomerId(@Param("customerId") String customerId);
	
	public Marketplace findByToken(String token);
}
