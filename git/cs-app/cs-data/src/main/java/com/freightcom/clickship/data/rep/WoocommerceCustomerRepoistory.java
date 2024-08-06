package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.WooCommerceCustomer;

@Repository
public interface WoocommerceCustomerRepoistory extends JpaRepository<WooCommerceCustomer, String> {
	
	public List<WooCommerceCustomer> findByIntegrationStatusIsTrueAndWebhooksStatusIsFalse();
	
}
