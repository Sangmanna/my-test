package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AutoPrint;
import com.freightcom.clickship.data.entity.Customer;

@Repository
public interface AutoPrintRepository extends JpaRepository<AutoPrint, String> {

	public AutoPrint findByUsername(String username);
	
	public AutoPrint findByCustomer(Customer customer);

}
