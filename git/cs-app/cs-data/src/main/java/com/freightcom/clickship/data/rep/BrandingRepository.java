package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Branding;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;

@Repository
public interface BrandingRepository extends JpaRepository<Branding, String> {
	
	public void deleteByCustomer(Customer customer);
	
	public List<Branding> findByCustomer(Customer customer);
	
	public Branding findByMarketplace(Marketplace marketplace);
	
	public Branding findByCustomerAndMarketplaceIsNull(Customer customer);
}
