package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerNotice;

public interface CustomerNoticeRepository  extends JpaRepository<CustomerNotice, String> {
	
	public List<CustomerNotice> findByCustomer(Customer customer);
	
	public CustomerNotice findByCustomerAndName(Customer customer, String name);
	
}
