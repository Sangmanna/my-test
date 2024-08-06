package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerHistory;

@Repository
public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory, String> {
	
	public List<CustomerHistory> findByCustomer(Customer customer);
	
}