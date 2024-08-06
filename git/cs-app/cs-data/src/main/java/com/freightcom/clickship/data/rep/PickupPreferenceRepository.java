package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.PickupPreference;

@Repository
public interface PickupPreferenceRepository extends JpaRepository<PickupPreference, String> {
	
	public void deleteByCustomer(Customer customer);
	
	public List<PickupPreference> findByCustomer(Customer customer);
	
	public PickupPreference findByCustomerAndCarrierName(Customer customer, String carrierName);
	
}
