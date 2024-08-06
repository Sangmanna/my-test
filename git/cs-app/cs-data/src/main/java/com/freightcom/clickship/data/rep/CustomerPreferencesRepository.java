package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerPreferences;
import com.freightcom.clickship.data.entity.projection.customer.CustomerLanguageProjection;

@Repository
public interface CustomerPreferencesRepository extends JpaRepository<CustomerPreferences, String> {

	public CustomerPreferences getCustomerPreferencesByCustomer(Customer customer);

	@Query("SELECT cp FROM CustomerPreferences cp INNER JOIN cp.customer c ON c.id=cp.customer.id WHERE c.active IS TRUE AND cp.showBulkShipping IS TRUE AND cp.bulkShippingPreference = :bulkShippingPreference")
	public List<CustomerPreferences> getBulkShippingCustomers(@Param("bulkShippingPreference") String bulkShippingPreference);
	
	public CustomerLanguageProjection getLanguageByCustomer(Customer customer);

}