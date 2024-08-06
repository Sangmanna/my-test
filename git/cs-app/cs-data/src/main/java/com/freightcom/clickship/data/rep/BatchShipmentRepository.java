package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.BatchShipment;
import com.freightcom.clickship.data.entity.BulkShipment;
import com.freightcom.clickship.data.entity.Order;

@Repository
public interface BatchShipmentRepository extends JpaRepository<BatchShipment, String> {

	public List<BatchShipment> findByStatusIsNull();
	
	public List<BatchShipment> findByBulkShipment(BulkShipment bulkShipment);
	
	@Query("SELECT count(bs.id) FROM BatchShipment bs WHERE bs.bulkShipment.customer.id=:customerId and bs.bulkShipment.createdDatetime>:createdDate")
	public long getTotalBatchShipmentsByCustomer(@Param("customerId") String customerId, @Param("createdDate") Date createdDate);

	
	@Query("SELECT bs FROM BatchShipment bs WHERE bs.bulkShipment.id=:bulkShipmentId")
	public List<BatchShipment> findByBatchId(@Param("bulkShipmentId") String bulkShipmentId);

	public BatchShipment findByBulkShipmentAndOrder(BulkShipment bulkShipment, Order order);
	
	@Query("SELECT bs.order.id FROM BatchShipment bs WHERE bs.bulkShipment.customer.id=:customerId AND bs.bulkShipment.status IN (:status)")
	public List<String> getProcessingBatchOrders(@Param("customerId") String customerId, @Param("status") List<String> status);

	public List<BatchShipment> findByBulkShipmentAndIsOwnCarrierShipmentIsFalseAndStatusIsNull(BulkShipment bulkShipment);
}
