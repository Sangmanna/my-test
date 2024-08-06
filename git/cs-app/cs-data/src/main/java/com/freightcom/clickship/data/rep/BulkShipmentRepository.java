package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.BulkShipment;
import com.freightcom.clickship.data.entity.Customer;

@Repository
public interface BulkShipmentRepository extends JpaRepository<BulkShipment, String> {
	
	public long countByCustomer(Customer customer);
	
	public BulkShipment findByCustomerAndBatchNumber(Customer customer, String batchNumber);
	
	public long countByCustomerAndCreatedDatetimeGreaterThan(Customer customer, Date createdDate);
	
	public List<BulkShipment> findByCustomerAndStatusInAndIdNotIn(Customer customer, List<String> statuses, List<String> ids);

}
