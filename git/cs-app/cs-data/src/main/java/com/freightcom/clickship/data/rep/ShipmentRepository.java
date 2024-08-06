package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByCountryDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByDayDTO;
import com.freightcom.clickship.model.shipment.DashboardScheduledPickupDTO;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
	
	public Shipment findByOrderNumber(String orderNumber);
	
	public List<Shipment> findByCustomer(Customer customer);
	
	/* return number of shipments for a customer */
	public Long countByCustomerIdAndActiveTrue(String customerId);
	
	public Shipment findByCarrierShipmentId(String carrierShipmentId);

	/**
	 * @deprecated very slow
	 * @param freightcomOrderId
	 * @return
	 */
	@Query("SELECT s FROM Shipment s WHERE (s.freightcomOrderId = :freightcomOrderId OR s.freightcomV2OrderId = :freightcomOrderId)")
	public Shipment findByFreightcomOrderId(@Param("freightcomOrderId") String freightcomOrderId);
	
	@Query("SELECT s FROM Shipment s WHERE s.customer = :customer and (s.freightcomOrderId = :freightcomOrderId OR s.freightcomV2OrderId = :freightcomOrderId)")
	public Shipment findByFreightcomOrderIdByCustomer(@Param("freightcomOrderId") String freightcomOrderId, @Param("customer") Customer customer);
	
	/* finds first shipment for a customer */
	@Query(value = " SELECT MIN(s.d) d "
			+ "FROM ( "
			+ "SELECT MIN(created_datetime) d "
			+ "FROM shipment where customer_id = :customerId UNION "
			+ "SELECT MIN(created_datetime) d "
			+ "FROM clickship_backup.shipment where customer_id = :customerId "
			+ ") s ", nativeQuery = true)
	public Date firstShipDate(String customerId);
	
	@Query(value = " SELECT max(s.d) d "
			+ "FROM ( "
			+ "SELECT max(created_datetime) d "
			+ "FROM shipment where customer_id = :customerId UNION "
			+ "SELECT max(created_datetime) d "
			+ "FROM clickship_backup.shipment where customer_id = :customerId "
			+ ") s ", nativeQuery = true)
	public Date lastShipDate(String customerId);
	
	@Query("SELECT COUNT(s.id) FROM Shipment s WHERE s.customer.id = :loginCustomerId")
	public long getShipmentCountByCustomer(@Param("loginCustomerId") String loginCustomerId);

	public List<Shipment> findByCustomerAndShipmentType(Customer customer, String shipmentType);
	
	@Procedure(procedureName = "dashboard_shipment_summary_store_proc")
	public int getDashboardShipmentSummaryByStatus(String customerId, String username, String status, int noOfDays);
	
	@Query("SELECT new com.freightcom.clickship.model.shipment.DashboardScheduledPickupDTO (c.imageName, COUNT(s.id)) FROM Shipment s JOIN Carrier c ON c.id = s.carrier.id " +
			"JOIN Pickup p ON p.shipment = s WHERE s.customer = :customer AND p.pickupStart >= :start AND p.pickupStart < :end GROUP BY c.shortName")
	List<DashboardScheduledPickupDTO> getDashboardScheduledPickups (@Param("customer") Customer customer, Date start, Date end);
	
	@Query("SELECT new com.freightcom.clickship.model.shipment.DashboardScheduledPickupDTO (c.imageName, COUNT(s.id)) FROM Shipment s"
			+ " JOIN UserShipments us ON s.id = us.shipment.id AND us.active is true"
			+ " JOIN Carrier c ON c.id = s.carrier.id"
			+ " JOIN Pickup p ON p.shipment = s WHERE s.customer = :customer AND us.user = :user AND p.pickupStart >= :start AND p.pickupStart < :end GROUP BY c.shortName")
	List<DashboardScheduledPickupDTO> getUserDashboardScheduledPickups (@Param("customer") Customer customer, @Param("user") User user, Date start, Date end);
	
	@Query("SELECT COUNT(o.id) FROM Order o "
			+ "WHERE o.customer.id = :loginCustomerId AND o.marketplace.id = :marketplaceId AND o.status IN (:status) AND o.orderDate = :today")
	public long getTodayNewOrders(
			@Param("loginCustomerId") String loginCustomerId, 
			@Param("marketplaceId") String marketplaceId, 
			@Param("today") Date today, 
			@Param("status") String status);
	
	@Query("SELECT s FROM Shipment s WHERE active is true AND createdDatetime>=:date AND shipmentType IN (:type) AND status NOT IN (:notStatusIn)")
	public List<Shipment> getActiveShipmentsByDateAndTypeInAndNotStatusIn(Date date, List<String> type, List<String> notStatusIn);
	
	@Query("SELECT new com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByDayDTO("
			+ "DAY(s.createdDatetime), HOUR(s.createdDatetime), count(*)) "
			+ "FROM Shipment s "
			+ "WHERE s.active is true AND s.createdDatetime BETWEEN :from AND :to "
			+ "GROUP BY DAY(s.createdDatetime), HOUR(s.createdDatetime) ORDER BY DAY(s.createdDatetime) ASC")
	public List<ShipmentsCountByDayDTO> getShipmentsCountByDayAndHour(Date from, Date to);

	@Query("SELECT new com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByCountryDTO("
			+ "s.shiptoCountry, s.shiptoProvinceState, COUNT(s.shiptoProvinceState)) "
			+ "FROM Shipment s "
			+ "WHERE s.active is true AND s.createdDatetime BETWEEN :from AND :to "
			+ "GROUP BY s.shiptoCountry, s.shiptoProvinceState")
	public List<ShipmentsCountByCountryDTO> getShipmentsCountByCountry(Date from, Date to);

	public boolean existsByCustomerIdAndFreightcomV2OrderId(String customerId, String freightcomOrderId);
	public boolean existsByCustomerIdAndPackageType(String customerId, String packageType);
	
	@Query(value = "SELECT COUNT(1) FROM shipment s, orders o " +
            "WHERE s.order_id = o.id " +
            "AND o.customer_id = :customerId " +
            "AND o.marketplace_id is null " +
            "AND s.created_datetime >= date_sub(curdate(), interval 6 month) " +
            "AND s.package_type = 'Pallet' " +
            "AND s.active is true", nativeQuery = true)
    Long countPalletShipmentsExcludingMarketplaceOrdersForCustomer(String customerId);
	
	@Query(value = "SELECT COUNT(1) FROM shipment s, orders o " +
            "WHERE s.order_id = o.id " +
            "AND o.customer_id = :customerId " +
            "AND o.marketplace_id is not null " +
            "AND s.created_datetime >= date_sub(curdate(), interval 6 month) " +
            "AND s.package_type = 'Pallet' " +
            "AND s.active is true", nativeQuery = true)
    Long countPalletShipmentsIncludingMarketplaceOrdersForCustomer(String customerId);
}