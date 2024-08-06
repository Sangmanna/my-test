package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	public List<Customer> getCustomerByEmail(String email);

	public Customer findByChargebeeId(String chargebeeCustomerId);
	
	public Customer getCustomerByBusinessName(String businessName);
	
	public Customer findByEmailAndBusinessName(String email, String businessName);
	

	/* for cs-admin */
	public List<Customer> findByBusinessNameIgnoreCase(String businessName);
	
	@Query("SELECT c FROM Customer c, User u where u.username = :username and u.customer = c")
	public List<Customer> findByUsername(String username);
	
	public List<Customer> findByBusinessNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String businessName,String email);
	
	@Query("SELECT c FROM Customer c LEFT JOIN Shipment s ON c.id = s.customer.id "
			+ "WHERE s.customer IS NULL "
			+ "AND c.active IS TRUE "
			+ "AND c.subTier = 'clickship-lite' "
			+ "AND c.isInactivityMailSent IS FALSE "
			+ "AND c.createdDatetime < :date")
	public List<Customer> getInactiveCustomersRegistratedInLastWeek(@Param("date") Date date);
	
	@Query("SELECT c FROM Customer c LEFT JOIN Shipment s ON c.id = s.customer.id "
			+ "WHERE s.customer IS NULL "
			+ "AND c.active IS TRUE "
			+ "AND c.subTier = 'clickship-lite' "
			+ "AND c.isDisabledMailSent IS FALSE "
			+ "AND c.createdDatetime < :date")
	public List<Customer> getInactiveCustomerRegistredInLastThreeWeeks(@Param("date") Date date);

	public Customer findByFcCustomerId(String fcCustomerId);

	@Modifying
	@Query("UPDATE Customer c SET c.vettingProcessCompleted = true WHERE c.id = :id")
	void completeVettingProcess(@Param("id") String customerId);
	
	List<Customer> findByLastShipDatetimeIsNullAndTemporaryLockedIsFalseAndVettingProcessCompletedIsTrue();

	@Query("SELECT c FROM Customer c WHERE c.vettingProcessCompleted = true AND c.id IN (SELECT u.customer.id FROM User u GROUP BY u.customer.id HAVING TIMESTAMPDIFF(DAY, MAX(u.lastLogin), CURRENT_TIMESTAMP()) > :days)")
	List<Customer> findCustomersWithNoLoginSince(@Param("days") int days);
}