package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.PrinterSetup;

@Repository
public interface PrinterSetupRepository extends JpaRepository<PrinterSetup, String> {

	public List<PrinterSetup> findByCustomer(Customer customer);

	public List<PrinterSetup> findByUsername(String username);
}
