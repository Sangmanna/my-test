package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.ShippingPreferences;

@Repository
public interface ShippingPreferencesRepository extends JpaRepository<ShippingPreferences, String> {

	public ShippingPreferences getShippingPreferencesByCustomer(Customer customer);

	@Query("SELECT cp.thermalLabels FROM ShippingPreferences cp WHERE cp.customer.id = :customerId")
	public boolean findThermalLabelsByCustomerId(String customerId);
}
