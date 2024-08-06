package com.freightcom.clickship.service.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.freightcom.clickship.model.admin.dashboard.ActiveCustomerCountsDTO;
import com.freightcom.clickship.model.admin.dashboard.ActiveCustomerTableDto;
import com.freightcom.clickship.model.admin.dashboard.InActiveCustomerTableDto;
import com.freightcom.clickship.model.admin.dashboard.carriers.CarriersDTO;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.ShipmentsEarningsDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.LabelProcessedTableDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentTrackingDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentTypeCountDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByDayDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByMonthDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByWeekDTO;
import com.freightcom.clickship.model.admin.dashboard.shipments.ShipmentsCountByYearDTO;
import com.freightcom.clickship.service.dao.ShipmentDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ShipmentDaoImpl implements ShipmentDao {

	@PersistenceContext
	private EntityManager em;
	
	private String agentCondition = " AND cs.sales_rep = :agentName ";
	private String joinCustomer = "  JOIN customer cs ON s.customer_id = cs.id  ";
	private String joinBackupCustomer = "  JOIN clickship_backup.customer cs ON s.customer_id = cs.id  ";

	// queries for day chart
	private String shipmentByDay = "SELECT DAY(s.created_datetime), HOUR(s.created_datetime), count(*) "
			+ "FROM shipment s  " + "JOIN carrier c ON s.carrier_code=c.id  "
			+ "JOIN customer cs ON s.customer_id = cs.id "
			+ "WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1 AND  c.service_identifier='CS' "
			+ "GROUP BY DAY(s.created_datetime), HOUR(s.created_datetime) ORDER BY DAY(s.created_datetime) ASC";

	private String shipmentByDayForAgent = "SELECT DAY(s.created_datetime), HOUR(s.created_datetime), count(*) "
			+ "FROM shipment s  " + "JOIN carrier c ON s.carrier_code=c.id  "
			+ "JOIN customer cs ON s.customer_id = cs.id "
			+ "WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1 AND  cs.sales_rep = :agentName AND  c.service_identifier='CS' "
			+ "GROUP BY DAY(s.created_datetime), HOUR(s.created_datetime) ORDER BY DAY(s.created_datetime) ASC";

	// queries for 6 months range chart
	private String shipmentByYear = "SELECT MONTH(s.created_datetime), count(*) FROM shipment s  "
			+ "JOIN carrier c ON s.carrier_code=c.id JOIN customer cs ON s.customer_id = cs.id WHERE "
			+ "s.created_datetime BETWEEN :from AND :to AND s.active=1  AND c.service_identifier='CS' "
			+ "GROUP BY MONTH(s.created_datetime)";

	private String shipmentByYearForAgent = "SELECT MONTH(s.created_datetime), count(*) "
			+ "FROM shipment s  " + "JOIN carrier c ON s.carrier_code=c.id  "
			+ "JOIN customer cs ON s.customer_id = cs.id "
			+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1 AND cs.sales_rep = :agentName  AND c.service_identifier='CS' "
			+ "GROUP BY MONTH(s.created_datetime) ";

	// queries for custom date range
		private String shipmentByDateRange = " SELECT SUM(counts) FROM (SELECT count(*) as counts  "
				+ "FROM shipment s  " + "JOIN carrier c ON s.carrier_code=c.id  "
				+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1  AND c.service_identifier='CS' "
				+ "UNION SELECT count(*) as counts "
				+ "FROM clickship_backup.shipment s  " + "JOIN clickship_backup.carrier c ON s.carrier_code=c.id  "
				+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1  AND c.service_identifier='CS') as T ";

		private String shipmentByDateRangeForAgent = " SELECT SUM(counts) FROM (SELECT count(*) as counts  "
				+ "FROM shipment s  " + "JOIN carrier c ON s.carrier_code=c.id  "+joinCustomer
				+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1 AND cs.sales_rep = :agentName  AND c.service_identifier='CS' "
				+ "UNION SELECT count(*) as counts "
				+ "FROM clickship_backup.shipment s  " + "JOIN clickship_backup.carrier c ON s.carrier_code=c.id "+joinBackupCustomer
				+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1 AND cs.sales_rep = :agentName  AND c.service_identifier='CS') as T";
				
		
	// queries for Week range chart
	private String shipmentCountInWeek = "SELECT 1 as term, date_format(s.created_datetime, \"%d-%m-%Y\") as day, count(*) as COUNT "
			+ "FROM shipment s " + joinCustomer + " JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE s.active=1 AND s.created_datetime BETWEEN :from1 AND :to1 AND c.service_identifier='CS' "
			+ " GROUP BY day UNION "
			+ "SELECT 2 AS term, date_format(s.created_datetime, \"%d-%m-%Y\") as day, count(*) as COUNT "
			+ "FROM shipment s " + joinCustomer + " JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE s.active=1 AND s.created_datetime BETWEEN :from2 AND :to2 AND c.service_identifier='CS' "
			+ "GROUP BY day";

	private String shipmentCountWeekWithAgentCondition = "SELECT 1 as term, date_format(s.created_datetime, \"%d-%m-%Y\") as day, count(*) as COUNT "
			+ "FROM shipment s " + "JOIN customer cs ON s.customer_id = cs.id  "
			+ "JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE s.active=1 AND s.created_datetime BETWEEN :from1 AND :to1  AND cs.sales_rep = :agentName AND c.service_identifier='CS' GROUP BY day "
			+ " UNION " + "SELECT 2 AS term, date_format(s.created_datetime, \"%d-%m-%Y\") as day, count(*) as COUNT "
			+ "FROM shipment s  " + "JOIN customer cs ON s.customer_id = cs.id "
			+ "JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE s.active=1 AND s.created_datetime BETWEEN :from2 AND :to2  AND cs.sales_rep = :agentName AND c.service_identifier='CS' GROUP BY day";

	// Bulk shipment counts
	
	private String bulkShippingCountByDateRange = "select count(*) from batch_shipments bs join bulk_shipment b on "
			+ "bs.bulk_shipment_id = b.id join shipment s on s.id=bs.shipment_id join carrier car on car.id=s.carrier_code "
			+ "join customer c on c.id = s.customer_id where bs.created_datetime between :from and :to "
			+ "and s.active is true and car.service_identifier=:serviceType";
	
	private String bulkShippingCountByDateRangeWithAgentCondition = "select count(*) from batch_shipments bs join bulk_shipment b on "
			+ "bs.bulk_shipment_id = b.id join shipment s on s.id=bs.shipment_id join carrier car on car.id=s.carrier_code "
			+ "join customer c on c.id = s.customer_id where bs.created_datetime between :from and :to "
			+ "and s.active is true and car.service_identifier=:serviceType and c.sales_rep=:agentName ";
	
	// V1 & V2 Counts
	
	private String shipmentv1v2Counts = "SELECT \r\n"
			+ "	SUM(v2Count) AS v2Count,\r\n"
			+ "    SUM(v1Count) AS v1Count\r\n"
			+ " FROM (\r\n"
			+ " SELECT\r\n"
			+ "    SUM(CASE WHEN s.freightcom_v2_order_id is not null THEN 1 ELSE 0 END) AS v2Count,\r\n"
			+ "    SUM(CASE WHEN s.freightcom_v2_order_id IS NULL THEN 1 ELSE 0 END) AS v1Count\r\n"
			+ " FROM\r\n"
			+ "    shipment s JOIN carrier c ON s.carrier_code=c.id  JOIN customer cs ON s.customer_id = cs.id WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1 AND  c.service_identifier='CS'\r\n"
			+ " UNION\r\n"
			+ " SELECT\r\n"
			+ "    SUM(CASE WHEN s.freightcom_v2_order_id is not null THEN 1 ELSE 0 END) AS v2Count,\r\n"
			+ "    SUM(CASE WHEN s.freightcom_v2_order_id IS NULL THEN 1 ELSE 0 END) AS v1Count\r\n"
			+ " FROM\r\n"
			+ "    clickship_backup.shipment s JOIN carrier c ON s.carrier_code=c.id  JOIN customer cs ON s.customer_id = cs.id WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1 AND  c.service_identifier='CS'\r\n"
			+ " ) AS Results";
	
	private String shipmentv1v2CountsByAgent = "SELECT \r\n"
			+ "	SUM(v2Count) AS v2Count,\r\n"
			+ "    SUM(v1Count) AS v1Count\r\n"
			+ " FROM (\r\n"
			+ " SELECT\r\n"
			+ "    SUM(CASE WHEN s.freightcom_v2_order_id is not null THEN 1 ELSE 0 END) AS v2Count,\r\n"
			+ "    SUM(CASE WHEN s.freightcom_v2_order_id IS NULL THEN 1 ELSE 0 END) AS v1Count\r\n"
			+ " FROM\r\n"
			+ "    shipment s JOIN carrier c ON s.carrier_code=c.id  JOIN customer cs ON s.customer_id = cs.id WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1 and cs.sales_rep=:agentName AND  c.service_identifier='CS'\r\n"
			+ " UNION\r\n"
			+ " SELECT\r\n"
			+ "    SUM(CASE WHEN s.freightcom_v2_order_id is not null THEN 1 ELSE 0 END) AS v2Count,\r\n"
			+ "    SUM(CASE WHEN s.freightcom_v2_order_id IS NULL THEN 1 ELSE 0 END) AS v1Count\r\n"
			+ " FROM\r\n"
			+ "    clickship_backup.shipment s JOIN carrier c ON s.carrier_code=c.id  JOIN customer cs ON s.customer_id = cs.id WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1 and cs.sales_rep=:agentName AND  c.service_identifier='CS'\r\n"
			+ " ) AS Results";
	
	//External Orders Queries
	
	private String externalOrdersByDay = "SELECT DAY(o.created_datetime), HOUR(o.created_datetime), count(*) "
			+ "FROM orders o " 
			+ "WHERE o.created_datetime BETWEEN :from AND :to and o.status='ExternallyFulfilled' and (o.ext_fulfillment_order_type is null or o.ext_fulfillment_order_type not in ('retail','pick-up','none')) "
			+ "GROUP BY DAY(o.created_datetime), HOUR(o.created_datetime) ORDER BY DAY(o.created_datetime) ASC";

	private String externalOrdersByDayForAgent = "SELECT DAY(o.created_datetime), HOUR(o.created_datetime), count(*) "
			+ "FROM orders o "
			+ "JOIN customer cs ON o.customer_id = cs.id "
			+ "WHERE o.created_datetime BETWEEN :from AND :to AND cs.sales_rep = :agentName and o.status='ExternallyFulfilled' and (o.ext_fulfillment_order_type is null or o.ext_fulfillment_order_type not in ('retail','pick-up','none')) "
			+ "GROUP BY DAY(o.created_datetime), HOUR(o.created_datetime) ORDER BY DAY(o.created_datetime) ASC";

	private String externalOrdersCountInWeek = "SELECT 1 as term, date_format(o.created_datetime, \"%d-%m-%Y\") as day, count(*) as COUNT "
			+ "FROM orders o " 
			+ "WHERE o.created_datetime BETWEEN :from1 AND :to1 and o.status='ExternallyFulfilled' and (o.ext_fulfillment_order_type is null or o.ext_fulfillment_order_type not in ('retail','pick-up','none')) "
			+ "GROUP BY day UNION "
			+ "SELECT 2 as term, date_format(o.created_datetime, \"%d-%m-%Y\") as day, count(*) as COUNT "
			+ "FROM orders o "  
			+ "WHERE o.created_datetime BETWEEN :from2 AND :to2 and o.status='ExternallyFulfilled' and (o.ext_fulfillment_order_type is null or o.ext_fulfillment_order_type not in ('retail','pick-up','none')) "
			+ " GROUP BY day";

	private String externalOrdersCountWeekWithAgentCondition = ""
			+ " select  1 as term,o.formated_date as day, sum(o.count) as COUNT from customer c join "
			+ " (select date_format(created_datetime, \"%d-%m-%Y\") as formated_date ,customer_id,count(*) as count from orders where "
			+ " created_datetime BETWEEN  :from1 AND :to1 and "
			+ " status='ExternallyFulfilled' and (ext_fulfillment_order_type is null or ext_fulfillment_order_type not in ('retail','pick-up','none')) group by formated_date,customer_id) o "
			+ " on c.id=o.customer_id where sales_rep=:agentName group by day "
			+ "UNION "
			+ "select 2 as term, o.formated_date as day, sum(o.count) as COUNT from customer c join "
			+ "(select date_format(created_datetime, \"%d-%m-%Y\") as formated_date ,customer_id,count(*) as count from orders where "
			+ "created_datetime BETWEEN :from2 AND :to2 and "
			+ "status='ExternallyFulfilled' and (ext_fulfillment_order_type is null or ext_fulfillment_order_type not in ('retail','pick-up','none')) group by formated_date,customer_id) o "
			+ "on c.id=o.customer_id where sales_rep=:agentName group by day ";
			
			
	private String externalOrdersByYear = "Select month(created_datetime),count(*) from orders "
			+ "where status='ExternallyFulfilled' and (ext_fulfillment_order_type is null or ext_fulfillment_order_type not in ('retail','pick-up','none')) and "
			+ "created_datetime  BETWEEN :from AND :to "
			+ "group by month(created_datetime)";

	private String externalOrdersByYearForAgent = "select "
			+ " o.data_month, sum(o.count) from customer c join "
			+ " (select MONTH(created_datetime) as data_month ,customer_id,count(*) as count from orders where "
			+ " created_datetime BETWEEN :from AND :to  and "
			+ " status='ExternallyFulfilled' and (ext_fulfillment_order_type is null or ext_fulfillment_order_type not in ('retail','pick-up','none')) group by data_month,customer_id) o "
			+ " on c.id=o.customer_id where sales_rep=:agentName group by o.data_month ";

	private String externalOrdersByDateRange = "SELECT SUM(counts) FROM ( SELECT count(*) as counts "
			+ "FROM orders o " 
			+ "WHERE o.created_datetime BETWEEN :from AND :to and o.status='ExternallyFulfilled' and (o.ext_fulfillment_order_type is null or o.ext_fulfillment_order_type not in ('retail','pick-up','none')) "
			+ "UNION SELECT count(*) as counts "
			+ "FROM clickship_backup.orders o " 
			+ "WHERE o.created_datetime BETWEEN :from AND :to and o.status='ExternallyFulfilled' and (o.ext_fulfillment_order_type is null or o.ext_fulfillment_order_type not in ('retail','pick-up','none')) ) as T" ;
	
	private String externalOrdersByDateRangeWithAgent = "SELECT SUM(counts) FROM ( SELECT count(*) as counts "
			+ "FROM orders o join customer c on c.id=o.customer_id and c.sales_rep=:agentName " 
			+ "WHERE o.created_datetime BETWEEN :from AND :to and o.status='ExternallyFulfilled' and (o.ext_fulfillment_order_type is null or o.ext_fulfillment_order_type not in ('retail','pick-up','none')) "
			+ "UNION SELECT count(*) as counts "
			+ "FROM clickship_backup.orders o join clickship_backup.customer c on c.id=o.customer_id and c.sales_rep=:agentName " 
			+ "WHERE o.created_datetime BETWEEN :from AND :to and o.status='ExternallyFulfilled' and (o.ext_fulfillment_order_type is null or o.ext_fulfillment_order_type not in ('retail','pick-up','none')) ) as T" ;

