package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {

	public int countByCustomer(Customer customer);
	
	public List<Notification> findAllByCustomer(Customer customer);
	
	public List<Notification> findAllByMarketplace(Marketplace marketplace);
	
	public Notification findByCustomerAndDescription(Customer customer, String description);
}
