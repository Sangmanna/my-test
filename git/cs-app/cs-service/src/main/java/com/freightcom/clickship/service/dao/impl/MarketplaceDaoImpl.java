package com.freightcom.clickship.service.dao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.model.admin.dashboard.stores.MarketplaceTableDTO;
import com.freightcom.clickship.model.admin.dashboard.stores.StoreCountsByWeekOrMonth;
import com.freightcom.clickship.service.dao.MarketplaceDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class MarketplaceDaoImpl implements MarketplaceDao {

	@PersistenceContext
	private EntityManager em;
	
	@Value("${delete.markerplace.store.proc}")
	private String deleteMarketplaceStoreProcedure;

	private String agentCondition = " AND cs.sales_rep = :agentName ";
	private String joinCustomer = " JOIN customer cs ON m.customer_id = cs.id ";

	private String StoreCountsDay = "SELECT DATE_FORMAT(m.created_datetime, \"%d-%m-%Y %H\") as DAY,  mt.name AS store, COUNT(mt.name) AS count  "
			+ "FROM marketplace m " + "JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  "
			+ "WHERE m.integration_success =1 AND (m.created_datetime) BETWEEN :from AND :to "
			+ "GROUP BY DAY,store ORDER BY DAY,store;";
	
	private String StoreCountsDayAgent = "SELECT DATE_FORMAT(m.created_datetime, \"%d-%m-%Y %H\") as DAY,  mt.name AS store, COUNT(mt.name) AS count  "
			+ "FROM marketplace m " 
			+ "JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  "
			+joinCustomer
			+ "WHERE m.integration_success =1 AND (m.created_datetime) BETWEEN :from AND :to "+agentCondition
			+ "GROUP BY DAY,store ORDER BY DAY,store;";

	private String StoreCountsWeek = "SELECT DATE_FORMAT(m.created_datetime, \"%d-%m-%Y\") as DAY,  mt.name AS store, COUNT(mt.name) AS count  "
			+ "FROM marketplace m " + "JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  "
			+ "WHERE m.integration_success =1 AND (m.created_datetime) BETWEEN :from AND :to "
			+ "GROUP BY DAY,store ORDER BY DAY,store;";

	private String StoreCountsWeekSalesAgent = "SELECT DATE_FORMAT(m.created_datetime, \"%d-%m-%Y\") as DAY,  mt.name AS store, COUNT(mt.name) AS count  "
			+ "FROM marketplace m " + "JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  " + joinCustomer
			+ "WHERE m.integration_success =1 AND (m.created_datetime) BETWEEN :from AND :to " + agentCondition
			+ "GROUP BY DAY,store ORDER BY DAY,store;";
	
	private String StoreCountsByDateRange = "SELECT mt.name AS store, COUNT(mt.name) AS count  "
			+ "FROM marketplace m " + "JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  "
			+ "WHERE m.integration_success =1 AND (m.created_datetime) BETWEEN :from AND :to "
			+ "GROUP BY store;";
	
	private String StoreCountsByDateRangeForAgent = "SELECT mt.name AS store, COUNT(mt.name) AS count  "
			+ "FROM marketplace m " 
			+ "JOIN marketplace_type mt ON m.marketplace_type_id = mt.id  "
			+joinCustomer
			+ "WHERE m.integration_success =1 AND (m.created_datetime) BETWEEN :from AND :to "+agentCondition
			+ "GROUP BY store;";

	private String marketplaceTableSalesAgent = "SELECT COALESCE(cs.business_name,'NA') AS bname, COALESCE(mt.name,'Manual Shipment') AS store,COUNT(*) "
			+ " FROM marketplace m " + " LEFT JOIN customer cs ON m.customer_id=cs.id "
			+ " LEFT JOIN marketplace_type mt ON mt.id = m.marketplace_type_id "
			+ " WHERE m.integration_success =1 and m.created_datetime BETWEEN :from AND :to " + agentCondition + " GROUP BY bname,store";

	private String marketplaceTable = "SELECT  COALESCE(cs.business_name,'NA')   AS bname, COALESCE(mt.name,'Manual Shipment') AS store,COUNT(*) "
			+ " FROM marketplace m " + " LEFT JOIN customer cs ON m.customer_id=cs.id "
			+ " LEFT JOIN marketplace_type mt ON mt.id = m.marketplace_type_id "
			+ " WHERE m.integration_success =1 AND m.created_datetime BETWEEN :from AND :to  GROUP BY bname,store";
	
	private String marketplaceTypeCounts = "SELECT mt.name, COUNT(*) " + 
			" FROM marketplace m " + 
			" JOIN marketplace_type mt ON m.marketplace_type_id = mt.id " + 
			" WHERE m.created_datetime BETWEEN :from AND :to AND m.integration_success =1 " + 
			" GROUP BY m.marketplace_type_id";
	
	private String marketplaceTypeCountsByAgent = "SELECT mt.name, COUNT(*) " + 
			" FROM marketplace m  JOIN customer cs ON m.customer_id=cs.id "+
			" JOIN marketplace_type mt ON m.marketplace_type_id = mt.id " + 
			" WHERE m.created_datetime BETWEEN :from AND :to " + agentCondition + "  AND m.integration_success =1 " + 
			" GROUP BY m.marketplace_type_id";
	
	@Override
	@Transactional
	public void deleteMarketplace(String marketplaceId) {
		
		StoredProcedureQuery storedProcedureQuery = this.em.createStoredProcedureQuery(deleteMarketplaceStoreProcedure);
		storedProcedureQuery.registerStoredProcedureParameter("marketplaceId", String.class, ParameterMode.IN);
		
		storedProcedureQuery.setParameter("marketplaceId", marketplaceId);
		
		storedProcedureQuery.execute();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreCountsByWeekOrMonth> getStoresIntegratedInDay(String from, String to, String agentName) {

		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(StoreCountsDay);
		} else {
			query = em.createNativeQuery(StoreCountsDayAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new StoreCountsByWeekOrMonth(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreCountsByWeekOrMonth> getStoresIntegratedInWeekOrMonth(String from, String to, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(StoreCountsWeek);
		} else {
			query = em.createNativeQuery(StoreCountsWeekSalesAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new StoreCountsByWeekOrMonth(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreCountsByWeekOrMonth> getStoresIntegratedInSixMonths(String from, String to, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(StoreCountsWeek);
		} else {
			query = em.createNativeQuery(StoreCountsWeekSalesAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		query = setSalesRepCondition(query, agentName);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new StoreCountsByWeekOrMonth(o);
		}).collect(Collectors.toList());

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreCountsByWeekOrMonth> getStoresIntegratedByDateRange(String from, String to, String agentName) {
		Query query = null;
		if (agentName == null || agentName.length() == 0) {
			query = em.createNativeQuery(StoreCountsByDateRange);
		} else {
			query = em.createNativeQuery(StoreCountsByDateRangeForAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);
		
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new StoreCountsByWeekOrMonth(o[0],o[1]);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MarketplaceTableDTO> getMarketplaceTables(String from, String to, String agentName) {
		Query query = null;
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(marketplaceTable);
		} else {
			query = em.createNativeQuery(marketplaceTableSalesAgent);
			query.setParameter("agentName", agentName);
		}
		query.setParameter("from", from);
		query.setParameter("to", to);

		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new MarketplaceTableDTO(o);
		}).collect(Collectors.toList());
	}

	private Query setSalesRepCondition(Query query, String agentName) {
		if (agentName == null || agentName.length() == 0) {
			agentCondition = " ";
		} else {
			joinCustomer = " JOIN customer cs ON m.customer_id = cs.id ";
			agentCondition = " AND cs.sales_rep = :agentName ";
			query.setParameter("agentName", agentName);
		}
		return query;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<List<String>> getCountsByMarketplaceType(String from, String to, String agentName) {
		Query query = null;
		
		if (agentName.length() == 0 || agentName == null) {
			query = em.createNativeQuery(marketplaceTypeCounts);
		} else {
			query = em.createNativeQuery(marketplaceTypeCountsByAgent);
			query.setParameter("agentName", agentName);
		}
		
		query.setParameter("from", from);
		query.setParameter("to", to);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			List<String> li = Arrays.asList(o[0].toString(),o[1].toString());
			return li;
		}).collect(Collectors.toList());
	}
}