//	private String externalOrdersByDateRangeWithAgent1 = "select  sum(o.count) from customer c join "
//			+ " (select customer_id,count(*) as count from orders where "
//			+ " created_datetime BETWEEN :from AND :to and "
//			+ " status='ExternallyFulfilled' group by customer_id) o "
//			+ " on c.id=o.customer_id where sales_rep=:agentName ";
	
	// queries for lables chart
	private String OCShipmentsByDay = "Select DAY(s.created_datetime), HOUR(s.created_datetime) as hour, count(*) "
			+ "FROM shipment s  JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE c.service_identifier='OC'  AND s.active=1 AND s.created_datetime BETWEEN :from AND :to "
			+ "GROUP BY DAY(s.created_datetime), hour";

	private String OCShipmentsByDaySalesAgent = "Select DAY(s.created_datetime), HOUR(s.created_datetime) as hour, count(*) "
			+ "FROM shipment s " + "JOIN carrier c ON s.carrier_code=c.id " + joinCustomer
			+ "WHERE c.service_identifier='OC'  AND s.active=1 AND s.created_datetime BETWEEN :from AND :to "
			+ agentCondition + "GROUP BY DAY(s.created_datetime), hour";

	private String OCShipmentCountByWeekOrMonth = "(SELECT 1 AS term, date_format(s.created_datetime, \"%d-%m-%Y\") as day,  count(*) as COUNT "
			+ "FROM shipment s  " + "JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE c.service_identifier = 'OC'  AND s.active=1 AND s.created_datetime BETWEEN :from1 AND :to1 "
			+ " GROUP BY day )"
			+ "UNION (SELECT 2 AS term, date_format(s.created_datetime, \"%d-%m-%Y\") as day,  count(*) as COUNT "
			+ "FROM shipment s  JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE c.service_identifier = 'OC'  AND s.active=1 AND s.created_datetime BETWEEN :from2 AND :to2 "
			+ "GROUP BY day )";

	private String OCShipmentCountByWeekOrMonthSalesAgent = "(SELECT 1 AS term, date_format(s.created_datetime, \"%d-%m-%Y\") as day,  count(*) as COUNT "
			+ "FROM shipment s  " + "JOIN carrier c ON s.carrier_code=c.id " + joinCustomer
			+ "WHERE c.service_identifier = 'OC'  AND s.active=1 AND s.created_datetime BETWEEN :from1 AND :to1 "
			+ agentCondition + " GROUP BY day )"
			+ "UNION (SELECT 2 AS term, date_format(s.created_datetime, \"%d-%m-%Y\") as day,  count(*) as COUNT "
			+ "FROM shipment s  JOIN carrier c ON s.carrier_code=c.id " + joinCustomer
			+ "WHERE c.service_identifier = 'OC'  AND s.active=1 AND s.created_datetime BETWEEN :from2 AND :to2 "
			+ agentCondition + "GROUP BY day )";

	private String OCShipmentByYear = "SELECT  month(s.created_datetime) as month, count(*) "
			+ "FROM shipment s " + "JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE c.service_identifier='OC' AND s.active = '1' AND s.created_datetime BETWEEN :from AND :to "
			+ "GROUP BY month ";

	private String OCShipmentByYearSalesAgent = "SELECT month(s.created_datetime) as month, count(*) "
			+ "FROM shipment s " + "JOIN carrier c ON s.carrier_code=c.id " + joinCustomer
			+ "WHERE c.service_identifier='OC' AND s.active = '1' AND s.created_datetime BETWEEN :from AND :to "
			+ agentCondition + "GROUP BY month ";
	
	private String OCShipmentByDateRange = "SELECT SUM(counts) from (SELECT count(*) as counts "
			+ "FROM shipment s " + "JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE c.service_identifier='OC' AND s.active = '1' AND s.created_datetime BETWEEN :from AND :to "
			+ " UNION SELECT count(*) as counts "
			+ "FROM clickship_backup.shipment s " + "JOIN clickship_backup.carrier c ON s.carrier_code=c.id "
			+ "WHERE c.service_identifier='OC' AND s.active = '1' AND s.created_datetime BETWEEN :from AND :to) as T ";
			
	private String OCShipmentByDateRangeForAgent = "SELECT SUM(counts) from (SELECT count(*) as counts "
			+ "FROM shipment s " + "JOIN carrier c ON s.carrier_code=c.id "  + joinCustomer
			+ "WHERE c.service_identifier='OC' AND s.active = '1' AND s.created_datetime BETWEEN :from AND :to " + agentCondition 
			+ " UNION SELECT count(*) as counts "
			+ "FROM clickship_backup.shipment s " + "JOIN clickship_backup.carrier c ON s.carrier_code=c.id "  + joinBackupCustomer
			+ "WHERE c.service_identifier='OC' AND s.active = '1' AND s.created_datetime BETWEEN :from AND :to " + agentCondition + " ) as T";


	// queries for carreir breakdown chart
	private String carriersByDay = "SELECT date_format(s.created_datetime, \"%d-%m-%Y %T\") as day, "
			+ "c.short_name, COUNT(c.short_name), s.shipment_type " + "FROM shipment s " + "JOIN carrier c ON s.carrier_code = c.id "
			+ "WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to  AND c.service_identifier = :type "
			+ "GROUP BY HOUR(s.created_datetime), c.short_name order by c.short_name, HOUR(s.created_datetime)";

	private String carriersByDayWithAgetCond = "SELECT date_format(s.created_datetime, \"%d-%m-%Y %T\") as day, "
			+ "c.short_name, COUNT(c.short_name), s.shipment_type " + "FROM shipment s " + "JOIN carrier c ON s.carrier_code = c.id "
			+ "JOIN customer cs ON s.customer_id=cs.id WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to "
			+ "AND cs.sales_rep = :agentName  AND c.service_identifier = :type "
			+ "GROUP BY HOUR(s.created_datetime), c.short_name order by c.short_name, HOUR(s.created_datetime)";

	private String carriersBetweenDays = "SELECT date_format(created_datetime, \"%d-%m-%Y\") as day, sn, COUNT(sn),shipment_type from ( "
			+ "SELECT s.created_datetime, c.short_name as sn, s.shipment_type as shipment_type FROM shipment s "
			+ "JOIN carrier c ON s.carrier_code = c.id WHERE "
			+ "s.active='1' AND s.created_datetime BETWEEN :from AND :to AND c.service_identifier = :type "
			+ "UNION ALL "
			+ "SELECT  s.created_datetime, "
			+ "c.short_name as sn, s.shipment_type as shipment_type  FROM clickship_backup.shipment s "
			+ "JOIN clickship_backup.carrier c ON s.carrier_code = c.id "
			+ "WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to AND c.service_identifier = :type ) "
			+ "as T GROUP BY day, T.sn,T.shipment_type order by T.sn;";

	private String carriersBetweenDaysSalesAgent = "SELECT date_format(created_datetime, \"%d-%m-%Y\") as day, sn, COUNT(sn),shipment_type from ( "
			+ "SELECT s.created_datetime, c.short_name as sn, s.shipment_type as shipment_type FROM shipment s "
			+ "JOIN carrier c ON s.carrier_code = c.id "+joinCustomer+" WHERE "
			+ "s.active='1' AND s.created_datetime BETWEEN :from AND :to AND c.service_identifier = :type "+agentCondition
			+ "UNION ALL "
			+ "SELECT  s.created_datetime as day, "
			+ "c.short_name as sn, s.shipment_type as shipment_type  FROM clickship_backup.shipment s "
			+ "JOIN clickship_backup.carrier c ON s.carrier_code = c.id "+joinBackupCustomer
			+ "WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to AND c.service_identifier = :type "+agentCondition+" ) "
			+ "as T GROUP BY day, T.sn,T.shipment_type order by T.sn ";
	
