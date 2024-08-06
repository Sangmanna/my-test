package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.PrefetchQuoteRequest;

@Repository
public interface PrefetchQuoteRequestRepository extends JpaRepository<PrefetchQuoteRequest, String> {

	@Query("SELECT qr FROM PrefetchQuoteRequest qr INNER JOIN qr.customer c ON c.id = qr.customer.id WHERE c.id = :customerId AND qr.order.marketplace.id IS NOT NULL")
	public List<PrefetchQuoteRequest> findByCustomer(@Param("customerId") String customerId);

	@Query("SELECT pqr FROM PrefetchQuoteRequest pqr WHERE pqr.order.status = :status AND pqr.order.shipDate < :shipDate AND pqr.order.marketplace.id IS NOT NULL")
	public List<PrefetchQuoteRequest> deleteQuotesByStatus(@Param("status") String status, @Param("shipDate") Date shipDate);

	@Query("SELECT qr FROM PrefetchQuoteRequest qr INNER JOIN qr.prefetchQuotes pq ON qr.id = pq.prefetchQuoteRequest.id WHERE qr.order.status = :status AND qr.order.marketplace.id IS NOT NULL")
	public List<PrefetchQuoteRequest> refreshQuotesByStatus(@Param("status") String status);

	@Query("SELECT pr FROM PrefetchQuoteRequest pr WHERE pr.customer.id = :customerId AND pr.apiError IS NOT NULL AND pr.failedAttempts > 0 and pr.failedAttempts <= :retryCount")
	public List<PrefetchQuoteRequest> getPrefetchFaildOrders(@Param("customerId") String customerId,
			@Param("retryCount") Integer retryCount);

	public PrefetchQuoteRequest findByCustomerAndMarketplaceAndOrder(Customer customer, Marketplace marketplace, Order order);
	
}
