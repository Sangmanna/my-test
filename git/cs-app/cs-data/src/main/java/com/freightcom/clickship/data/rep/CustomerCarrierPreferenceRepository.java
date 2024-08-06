package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerCarrierPreference;
import com.freightcom.clickship.data.entity.projection.rtr.RTRV2ServiceIdProjection;

@Repository
public interface CustomerCarrierPreferenceRepository extends JpaRepository<CustomerCarrierPreference, String> {
	
	public void deleteByCustomerIdAndV2ServiceIdStartingWith(String customerId, String carrierIdPrefix);
	
	public List<CustomerCarrierPreference> findAllByCustomer(Customer customer);
	
	public List<CustomerCarrierPreference> findByCustomerAndStatusIsTrue(Customer customer);
	
	public List<CustomerCarrierPreference> findByCustomerAndStatusIsTrueAndPalletCarrierIsTrue(Customer customer);

	public List<CustomerCarrierPreference> findByCustomerAndShortName(Customer customer, String shortName);
	
	public List<RTRV2ServiceIdProjection> getByCustomerAndStatusIsTrue(Customer customer);
	
	public List<CustomerCarrierPreference> findByCustomerAndStatusIsTrueAndPalletCarrierIsFalse(Customer customer);

	public List<CustomerCarrierPreference> findByCustomerAndServiceIdAndStatusIsTrue(Customer customer, String serviceId);
	
	public List<CustomerCarrierPreference> findByCustomerAndServiceGroupId(Customer customer, String serviceGroupId);
	
	public List<CustomerCarrierPreference> findByCustomerAndShortNameAndStatusIsTrue(Customer customer, String carrierName);
	
	public List<CustomerCarrierPreference> findByCustomerAndCarrierAccountNumber(Customer customer, String carrierAccountNumber);
	
	public List<CustomerCarrierPreference> deleteByCustomerAndCarrierAccountNumber(Customer customer, String carrierAccountNumber);
	
	public List<CustomerCarrierPreference> findByCustomerAndServiceGroupIdAndStatusIsTrue(Customer customer, String serviceGroupId);
	
	public CustomerCarrierPreference findByCustomerAndServiceGroupIdAndServiceIdAndStatusIsTrue(Customer customer, String serviceGroupId, String serviceId);
	
	public CustomerCarrierPreference findByCustomerIdAndServiceGroupIdAndServiceIdAndStatusIsTrue(String customerId, String serviceGroupId, String serviceId);

	public CustomerCarrierPreference findByCustomerAndServiceIdAndServiceGroupIdAndCarrierAccountNumber(Customer customer, String serviceId, String serviceGroupId, String carrierAccountNumber);

	@Query("SELECT c from CustomerCarrierPreference c WHERE c.customer.id=:customerId"
			+ " AND c.service=:service AND c.status is true AND (c.serviceId=:serviceId OR c.v2ServiceId=:serviceId) ")
	public CustomerCarrierPreference findByCustomerAndServiceAndServiceId(@Param("customerId") String customerId, @Param("service") String service, @Param("serviceId") String serviceId);

	public List<RTRV2ServiceIdProjection> getByCustomerAndStatusIsTrueAndV2ServiceIdIsNotNull(Customer customer);
	
	public List<CustomerCarrierPreference> findByCustomerIdAndV2ServiceIdStartingWith(String customerId, String carrierIdPrefix);
	
	public boolean existsAnyByCustomerAndShortName(Customer customer, String shortName);
	
	@Query("SELECT DISTINCT c.shortName FROM CustomerCarrierPreference c WHERE c.customer = :customer")
	public List<String> findDistinctShortNameByCustomer(Customer customer);
}