//	private String ownCarriersByDay = "SELECT date_format(s.created_datetime, \"%d-%m-%Y %T\") as day, "
//			+ "c.short_name, COUNT(c.short_name) " + "FROM shipment s " + "JOIN carrier c ON s.carrier_code = c.id "
//			+ "WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to  AND c.service_identifier = 'OC'"
//			+ "GROUP BY HOUR(s.created_datetime), c.short_name order by c.short_name, HOUR(s.created_datetime)";

//	private String ownCarriersByDayWithAgetCond = "SELECT date_format(s.created_datetime, \"%d-%m-%Y %T\") as day, "
//			+ "c.short_name, COUNT(c.short_name) " + "FROM shipment s " + "JOIN carrier c ON s.carrier_code = c.id "
//			+ "JOIN customer cs ON s.customer_id=cs.id WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to "
//			+ "AND cs.sales_rep = :agentName  AND c.service_identifier = 'OC'"
//			+ "GROUP BY HOUR(s.created_datetime), c.short_name order by c.short_name, HOUR(s.created_datetime)";
	
//	private String ownCarriersBetweenDays = "SELECT date_format(s.created_datetime, \"%d-%m-%Y\") as day, "
//			+ "c.short_name, COUNT(c.short_name) " + " FROM shipment s JOIN carrier c ON s.carrier_code = c.id "
//			+ "WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to AND c.service_identifier = 'OC'"
//			+ "GROUP BY day, c.short_name order by c.short_name, HOUR(s.created_datetime)";
//
//	private String ownCarriersBetweenDaysSalesAgent = "SELECT date_format(s.created_datetime, \"%d-%m-%Y\") as day, "
//			+ "c.short_name, COUNT(c.short_name) " + " FROM shipment s JOIN carrier c ON s.carrier_code = c.id "
//			+ joinCustomer
//			+ "WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to AND c.service_identifier = 'OC' "
//			+ agentCondition + "GROUP BY day, c.short_name order by c.short_name, HOUR(s.created_datetime)";
	
	
	private String carriersByCustomDateRange = "SELECT c.short_name, COUNT(c.short_name) FROM shipment s "
			+ "JOIN carrier c ON s.carrier_code = c.id "
			+ "WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to AND c.service_identifier = 'CS'"
			+ "GROUP c.short_name order by c.short_name";

	private String carriersByCustomDateRangeForAgent = "SELECT c.short_name, COUNT(c.short_name) FROM shipment s "
			+ "JOIN carrier c ON s.carrier_code = c.id "
			+ joinCustomer
			+ "WHERE s.active='1' AND s.created_datetime BETWEEN :from AND :to AND c.service_identifier = 'CS' "
			+ agentCondition + "GROUP BY c.short_name order by c.short_name";

	// queries for shipment table in tracking
	private String ordersBetweenDatesSalesAgent = " SELECT  cs.business_name,s.tracking_url, DATE_FORMAT(s.created_datetime, \"%d-%m-%Y\") AS shipdate, "
			+ "cr.short_name, cs.sales_rep as rep, COALESCE(o.shipping_cost,0)" + "FROM shipment s "
			+ "JOIN customer cs ON s.customer_id=cs.id " 
			+ "JOIN carrier cr ON s.carrier_code=cr.id "
			+ "JOIN orders o ON s.order_id = o.id "
			+ "WHERE s.active=1 AND (s.created_datetime)  BETWEEN :from AND :to AND cr.service_identifier = 'CS' AND cs.business_name  LIKE :customer "
			+ agentCondition;

	private String ordersShippedBetweenDates = " SELECT  cs.business_name,s.tracking_url, DATE_FORMAT(s.created_datetime, \"%d-%m-%Y\") AS shipdate, "
			+ "cr.short_name, cs.sales_rep as rep, COALESCE(o.shipping_cost,0) " + "FROM shipment s "
			+ "JOIN customer cs ON s.customer_id=cs.id " + "JOIN carrier cr ON s.carrier_code=cr.id "
			+ "JOIN orders o ON s.order_id = o.id "
			+ "WHERE s.active=1 AND (s.created_datetime)  BETWEEN :from AND :to AND cr.service_identifier = 'CS' AND cs.business_name  LIKE :customer";

	private String labelsProcessedBetweenDates = " SELECT cs.business_name AS bname, c.short_name AS carr,  COUNT(*) AS labels, COALESCE(mt.name,'NA') AS store "
			+ "FROM shipment s "
			+ "LEFT JOIN carrier c ON s.carrier_code=c.id "
			+ "LEFT JOIN customer cs ON s.customer_id=cs.id " 
			+ "JOIN orders o ON s.order_id = o.id "
			+ "LEFT JOIN marketplace m ON TRIM(o.marketplace_id) = TRIM(m.id)  "
			+ "LEFT JOIN marketplace_type mt ON mt.id = m.marketplace_type_id "
			+ "WHERE c.service_identifier ='OC' AND s.active=1 AND (s.created_datetime) "
			+ "BETWEEN :from AND :to AND cs.business_name  LIKE :customer" 
			+ " GROUP BY bname, carr order by bname";

	private String labelsProcessedBetweenDatesSalesAgent = " SELECT cs.business_name AS bname, c.short_name AS carr,  COUNT(*) AS labels, COALESCE(mt.name,'Manual Shipment') AS store "
			+ "FROM shipment s " + "LEFT JOIN carrier c ON s.carrier_code=c.id "
			+ "LEFT JOIN customer cs ON s.customer_id=cs.id " + "JOIN orders o ON s.order_id = o.id "
			+ "LEFT JOIN marketplace m ON TRIM(o.marketplace_id) = TRIM(m.id)  "
			+ "LEFT JOIN marketplace_type mt ON mt.id = m.marketplace_type_id "
			+ "WHERE c.service_identifier ='OC' AND s.active=1 AND (s.created_datetime) BETWEEN :from AND :to "
			+ "AND cs.business_name  LIKE :customer "
			+ agentCondition + " GROUP BY bname, carr order by bname";

