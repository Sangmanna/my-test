package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax, String> {
	
	public Tax findByTitleAndOrder(String title, Order order);
	
}