package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

	public List<Order> findAllByIdIn(List<String> orderIds);

	public List<Order> findAllByParentOrder(Order parentOrder);
	
	public List<Order> findAllByMarketplace(Marketplace marketplace);
	
	@Modifying
	public void deleteByOrderDateLessThanEqualAndStatus(Date lastWeek, String status);
	
	public List<Order> findByCustomerAndIdIn(Customer customer, List<String> ordersIds);
	
	public List<Order> findAllByCustomerAndStatus(Customer customer, String status);
	
	public List<Order> findAllByMarketplaceAndStatus(Marketplace marketplace, String status);
	
	public List<Order> findAllByMarketplaceAndStatusInAndArchivedIsFalse(Marketplace marketplace, List<String> statuses);
	
	public Order findByMarketplaceAndOrderNumber(Marketplace marketplace, String orderNumber);
	
	public Order findByMarketplaceAndExternalOrderId(Marketplace marketPlace, String externalOrderId);
	
	public List<Order> findByMarketplaceAndOrderNumberIn(Marketplace marketplace, List<String> orderNumbers);
	
	public List<Order> findByMarketplaceAndExternalOrderIdIn(Marketplace marketplace, List<String> orderNumbers);
	
	public Order findByMarketplaceAndParentOrderAndExtFulfillmentOrderId(Marketplace marketplace, Order order, String extFulfillmentOrderId);
	
	@Query("SELECT COUNT(o.id) FROM Order o "
			+ "WHERE o.customer.id = :loginCustomerId AND o.marketplace.id = :marketplaceId AND o.status IN (:status)")
	public long getOrdersToShip(
			@Param("loginCustomerId") String loginCustomerId, 
			@Param("marketplaceId") String marketplaceId, 
			@Param("status") String status);
	
	@Query("SELECT SUM(o.total) FROM Order o "
			+ "WHERE o.customer.id = :loginCustomerId AND o.marketplace.id = :marketplaceId AND o.orderDate = :today")
	public Double getTodayTotalSales(
			@Param("loginCustomerId") String loginCustomerId, 
			@Param("marketplaceId") String marketplaceId, 
			@Param("today") Date today);

	@Query("SELECT COUNT(o.id) FROM Order o "
			+ "WHERE o.customer.id = :loginCustomerId AND o.marketplace.id = :marketplaceId AND o.status IN (:status) AND o.orderDate = :today")
	public long getTodayNewOrders(
			@Param("loginCustomerId") String loginCustomerId, 
			@Param("marketplaceId") String marketplaceId, 
			@Param("today") Date today, 
			@Param("status") String status);
	
	@Modifying
	@Query("UPDATE Order o SET  o.archived = true WHERE o.shipDate < :shipDate AND o.status = 'Fulfilled' AND o.marketplace.id IS NOT NULL AND o.archived is false")
	public int archiveFulfilledOrders(@Param("shipDate") Date shipDate);
	
	@Modifying
	@Query("UPDATE Order o SET  o.archived = true WHERE o.orderDate < :orderDate AND o.status = 'ExternallyFulfilled' AND o.marketplace.id IS NOT NULL AND o.archived is false")
	public int archiveExternallyFulfilledOrders(@Param("orderDate") Date orderDate);
	
	@Procedure(procedureName = "dashboard_orders_summary_store_proc")
	public int getDashboardOrderSummaryByStatus(String customerId, String status, int noOfDays);
	
	@Query(value = "SELECT COUNT(*) FROM ( SELECT ol.quantity FROM orders o JOIN orderline ol on o.id = ol.order_id INNER JOIN marketplace m on o.marketplace_id = m.id AND m.customer_id = :loginCustomerId AND m.active = true and m.is_deleted = '0' WHERE o.customer_id = :loginCustomerId AND o.status = 'Unfulfilled' AND " +
			"(o.order_rel_type IN ('SC', 'CP', 'FO') OR o.order_rel_type IS NULL) AND o.archived is false GROUP BY o.id HAVING SUM(ol.quantity)=1) s", nativeQuery = true)
	public int getDashboardSingleOrderCount(@Param("loginCustomerId") String loginCustomerId);

	@Query(value = "SELECT COUNT(*) FROM ( SELECT ol.quantity FROM orders o JOIN orderline ol on o.id = ol.order_id INNER JOIN marketplace m on o.marketplace_id = m.id AND m.customer_id = :loginCustomerId AND m.active = true and m.is_deleted = '0' WHERE o.customer_id = :loginCustomerId AND o.status = 'Unfulfilled' AND " +
			"(o.order_rel_type IN ('SC', 'CP', 'FO') OR o.order_rel_type IS NULL) AND o.archived is false GROUP BY o.id HAVING SUM(ol.quantity)>1) s", nativeQuery = true)
	public int getDashboardMultiOrderCount(@Param("loginCustomerId") String loginCustomerId);

	@Query("SELECT o.id FROM Order o INNER JOIN o.customer c ON c.id=o.customer.id INNER JOIN o.marketplace m ON m.id=o.marketplace.id WHERE o.customer.id = :customerId AND o.status IN ( :statuses ) AND o.marketplace.id IS NOT NULL AND m.active IS TRUE AND m.integrationSuccess IS TRUE")
	public List<String> getAllOrdersForCustomer(@Param("customerId") String customerId, @Param("statuses") List<String> statuses);

	@Query("SELECT o FROM Order o INNER JOIN o.customer c ON c.id = o.customer.id INNER JOIN o.marketplace m ON m.id=o.marketplace.id AND o.marketplace.id IS NOT NULL AND m.active IS TRUE AND m.integrationSuccess IS TRUE WHERE c.id = :customerId AND o.status IN ( :status )")
	public List<Order> getCustomerUnfulfilledOrders(@Param("customerId") String customerId, @Param("status") List<String> status);
	
	@Query(" SELECT ol.order.id " 
			+ " FROM com.freightcom.clickship.data.entity.Orderline ol, Order o"
			+ " WHERE ol.marketplaceProduct.id = :marketplaceProductId " 
			+ " AND o.id = ol.order.id "
			+ " AND o.archived = false")
	public List<String> findOrderIdByMarketplaceProductAndOrderNotArchived(@Param("marketplaceProductId") String marketplaceProductId);
	
}