package com.freightcom.clickship.service.dao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningTableDTO;
import com.freightcom.clickship.model.admin.dashboard.subscription.SubscriptionTableDTO;
import com.freightcom.clickship.service.dao.SubscriptionReportsDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class SubscritpionReportsDaoImpl implements SubscriptionReportsDao {

	@PersistenceContext
	EntityManager em;

	private final static String customerSubscriptions = "SELECT c.business_name, c.sub_tier, COALESCE(st.sub_plan_price,0), COALESCE(c.prev_sub_tier,'NA'), COALESCE(c.sales_rep,'Not assigned') AS rep, "
			+ " DATE_FORMAT(NOW() ,'%d-%m-%Y') as date,c.id FROM customer c "
			+ "LEFT JOIN subs_tier st ON c.sub_tier = st.name ";

	private String earningsFromSubscription = "SELECT c.business_name, c.sub_tier, st.sub_plan_price as price, st.sub_plan_price as total "
			+ "FROM customer c " + "LEFT JOIN subs_tier st ON c.sub_tier = st.name "
			+ "WHERE c.sub_tier_change_datetime BETWEEN :from AND :to AND st.sub_plan_price != 0  AND c.business_name  LIKE :customer ";

	private String upgradeSubscriptions = "SELECT c.business_name,c.sub_tier, st.sub_plan_price AS curr_price,  c.prev_sub_tier, COALESCE(c.sales_rep,'Not assigned'), "
			+ "DATE_FORMAT(c.sub_tier_change_datetime,'%d-%m-%Y'), c.id FROM customer c  "
			+ "left JOIN subs_tier st ON  c.sub_tier = st.name "
			+ "left JOIN subs_tier str ON  c.prev_sub_tier = str.name " + "WHERE st.sub_plan_price != 0 "
			+ "AND st.sub_plan_price > str.sub_plan_price AND c.sub_tier_change_datetime BETWEEN :from AND :to ";

	private String downgradeSubscriptions = "SELECT c.business_name,c.sub_tier, st.sub_plan_price AS curr_price,  c.prev_sub_tier, COALESCE(c.sales_rep,'Not assigned'),"
			+ " DATE_FORMAT(c.sub_tier_change_datetime,'%d-%m-%Y'),c.id FROM customer c  "
			+ "left JOIN subs_tier st ON  c.sub_tier = st.name "
			+ "left JOIN subs_tier str ON  c.prev_sub_tier = str.name "
			+ "WHERE  st.sub_plan_price < str.sub_plan_price AND c.sub_tier_change_datetime BETWEEN :from AND :to ";

	private String activeSubscriptionWithCounts = " SELECT  c.sub_tier, COALESCE(st.sub_plan_price,0),COALESCE(count(st.sub_plan_price),0) " + 
			"  FROM customer c " + 
			" LEFT JOIN subs_tier st ON c.sub_tier = st.name " + 
			" GROUP BY c.sub_tier ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SubscriptionTableDTO> getDataforSubscriptionTable(String agentName) {
		Query query = null;
		if (agentName != null && agentName.length() > 0) {
			String agentCondition = " where  c.sales_rep= ? ";
			query = em.createNativeQuery(customerSubscriptions + agentCondition);
			query.setParameter(1, agentName);
		} else {
			query = em.createNativeQuery(customerSubscriptions);
		}
		List<Object[]> list = (List<Object[]>) query.getResultList();

		return list.stream().map(o -> {
			return new SubscriptionTableDTO(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CsEarningTableDTO> getEarningsFromSubscription(String from, String to, String businessName) {
		Query query = em.createNativeQuery(earningsFromSubscription);
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("customer", "%"+businessName);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new CsEarningTableDTO(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubscriptionTableDTO> getupgradedSubscription(String agentName, String from, String to) {
		String localUpgradeSubscription = upgradeSubscriptions;
		Query nativeQuery = null;
		if (agentName != null && agentName.length() > 0) {
			localUpgradeSubscription = localUpgradeSubscription + " AND  c.sales_rep= ? ";
			nativeQuery = em.createNativeQuery(localUpgradeSubscription);
			nativeQuery.setParameter(1, agentName);
		} else {
			nativeQuery = em.createNativeQuery(localUpgradeSubscription);
		}
		
		nativeQuery.setParameter("from", from);
		nativeQuery.setParameter("to", to);
		List<Object[]> list = (List<Object[]>) nativeQuery.getResultList();
		return list.stream().map(o -> {
			return new SubscriptionTableDTO(o);
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubscriptionTableDTO> getDowngradedSubscription(String agentName, String from, String to) {
		String localDowngradeSubscriptions = downgradeSubscriptions;
		
		Query nativeQuery = null;
		
		if (agentName != null && agentName.length() > 0) {
			localDowngradeSubscriptions = localDowngradeSubscriptions + " AND  c.sales_rep= ? ";
			nativeQuery = em.createNativeQuery(localDowngradeSubscriptions);
			nativeQuery.setParameter(1, agentName);
		} else {
			nativeQuery = em.createNativeQuery(localDowngradeSubscriptions);
		}
		
		nativeQuery.setParameter("from", from);
		nativeQuery.setParameter("to", to);
		List<Object[]> list = (List<Object[]>) nativeQuery.getResultList();
		return list.stream().map(o -> {
			return new SubscriptionTableDTO(o);
		}).collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<List<String>> getSubscriptionsWithCounts(String agentName) {
		
		Query query = em.createNativeQuery(activeSubscriptionWithCounts);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			List<String> li = Arrays.asList(o[0].toString(),o[1].toString(),o[2].toString());
			return li;
		}).collect(Collectors.toList());
	}

}
