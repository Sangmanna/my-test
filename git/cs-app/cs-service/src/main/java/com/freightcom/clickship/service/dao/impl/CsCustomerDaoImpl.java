package com.freightcom.clickship.service.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.model.admin.dashboard.NewSignedUpCustomerDto;
import com.freightcom.clickship.model.admin.dashboard.NewSignedUpCustomersCountsDto;
import com.freightcom.clickship.model.admin.dashboard.TopCustomersDto;
import com.freightcom.clickship.service.dao.CsCustomerDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CsCustomerDaoImpl implements CsCustomerDao {
	
	private Logger logger = LogManager.getLogger(CsCustomerDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	private static final String newSignedUpCustomers = "SELECT DISTINCT c.business_name, c.created_datetime, c.sub_tier, c.store_preference, c.fc_billing_type,  "
			+ " (SELECT COUNT(*) FROM shipment WHERE shipment.customer_id = c.id) AS shipments, (SELECT max(created_datetime) FROM shipment WHERE shipment.customer_id = c.id) AS LAST_shipped, "
			+ " c.is_inactivity_mail_sent, c.is_disabled_mail_sent, u.last_login,c.active " + "FROM customer c "
			+ "LEFT JOIN shipment s ON c.id = s.customer_id " + "LEFT JOIN user u ON c.id = u.customer_id "
			+ "WHERE c.created_datetime BETWEEN :from AND :to " + "ORDER BY c.created_datetime ";

	private static final String newSignedUpCustomersForAgents = "SELECT DISTINCT c.business_name, c.created_datetime, c.sub_tier, c.store_preference, c.fc_billing_type, "
			+ "(SELECT COUNT(*) FROM shipment WHERE shipment.customer_id = c.id   )  AS shipments, (SELECT max(created_datetime) FROM shipment WHERE shipment.customer_id = c.id) AS LAST_shipped, "
			+ " c.is_inactivity_mail_sent, c.is_disabled_mail_sent, u.last_login,c.active " + " FROM customer c "
			+ "LEFT JOIN shipment s ON c.id = s.customer_id " + "LEFT JOIN user u ON c.id = u.customer_id "
			+ "WHERE c.created_datetime  BETWEEN :from AND :to AND c.sales_rep = :agentName  "
			+ "ORDER BY c.created_datetime ";

	private static final String newSignedUpCustomersChart = "SELECT COUNT(*), DATE_FORMAT(created_datetime ,\"%d-%m-%Y\") AS joindate "
			+ "FROM customer " + "WHERE  created_datetime  BETWEEN :from AND :to "
			+ "GROUP BY DATE_FORMAT(created_datetime ,\"%d-%m-%Y\") ORDER BY DATE_FORMAT(created_datetime ,\"%d-%m-%Y\") desc ";

	private static final String newSignedUpCustomersChartForAgents = "SELECT COUNT(*), DATE_FORMAT(created_datetime ,\"%d-%m-%Y\") AS joindate "
			+ "FROM customer " + "WHERE  created_datetime BETWEEN :from AND :to AND sales_rep = :agentName  "
			+ "GROUP BY DATE_FORMAT(created_datetime ,\"%d-%m-%Y\") ORDER BY DATE_FORMAT(created_datetime ,\"%d-%m-%Y\") desc ";

	private static final String allBusinessNames = "SELECT business_name FROM customer UNION SELECT email FROM customer UNION SELECT username FROM user";

	private static final String allBusinessNamesByAgent = "SELECT business_name FROM customer WHERE sales_rep in "
			+ "(select sale_associate_name from cs_admin.salesrep_mapping where sales_lead_name=:agentName "
			+ "UNION select sales_lead_name from cs_admin.salesrep_mapping where sales_lead_name=:agentName UNION select :agentName) "
			+ "UNION SELECT email FROM customer WHERE sales_rep in (select sale_associate_name from "
			+ "cs_admin.salesrep_mapping where sales_lead_name=:agentName "
			+ "UNION select sales_lead_name from cs_admin.salesrep_mapping where "
			+ "sales_lead_name=:agentName UNION select :agentName) "
			+ "UNION SELECT username FROM user u, customer c WHERE u.customer_id = c.id and sales_rep in (select sale_associate_name from "
			+ "cs_admin.salesrep_mapping where sales_lead_name=:agentName "
			+ "UNION select sales_lead_name from cs_admin.salesrep_mapping where "
			+ "sales_lead_name=:agentName UNION select :agentName) ";

	private static final String SOME_BUSINESS_NAMES = 
		"SELECT business_name FROM customer " + 
		"WHERE business_name LIKE :businessName " + 
		"UNION " + 
		"SELECT email FROM customer " + 
		"WHERE email LIKE :businessName " + 
		"UNION " + 
		"SELECT username FROM user " + 
		"WHERE username LIKE :businessName";

	private static final String SOME_BUSINESS_NAME_BY_AGENT = 
		"SELECT business_name FROM customer WHERE sales_rep in "
		+ "(select sale_associate_name from cs_admin.salesrep_mapping where sales_lead_name=:agentName "
		+ "UNION select sales_lead_name from cs_admin.salesrep_mapping where sales_lead_name=:agentName UNION select :agentName) "
		+ "AND business_name LIKE :businessName "
		+ "UNION SELECT email FROM customer WHERE sales_rep in (select sale_associate_name from "
		+ "cs_admin.salesrep_mapping where sales_lead_name=:agentName "
		+ "UNION select sales_lead_name from cs_admin.salesrep_mapping where "
		+ "sales_lead_name=:agentName UNION select :agentName) AND email LIKE :businessName "
		+ "UNION SELECT username FROM user u, customer c WHERE u.customer_id = c.id and sales_rep in (select sale_associate_name from "
		+ "cs_admin.salesrep_mapping where sales_lead_name=:agentName "
		+ "UNION select sales_lead_name from cs_admin.salesrep_mapping where "
		+ "sales_lead_name=:agentName UNION select :agentName) AND username LIKE :businessName ";

	private static final String topCustomersByRevenue = "SELECT c.business_name, c.created_datetime,COUNT(s.id), ROUND(SUM(COALESCE(o.shipping_cost,0)),2) AS revenue,COALESCE(c.sales_rep, 'Not Assigned') AS salesRep, c.id "
			+ "  FROM shipment s " + "LEFT JOIN orders o ON s.order_id = o.id "
			+ "LEFT JOIN customer c ON s.customer_id = c.id " + "JOIN carrier cr ON s.carrier_code=cr.id "
			+ "WHERE s.created_datetime " + "BETWEEN :from AND :to AND s.active=1 AND cr.service_identifier = 'CS' "
			+ "GROUP BY c.business_name " + "ORDER BY revenue desc limit :limit";

	private static final String topCustomersByRevenueAgent = "SELECT c.business_name, c.created_datetime,COUNT(s.id), ROUND(SUM(COALESCE(o.shipping_cost,0)),2) AS revenue, COALESCE(c.sales_rep, 'Not Assigned') AS salesRep, c.id"
			+ "  FROM shipment s " + "LEFT JOIN orders o ON s.order_id = o.id "
			+ "LEFT JOIN customer c ON s.customer_id = c.id " + "JOIN carrier cr ON s.carrier_code=cr.id "
			+ "WHERE s.created_datetime "
			+ "BETWEEN :from AND :to  AND s.active=1 AND cr.service_identifier = 'CS' AND c.sales_rep = :agentName "
			+ "GROUP BY c.business_name " + "ORDER BY revenue desc limit :limit";

	private static final String topCustomersByVolume = "SELECT c.business_name, c.created_datetime,COUNT(s.id) as shipments, ROUND(SUM(COALESCE(o.shipping_cost,0)),2) AS revenue, COALESCE(c.sales_rep, 'Not Assigned') AS salesRep, c.id "
			+ "  FROM shipment s " + "LEFT JOIN orders o ON s.order_id = o.id "
			+ "LEFT JOIN customer c ON s.customer_id = c.id " + "JOIN carrier cr ON s.carrier_code=cr.id "
			+ "WHERE s.created_datetime " + "BETWEEN :from AND :to AND s.active=1 AND cr.service_identifier = 'CS' "
			+ "GROUP BY c.business_name " + "ORDER BY shipments desc limit :limit";

	private static final String topCustomersByVolumeAgent = "SELECT c.business_name, c.created_datetime,COUNT(s.id) as shipments, ROUND(SUM(COALESCE(o.shipping_cost,0)),2) AS revenue, COALESCE(c.sales_rep, 'Not Assigned') AS salesRep , c.id"
			+ "  FROM shipment s " + "LEFT JOIN orders o ON s.order_id = o.id "
			+ "LEFT JOIN customer c ON s.customer_id = c.id " + "JOIN carrier cr ON s.carrier_code=cr.id "
			+ "WHERE s.created_datetime "
			+ "BETWEEN :from AND :to  AND s.active=1 AND cr.service_identifier = 'CS' AND c.sales_rep = :agentName "
			+ "GROUP BY c.business_name " + "ORDER BY shipments desc limit :limit";

	/**
	 * This method retrieves all the customer who signed up in given time range
	 * 
	 * @param range
	 * @param agentName
	 * @return list of customers
	 */
	@SuppressWarnings("unchecked")
	public List<NewSignedUpCustomerDto> newSignedUpCustomers(String from, String to, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = entityManager.createNativeQuery(newSignedUpCustomers);
		} else {
			query = entityManager.createNativeQuery(newSignedUpCustomersForAgents);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new NewSignedUpCustomerDto(o);
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<NewSignedUpCustomersCountsDto> newSignedUpCustomersCounts(String from, String to, String agentName) {

		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = entityManager.createNativeQuery(newSignedUpCustomersChart);
		} else {
			query = entityManager.createNativeQuery(newSignedUpCustomersChartForAgents);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new NewSignedUpCustomersCountsDto(o);
		}).collect(Collectors.toList());
	}

	@Override
	public List<String> getAllBusinessNames(String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = entityManager.createNativeQuery(allBusinessNames);
		} else {
			query = entityManager.createNativeQuery(allBusinessNamesByAgent);
			query.setParameter("agentName", agentName);
		}
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) query.getResultList();

		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TopCustomersDto> getTopCustomersByRevenue(String from, String to, Integer limit, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = entityManager.createNativeQuery(topCustomersByRevenue);
		} else {
			query = entityManager.createNativeQuery(topCustomersByRevenueAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("limit", limit);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new TopCustomersDto(o);
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TopCustomersDto> getTopCustomersByVolume(String from, String to, Integer limit, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = entityManager.createNativeQuery(topCustomersByVolume);
		} else {
			query = entityManager.createNativeQuery(topCustomersByVolumeAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("limit", limit);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			try {
				return new TopCustomersDto(o);
			} catch (Exception e) {
				logger.error("Error", e);
				return null;
			}
		}).collect(Collectors.toList());
	}

	@Override
	public List<String> searchCutomers(String agentName, String businessName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = entityManager.createNativeQuery(SOME_BUSINESS_NAMES);
			query.setParameter("businessName", "%" + businessName + "%");
		} else {
			query = entityManager.createNativeQuery(SOME_BUSINESS_NAME_BY_AGENT);
			query.setParameter("agentName", agentName);
			query.setParameter("businessName", "%" + businessName + "%");
		}
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) query.getResultList();

		return list;
	}
}
