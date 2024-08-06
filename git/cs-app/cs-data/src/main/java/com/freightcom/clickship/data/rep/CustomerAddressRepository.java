package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.projection.customer.address.CustomerAddressProjection;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, String> {

	public List<CustomerAddress> findAllByExternalId(Long externalId);
	
	public List<CustomerAddress> findAllByCustomer(Customer customer);
	
	public CustomerAddress findByCustomerAndExternalId(Customer customer, Long externalId);

	public List<CustomerAddress> findAllByCustomerAndAddressType(Customer customer, String addressType);

	@Query(CustomerAddressProjection.PROJECTION_COLUMN_SELECT
			+ " FROM MarketplaceProduct mp, MarketplaceAddress ma, CustomerAddress ca   "
			+ " WHERE mp.id = :productId "
			+ " AND mp.marketplace = ma.marketplace "
			+ " AND ma.customerAddress = ca ")
	public List<CustomerAddressProjection> findByProductId(String productId);
	
	@Query(CustomerAddressProjection.PROJECTION_COLUMN_SELECT
			+ " FROM CustomerAddress ca   "
			+ " WHERE ca.customer = :customer ")
	public List<CustomerAddressProjection> findAllAddressProjectionsByCustomer(Customer customer);
	
//	@Query("SELECT ca"
//			+ " FROM CustomerAddress ca "
//			+ " JOIN UserLocations ul ON ca.id = ul.customerAddress.id AND ul.customer_id = :customerId AND ul.username = :username")
//	public List<Marketplace> getUserAddresses(String customerId, String username);
	
}