package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.ShippingRuleRefresh;

@Repository
public interface ShippingRuleRefreshRepository extends JpaRepository<ShippingRuleRefresh, String> {
	
	public List<ShippingRuleRefresh> findByCustomer(Customer customer);
	
}