/*	private final String selectFromShipment = " (SELECT count(DISTINCT(customer_id)) usersAct FROM shipment s";

	private final String whereCriteria = " WHERE s.active=1 AND s.created_datetime BETWEEN ";

	private String activeToday = selectFromShipment + whereCriteria + " :todaStart AND :todayEnd ) AS today,";

	private String activeTodayAgent = selectFromShipment + joinCustomer + whereCriteria + " :todaStart AND :todayEnd "
			+ agentCondition + ") AS today,";

	private String activeYesterDay = selectFromShipment + whereCriteria
			+ "  :yesterdayStart AND :yesterdayEnd) AS Yesterday, ";

	private String activeYesterDayAgent = selectFromShipment + joinCustomer + whereCriteria
			+ "  :yesterdayStart AND :yesterdayEnd " + agentCondition + ") AS Yesterday, ";

	private String activeThisWeek = selectFromShipment + whereCriteria
			+ "  :thisWeekStart AND :thisWeekEnd ) AS this_week, ";

	private String activeThisWeekAgent = selectFromShipment + joinCustomer + whereCriteria
			+ "  :thisWeekStart AND :thisWeekEnd " + agentCondition + ") AS this_week, ";

	private String activeLastWeek = selectFromShipment + whereCriteria
			+ "  :prevWeekStart AND :prevWeekEnd ) AS last_week, ";

	private String activeLastWeekAgent = selectFromShipment + joinCustomer + whereCriteria
			+ "  :prevWeekStart AND :prevWeekEnd " + agentCondition + ") AS last_week, ";

	private String activeThisMonth = selectFromShipment + whereCriteria
			+ "  :thisMonthStart AND :thisMonthEnd ) AS this_month, ";

	private String activeThisMonthAgent = selectFromShipment + joinCustomer + whereCriteria
			+ "  :thisMonthStart AND :thisMonthEnd " + agentCondition + ") AS this_month, ";

	private String activeLastMonth = selectFromShipment + whereCriteria
			+ " :prevMonthStart AND :prevMonthEnd ) AS last_month";

	private String activeLastMonthAgent = selectFromShipment + joinCustomer + whereCriteria
			+ " :prevMonthStart AND :prevMonthEnd " + agentCondition + ") AS last_month";

	private String activeCustomerCounts = "SELECT " + activeToday + activeYesterDay + activeThisWeek + activeLastWeek
			+ activeThisMonth + activeLastMonth; */
	
	private String activeCustomerCounts1 = "select "
			+ "COUNT(DISTINCT(CASE WHEN created_datetime BETWEEN :todaStart AND :todayEnd THEN customer_id end)) as today,"
			+ "COUNT(DISTINCT(CASE WHEN created_datetime BETWEEN :yesterdayStart AND :yesterdayEnd THEN customer_id end)) as yesterday,"
			+ "COUNT(DISTINCT(CASE WHEN created_datetime BETWEEN :thisWeekStart AND :thisWeekEnd THEN customer_id end)) as lastweek,"
			+ "COUNT(DISTINCT(CASE WHEN created_datetime BETWEEN :prevWeekStart AND :prevWeekEnd THEN customer_id end)) as previousweek,"
			+ "COUNT(DISTINCT(CASE WHEN created_datetime BETWEEN :thisMonthStart AND :thisMonthEnd THEN customer_id end)) as thismonth,"
			+ "COUNT(DISTINCT(CASE WHEN created_datetime BETWEEN :prevMonthStart AND :prevMonthEnd THEN customer_id end)) as previousmonth "
			+ "FROM shipment "
			+ "WHERE created_datetime between :startDate AND :endDate AND active=1;";
	
	private String activeCustomerCountsAgent1 = "select "
			+ "COUNT(DISTINCT(CASE WHEN s.created_datetime BETWEEN :todaStart AND :todayEnd THEN customer_id end)) as today,"
			+ "COUNT(DISTINCT(CASE WHEN s.created_datetime BETWEEN :yesterdayStart AND :yesterdayEnd THEN customer_id end)) as yesterday,"
			+ "COUNT(DISTINCT(CASE WHEN s.created_datetime BETWEEN :thisWeekStart AND :thisWeekEnd THEN customer_id end)) as lastweek,"
			+ "COUNT(DISTINCT(CASE WHEN s.created_datetime BETWEEN :prevWeekStart AND :prevWeekEnd THEN customer_id end)) as previousweek,"
			+ "COUNT(DISTINCT(CASE WHEN s.created_datetime BETWEEN :thisMonthStart AND :thisMonthEnd THEN customer_id end)) as thismonth,"
			+ "COUNT(DISTINCT(CASE WHEN s.created_datetime BETWEEN :prevMonthStart AND :prevMonthEnd THEN customer_id end)) as previousmonth "
			+ "FROM shipment s join customer c on s.customer_id = c.id "
			+ "WHERE s.created_datetime between :startDate AND :endDate AND c.sales_rep = :agentName AND s.active=1;";
			

