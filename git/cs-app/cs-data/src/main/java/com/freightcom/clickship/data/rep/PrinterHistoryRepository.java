package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.PrinterHistory;

@Repository
public interface PrinterHistoryRepository extends JpaRepository<PrinterHistory, String> {

	public List<PrinterHistory> findByCustomer(Customer customer);
	
	public List<PrinterHistory> findByUsername(String username);

	@Query("SELECT ph FROM PrinterHistory ph WHERE ph.customer.id = :customerId AND DATEDIFF(NOW(), ph.createdDatetime) < :days ORDER BY ph.createdDatetime desc")
	public List<PrinterHistory> findByCustomer(String customerId, int days);
	
	@Query("SELECT ph FROM PrinterHistory ph WHERE ph.username = :username AND DATEDIFF(NOW(), ph.createdDatetime) < :days ORDER BY ph.createdDatetime desc")
	public List<PrinterHistory> findByUsername(String username, int days);

	public List<PrinterHistory> findByCustomerAndJobNameAndStatus(Customer customer, String jobName, String status);
	
	public List<PrinterHistory> findByUsernameAndJobNameAndStatus(String username, String jobName, String status);
	
	public void deleteByUsername(String username);
	
	public void deleteByCustomer(Customer customer);
	
	@Modifying
	@Query("update PrinterHistory p set p.status = :status where p in :list")
	public void updateStatus(@Param("status") String status, @Param("list") List<PrinterHistory> list);
}