//	private String activeCustomerCountsAgent = "SELECT " + activeTodayAgent + activeYesterDayAgent + activeThisWeekAgent
//			+ activeLastWeekAgent + activeThisMonthAgent + activeLastMonthAgent;

	private String customersShippedInInterval = "SELECT c.business_name, MAX(s.created_datetime), "
			+ " COALESCE(c.sales_rep,'Not assigned') , s.customer_id FROM shipment s "
			+ "left JOIN customer c ON s.customer_id = c.id "
			+ "WHERE s.created_datetime  BETWEEN :from AND :to AND s.active=1 "
			+ "GROUP BY c.business_name, c.sales_rep " + "ORDER BY s.created_datetime desc;";

	private String customersShippedInIntervalForAgents = "SELECT c.business_name,MAX(s.created_datetime), "
			+ "COALESCE(c.sales_rep,'Not assigned'), s.customer_id FROM shipment s "
			+ "left JOIN customer c ON s.customer_id = c.id "
			+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1  AND c.sales_rep = :agentName "
			+ "GROUP BY c.business_name, c.sales_rep " + "ORDER BY s.created_datetime desc;";

	// new query for inactive customer

	private String inactiveCustomer2 = "SELECT c.business_name,c.email, COALESCE(c.phone,'-NA-') AS phone, COALESCE(c.sales_rep,'Not Assigned') AS salesRep, "
			+ "c.created_datetime,c.id, COALESCE(DATE_FORMAT(st.dt, \"%M %e %Y %H:%i\"),'Never Shipped') FROM customer c "
			+ "LEFT JOIN  "
			+ "	(SELECT s.customer_id AS id, MAX(s.created_datetime) AS dt FROM shipment s GROUP BY s.customer_id)  st ON c.id = st.id	"
			+ "WHERE st.dt <= DATE(NOW()) - INTERVAL :interval DAY OR  st.dt IS NULL ORDER BY c.created_datetime DESC; ";

	private String inactiveCustomerAgent2 = "SELECT c.business_name,c.email, COALESCE(c.phone,'-NA-') AS phone, COALESCE(c.sales_rep,'Not Assigned') AS salesRep, "
			+ "c.created_datetime,c.id, COALESCE(DATE_FORMAT(st.dt, \"%M %e %Y %H:%i\"),'Never Shipped') FROM customer c "
			+ "LEFT JOIN  "
			+ "	(SELECT s.customer_id AS id, MAX(s.created_datetime) AS dt FROM shipment s GROUP BY s.customer_id)  st ON c.id = st.id	"
			+ "WHERE (st.dt <= DATE(NOW()) - INTERVAL :interval DAY OR  st.dt IS NULL)  AND c.sales_rep = :agentName ORDER BY c.created_datetime DESC; ";

	// query for shipment cost (earnings) chart

	private String shipmentCostForDay = "SELECT DATE_FORMAT(s.created_datetime,'%d-%m-%Y %T') , COALESCE(o.shipping_cost,0) FROM shipment s "
			+ "left JOIN orders o ON s.order_id = o.id "
			+ "LEFT JOIN carrier c ON s.carrier_code=c.id "
			+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1 AND c.service_identifier ='CS';";

	private String shipmentCostBetweenDateRange = "SELECT date_value, SUM(cost) from "
			+ "(SELECT DATE_FORMAT(s.created_datetime,'%d-%m-%Y') as date_value, COALESCE(SUM( o.shipping_cost),0) as cost FROM shipment s "
			+ "left JOIN orders o ON s.order_id = o.id "
			+ "LEFT JOIN carrier c ON s.carrier_code=c.id " 
			+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1 AND c.service_identifier ='CS'"
			+ "GROUP BY DATE_FORMAT(s.created_datetime,'%d-%m-%Y') "
			+ "UNION "
			+ " SELECT DATE_FORMAT(s.created_datetime,'%d-%m-%Y') as date_value, COALESCE(SUM( o.shipping_cost),0) as cost FROM clickship_backup.shipment s "
			+ "left JOIN clickship_backup.orders o ON s.order_id = o.id "
			+ "LEFT JOIN clickship_backup.carrier c ON s.carrier_code=c.id " 
			+ "WHERE s.created_datetime BETWEEN :from AND :to  AND s.active=1 AND c.service_identifier ='CS'"
			+ "GROUP BY DATE_FORMAT(s.created_datetime,'%d-%m-%Y')) as T group by date_value; ";

	private String activeShippersCount = "SELECT count(DISTINCT(customer_id)) usersAct FROM shipment s  WHERE s.active=1 AND s.created_datetime BETWEEN :from AND :to ";
	private String activeShippersCountAgent = "SELECT count(DISTINCT(customer_id)) usersAct FROM shipment s  "
			+ joinCustomer + "  WHERE s.active=1 AND s.created_datetime BETWEEN :from AND :to " + agentCondition;

	private String shipmentsByMarketplace = "SELECT mto.name, COALESCE(a.cnt,0) " + 
			"FROM marketplace_type mto " + 
			"LEFT JOIN (" + 
			"SELECT mt.name AS name, COUNT(*) AS cnt " + 
			"FROM shipment s " + 
			"LEFT JOIN orders o ON s.order_id = o.id " + 
			"LEFT JOIN marketplace m ON o.marketplace_id = m.id " + 
			"LEFT JOIN marketplace_type mt ON m.marketplace_type_id = mt.id " + 
			"LEFT JOIN carrier cr ON s.carrier_code=cr.id " + 			 
			"WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1 and s.shipment_type = 'Store' AND " + 
			"m.marketplace_type_id IS NOT NULL AND cr.service_identifier = 'CS' " + 
			"GROUP BY mt.name) AS a ON mto.name = a.name " +
			"UNION " + 
			"select shipment_type, count(*) from shipment s LEFT JOIN carrier cr ON s.carrier_code = cr.id  " +
			"where s.shipment_type in ('Manual','Return') and s.active=1 AND cr.service_identifier = 'CS' " +
			"and s.created_datetime BETWEEN :from AND :to " +
			"group by shipment_type ";
	
	private String shipmentsByMarketplaceAgent = "SELECT mto.name, COALESCE(a.cnt,0) " + 
			"FROM marketplace_type mto " + 
			"LEFT JOIN (" + 
			"SELECT mt.name AS name, COUNT(*) AS cnt " + 
			"FROM shipment s " + 
			"LEFT JOIN orders o ON s.order_id = o.id " + 
			"LEFT JOIN marketplace m ON o.marketplace_id = m.id " + 
			"LEFT JOIN marketplace_type mt ON m.marketplace_type_id = mt.id " + 
			"LEFT JOIN carrier cr ON s.carrier_code=cr.id " + 
			joinCustomer +
			"WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1 AND s.shipment_type = 'Store' " + 
			"AND m.marketplace_type_id IS NOT NULL AND cr.service_identifier = 'CS' " + agentCondition + 
			"GROUP BY mt.name) AS a ON mto.name = a.name " + 
			"UNION " + 
			"select shipment_type, count(*) from shipment s LEFT JOIN carrier cr ON s.carrier_code=cr.id " +
			joinCustomer + " where s.shipment_type in ('Manual','Return') and s.active=1 AND cr.service_identifier = 'CS' " +
			"and s.created_datetime BETWEEN :from AND :to " + agentCondition +
			"group by s.shipment_type ";
	
	private String shipmentsByMarketplaceCustom = "SELECT type, COALESCE(SUM(counts),0) from (\r\n"
			+ "SELECT mto.name as type, COALESCE(a.cnt,0) as counts\r\n"
			+ "FROM marketplace_type mto  \r\n"
			+ "LEFT JOIN ( \r\n"
			+ "SELECT mt.name AS name, COUNT(*) AS cnt  \r\n"
			+ "FROM shipment s  \r\n"
			+ "LEFT JOIN orders o ON s.order_id = o.id  \r\n"
			+ "LEFT JOIN marketplace m ON o.marketplace_id = m.id  \r\n"
			+ "LEFT JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  \r\n"
			+ "LEFT JOIN carrier cr ON s.carrier_code=cr.id  \r\n"
			+ "WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1\r\n"
			+ "and s.shipment_type = 'Store' AND  \r\n"
			+ "m.marketplace_type_id IS NOT NULL AND cr.service_identifier = 'CS'  \r\n"
			+ "GROUP BY mt.name) AS a ON mto.name = a.name \r\n"
			+ "UNION select shipment_type as type, count(*) as counts from shipment s \r\n"
			+ "LEFT JOIN carrier cr ON s.carrier_code = cr.id  \r\n"
			+ "where s.shipment_type in ('Manual','Return') and s.active=1 AND cr.service_identifier = 'CS' \r\n"
			+ "and s.created_datetime BETWEEN :from AND :to \r\n"
			+ "group by shipment_type\r\n"
			+ "UNION\r\n"
			+ "SELECT mto.name as type, COALESCE(a.cnt,0) as counts\r\n"
			+ "FROM marketplace_type mto  \r\n"
			+ "LEFT JOIN ( \r\n"
			+ "SELECT mt.name AS name, COUNT(*) AS cnt  \r\n"
			+ "FROM clickship_backup.shipment s  \r\n"
			+ "LEFT JOIN clickship_backup.orders o ON s.order_id = o.id  \r\n"
			+ "LEFT JOIN marketplace m ON o.marketplace_id = m.id  \r\n"
			+ "LEFT JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  \r\n"
			+ "LEFT JOIN clickship_backup.carrier cr ON s.carrier_code=cr.id  \r\n"
			+ "WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1\r\n"
			+ "and s.shipment_type = 'Store' AND  \r\n"
			+ "m.marketplace_type_id IS NOT NULL AND cr.service_identifier = 'CS'  \r\n"
			+ "GROUP BY mt.name) AS a ON mto.name = a.name \r\n"
			+ "UNION select shipment_type as type, count(*) as counts from clickship_backup.shipment s \r\n"
			+ "LEFT JOIN clickship_backup.carrier cr ON s.carrier_code = cr.id  \r\n"
			+ "where s.shipment_type in ('Manual','Return') and s.active=1 AND cr.service_identifier = 'CS' \r\n"
			+ "and s.created_datetime BETWEEN :from AND :to \r\n"
			+ "group by shipment_type) as T group by type;";
	
	private String shipmentsByMarketplaceAgentCustom = "SELECT type, COALESCE(SUM(counts),0) from (\r\n"
			+ "SELECT mto.name as type, COALESCE(a.cnt,0) as counts\r\n"
			+ "FROM marketplace_type mto  \r\n"
			+ "LEFT JOIN ( \r\n"
			+ "SELECT mt.name AS name, COUNT(*) AS cnt  \r\n"
			+ "FROM shipment s  \r\n"
			+ "LEFT JOIN orders o ON s.order_id = o.id  \r\n"
			+ "LEFT JOIN marketplace m ON o.marketplace_id = m.id  \r\n"
			+ "LEFT JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  \r\n"
			+ "LEFT JOIN carrier cr ON s.carrier_code=cr.id  \r\n"
			+ joinCustomer 
			+ "WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1\r\n"
			+ "and s.shipment_type = 'Store' AND  \r\n"
			+ "m.marketplace_type_id IS NOT NULL AND cr.service_identifier = 'CS' " + agentCondition
			+ "GROUP BY mt.name) AS a ON mto.name = a.name \r\n"
			+ "UNION select shipment_type as type, count(*) as counts from shipment s \r\n"
			+ "LEFT JOIN carrier cr ON s.carrier_code = cr.id  \r\n"
			+ joinCustomer 
			+ "where s.shipment_type in ('Manual','Return') and s.active=1 AND cr.service_identifier = 'CS' " + agentCondition 
			+ "and s.created_datetime BETWEEN :from AND :to \r\n"
			+ "group by shipment_type\r\n"
			+ "UNION\r\n"
			+ "SELECT mto.name as type, COALESCE(a.cnt,0) as counts\r\n"
			+ "FROM marketplace_type mto  \r\n"
			+ "LEFT JOIN ( \r\n"
			+ "SELECT mt.name AS name, COUNT(*) AS cnt  \r\n"
			+ "FROM clickship_backup.shipment s  \r\n"
			+ "LEFT JOIN clickship_backup.orders o ON s.order_id = o.id  \r\n"
			+ "LEFT JOIN marketplace m ON o.marketplace_id = m.id  \r\n"
			+ "LEFT JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  \r\n"
			+ "LEFT JOIN clickship_backup.carrier cr ON s.carrier_code=cr.id  \r\n"
			+ joinBackupCustomer 
			+ "WHERE s.created_datetime BETWEEN :from AND :to AND s.active=1\r\n"
			+ "and s.shipment_type = 'Store' AND  \r\n"
			+ "m.marketplace_type_id IS NOT NULL AND cr.service_identifier = 'CS'  "+ agentCondition
			+ "GROUP BY mt.name) AS a ON mto.name = a.name \r\n"
			+ "UNION select shipment_type as type, count(*) as counts from clickship_backup.shipment s \r\n"
			+ "LEFT JOIN clickship_backup.carrier cr ON s.carrier_code = cr.id  \r\n"
			+ joinBackupCustomer 
			+ "where s.shipment_type in ('Manual','Return') and s.active=1 AND cr.service_identifier = 'CS' "+ agentCondition
			+ "and s.created_datetime BETWEEN :from AND :to \r\n"
			+ "group by shipment_type) as T group by type;";	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByWeekDTO> getShipmentsCountByWeek(String from1, String to1, String from2, String to2,
			String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(shipmentCountInWeek);
		} else {
			query = em.createNativeQuery(shipmentCountWeekWithAgentCondition);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from1", from1);
		query.setParameter("from2", from2);
		query.setParameter("to1", to1);
		query.setParameter("to2", to2);

		List<Object[]> list = (List<Object[]>) query.getResultList();

		return list.stream().map(o -> {
			return new ShipmentsCountByWeekDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByMonthDTO> getShipmentsCountByMonth(String from1, String to1, String from2, String to2,
			String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(shipmentCountInWeek);
		} else {
			query = em.createNativeQuery(shipmentCountWeekWithAgentCondition);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from1", from1);
		query.setParameter("from2", from2);
		query.setParameter("to1", to1);
		query.setParameter("to2", to2);
		List<Object[]> list = (List<Object[]>) query.getResultList();

		return list.stream().map(o -> {
			return new ShipmentsCountByMonthDTO(o);
		}).collect(Collectors.toList());
	}
	
	@Override
	public int getShipmentsCountByDateRange(String from, String to, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(shipmentByDateRange);
		} else {
			query = em.createNativeQuery(shipmentByDateRangeForAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		return ((Long)query.getSingleResult()).intValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByDayDTO> getOCShipmentsCountByDay(String from, String to, String agentName) {

		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(OCShipmentsByDay);
		} else {
			query = em.createNativeQuery(OCShipmentsByDaySalesAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ShipmentsCountByDayDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByWeekDTO> getOCShipmentsCountByWeek(String from1, String to1, String from2, String to2,
			String agentName) {

		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(OCShipmentCountByWeekOrMonth);
		} else {
			query = em.createNativeQuery(OCShipmentCountByWeekOrMonthSalesAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from1", from1);
		query.setParameter("from2", from2);
		query.setParameter("to1", to1);
		query.setParameter("to2", to2);
		List<Object[]> list = (List<Object[]>) query.getResultList();

		return list.stream().map(o -> {
			return new ShipmentsCountByWeekDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByMonthDTO> getOCShipmentsCountByMonth(String from1, String to1, String from2, String to2,
			String agentName) {

		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(OCShipmentCountByWeekOrMonth);
		} else {
			query = em.createNativeQuery(OCShipmentCountByWeekOrMonthSalesAgent);
			query.setParameter("agentName", agentName);
		}

		query.setParameter("from1", from1);
		query.setParameter("from2", from2);
		query.setParameter("to1", to1);
		query.setParameter("to2", to2);

		List<Object[]> list = (List<Object[]>) query.getResultList();

		return list.stream().map(o -> {
			return new ShipmentsCountByMonthDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByYearDTO> getOCShipmentsCountByYear(String from1, String to1,String from2, String to2, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(OCShipmentByYear);
		} else {
			query = em.createNativeQuery(OCShipmentByYearSalesAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from1);
//		query.setParameter("to1", to1);
//		query.setParameter("from2", from2);
		query.setParameter("to", to2);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ShipmentsCountByYearDTO(o);
		}).collect(Collectors.toList());
	}
	
	@Override
	public int getOCShipmentsCountByDateRange(String from, String to, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(OCShipmentByDateRange);
		} else {
			query = em.createNativeQuery(OCShipmentByDateRangeForAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		return ((Long)query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarriersDTO> getCarriersByDay(String from, String to, String agentName, String type) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(carriersByDay);
		} else {
			query = em.createNativeQuery(carriersByDayWithAgetCond);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("type", type);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new CarriersDTO(o);
		}).collect(Collectors.toList());
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<CarriersDTO> getOwnCarriersByDay(String from, String to, String agentName) {
//		Query query = null;
//		if (agentName == null || agentName.length() == 0) {
//			query = em.createNativeQuery(ownCarriersByDay);
//		} else {
//			query = em.createNativeQuery(ownCarriersByDayWithAgetCond);
//			query.setParameter("agentName", agentName);
//		}
//		query.setParameter("from", from);
//		query.setParameter("to", to);
//		List<Object[]> list = (List<Object[]>) query.getResultList();
//		return list.stream().map(o -> {
//			return new CarriersDTO(o);
//		}).collect(Collectors.toList());
//	}
//	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarriersDTO> getCarriersByCustomDateRange(String from, String to, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(carriersByCustomDateRange);
		} else {
			query = em.createNativeQuery(carriersByCustomDateRangeForAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new CarriersDTO(o[0],o[1]);
		}).collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarriersDTO> getCarriersBetweenDays(String from, String to, String agentName, String type) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(carriersBetweenDays);
		} else {
			query = em.createNativeQuery(carriersBetweenDaysSalesAgent);
			query.setParameter("agentName", agentName);
		}

		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("type", type);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new CarriersDTO(o);
		}).collect(Collectors.toList());
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<CarriersDTO> getOwnCarriersBetweenDays(String from, String to, String agentName) {
//		Query query = null;
//		if (agentName == null || agentName.length() == 0) {
//			query = em.createNativeQuery(carriersBetweenDays);
//		} else {
//			query = em.createNativeQuery(carriersBetweenDaysSalesAgent);
//			query.setParameter("agentName", agentName);
//		}
//
//		query.setParameter("from", from);
//		query.setParameter("to", to);
//		List<Object[]> list = (List<Object[]>) query.getResultList();
//		return list.stream().map(o -> {
//			return new CarriersDTO(o);
//		}).collect(Collectors.toList());
//	}

	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ShipmentTrackingDTO> getOrdersDataForTable(String from, String to, String agentName,
			String businessName) {

		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(ordersShippedBetweenDates);
		} else {
			query = em.createNativeQuery(ordersBetweenDatesSalesAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("customer", "%" + businessName);
		List<Object[]> list = (List<Object[]>) query.getResultList();

		return list.stream().map(o -> {
			return new ShipmentTrackingDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	public ActiveCustomerCountsDTO getActiveCustomerCountsByShipments(String agentName) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-d");
		String startTime = "  00:00:00";
		String endTime = "  23:59:59";

		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(activeCustomerCounts1);
		} else {
			query = em.createNativeQuery(activeCustomerCountsAgent1);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("todaStart", date.format(dateFormat) + startTime);
		query.setParameter("todayEnd", date.format(dateFormat) + endTime);

		query.setParameter("yesterdayStart", date.minusDays(1).format(dateFormat) + startTime);
		query.setParameter("yesterdayEnd", date.minusDays(1).format(dateFormat) + endTime);

		query.setParameter("thisWeekStart", date.minusDays(6).format(dateFormat) + startTime);
		query.setParameter("thisWeekEnd", date.format(dateFormat) + endTime);

		query.setParameter("prevWeekStart", date.minusDays(13).format(dateFormat) + startTime);
		query.setParameter("prevWeekEnd", date.minusDays(7).format(dateFormat) + endTime);

		query.setParameter("thisMonthStart", date.minusDays(30).format(dateFormat) + startTime);
		query.setParameter("thisMonthEnd", date.format(dateFormat) + endTime);

		query.setParameter("prevMonthStart", date.minusMonths(2).format(dateFormat) + startTime);
		query.setParameter("prevMonthEnd", date.minusMonths(1).format(dateFormat) + endTime);
		
		query.setParameter("startDate", date.minusMonths(2).format(dateFormat) + startTime);
		query.setParameter("endDate", date.format(dateFormat) + endTime);
		
		Object[] list = (Object[]) query.getResultList().get(0);

		return new ActiveCustomerCountsDTO(list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabelProcessedTableDTO> getLabelProcessedDataForTable(String from, String to, String agentName,
			String businessName) {

		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(labelsProcessedBetweenDates);
		} else {
			query = em.createNativeQuery(labelsProcessedBetweenDatesSalesAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("customer", "%" + businessName);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new LabelProcessedTableDTO(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentsCountByDayDTO> getShipmentsCountByDayAndHour(String from, String to, String agentName) {

		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(shipmentByDay);
		} else {
			query = em.createNativeQuery(shipmentByDayForAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ShipmentsCountByDayDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	public ShipmentTypeCountDTO getAllShipmentTypesCountByDateRange(String from, String to, String agentName, String serviceType) {

		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(bulkShippingCountByDateRange);
		} else {
			query = em.createNativeQuery(bulkShippingCountByDateRangeWithAgentCondition);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("serviceType", serviceType);

		ShipmentTypeCountDTO shipmentTypeCountDTO = new ShipmentTypeCountDTO();
		shipmentTypeCountDTO.setBulkShipmentCounts(Integer.parseInt(((BigInteger) query.getResultList().get(0)).toString()));

		if(serviceType.equalsIgnoreCase("CS")) {
			Query v1v2Query = null;
			if (agentName == null || agentName.length() == 0) {
				v1v2Query = em.createNativeQuery(shipmentv1v2Counts);
			} else {
				v1v2Query = em.createNativeQuery(shipmentv1v2CountsByAgent);
				v1v2Query.setParameter("agentName", agentName);
			}
			v1v2Query.setParameter("from", from);
			v1v2Query.setParameter("to", to);

			@SuppressWarnings("unchecked")
			List<Object[]> list = (List<Object[]>) v1v2Query.getResultList();
			BigDecimal v2Counts = (BigDecimal)list.get(0)[0];
			BigDecimal v1Counts = (BigDecimal)list.get(0)[1];
			shipmentTypeCountDTO.setV2ShipmentCounts(v2Counts.intValue());
			shipmentTypeCountDTO.setV1ShipmentCounts(v1Counts.intValue());
		}
		return shipmentTypeCountDTO;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentsCountByDayDTO> getExternalOrdersCountByDayAndHour(String from, String to, String agentName) {

		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(externalOrdersByDay);
		} else {
			query = em.createNativeQuery(externalOrdersByDayForAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ShipmentsCountByDayDTO(o);
		}).collect(Collectors.toList());
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByWeekDTO> getExternalOrdersCountByWeek(String from1, String to1, String from2, String to2,
			String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(externalOrdersCountInWeek);
		} else {
			query = em.createNativeQuery(externalOrdersCountWeekWithAgentCondition);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from1", from1);
		query.setParameter("from2", from2);
		query.setParameter("to1", to1);
		query.setParameter("to2", to2);

		List<Object[]> list = (List<Object[]>) query.getResultList();

		return list.stream().map(o -> {
			return new ShipmentsCountByWeekDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByMonthDTO> getExternalOrdersCountByMonth(String from1, String to1, String from2, String to2,
			String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(externalOrdersCountInWeek);
		} else {
			query = em.createNativeQuery(externalOrdersCountWeekWithAgentCondition);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from1", from1);
		query.setParameter("from2", from2);
		query.setParameter("to1", to1);
		query.setParameter("to2", to2);
		List<Object[]> list = (List<Object[]>) query.getResultList();

		return list.stream().map(o -> {
			return new ShipmentsCountByMonthDTO(o);
		}).collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByYearDTO> getExternalOrdersCountByYear(String from1, String to1,String from2, String to2, String agentName) {

		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(externalOrdersByYear);
		} else {
			query = em.createNativeQuery(externalOrdersByYearForAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from1);
//		query.setParameter("from2", from2);
		query.setParameter("to", to2);
//		query.setParameter("to2", to2);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ShipmentsCountByYearDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	public int getExternalOrdersDateRange(String from, String to, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(externalOrdersByDateRange);
		} else {
			query = em.createNativeQuery(externalOrdersByDateRangeWithAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		Object result = query.getSingleResult();
		if(result instanceof BigDecimal) {
			return ((Long)query.getSingleResult()).intValue();
		}else {
			return ((Long)query.getSingleResult()).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ShipmentsCountByYearDTO> getShipmentsCountByYear(String from1, String to1,String from2, String to2, String agentName) {

		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(shipmentByYear);
		} else {
			query = em.createNativeQuery(shipmentByYearForAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from1);
//		query.setParameter("from2", from2);
//		query.setParameter("to1", to1);
		query.setParameter("to", to2);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ShipmentsCountByYearDTO(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiveCustomerTableDto> getActiveCustomers(String agentName, String from,String  to) {
		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(customersShippedInInterval);
		} else {
			query = em.createNativeQuery(customersShippedInIntervalForAgents);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ActiveCustomerTableDto(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InActiveCustomerTableDto> getInActiveCustomers(String agentName, Integer interval) {
		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(inactiveCustomer2);
		} else {
			query = em.createNativeQuery(inactiveCustomerAgent2);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("interval", interval);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new InActiveCustomerTableDto(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentsEarningsDTO> getShipmentCostForDay(String from, String to) {
		Query query = em.createNativeQuery(shipmentCostForDay);
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ShipmentsEarningsDTO(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentsEarningsDTO> getShipmentCostBetweenDateRange(String from, String to) {
		Query query = em.createNativeQuery(shipmentCostBetweenDateRange);
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new ShipmentsEarningsDTO(o);
		}).collect(Collectors.toList());
	}

	@Override
	public Integer getActiveCustomerCountsByShipmentsInDateRange(String from, String to, String agentName) {
		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(activeShippersCount);
		} else {
			query = em.createNativeQuery(activeShippersCountAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);

		return Integer.parseInt(((BigInteger) query.getResultList().get(0)).toString());

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String[]> getShipmentsByMarketplace(String from, String to, String agentName, String type) {
		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			if(type.equals("Custom")) {
				query = em.createNativeQuery(shipmentsByMarketplaceCustom);
			}else {
				query = em.createNativeQuery(shipmentsByMarketplace);
			}
		} else {
			if(type.equals("Custom")) {
				query = em.createNativeQuery(shipmentsByMarketplaceAgentCustom);
			}else {
				query = em.createNativeQuery(shipmentsByMarketplaceAgent);
			}
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new String[] {o[0].toString(),o[1].toString()};
		}).collect(Collectors.toList());		
	}
	
}