package com.freightcom.clickship.service.dao;

import java.util.List;

import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningTableDTO;
import com.freightcom.clickship.model.admin.dashboard.subscription.SubscriptionTableDTO;

public interface SubscriptionReportsDao {

	public List<SubscriptionTableDTO> getDataforSubscriptionTable(String agentName);

	public List<CsEarningTableDTO> getEarningsFromSubscription(String from, String to, String businessName);

	public List<SubscriptionTableDTO> getupgradedSubscription(String agentName, String from, String to);

	public List<SubscriptionTableDTO> getDowngradedSubscription(String agentName, String from, String to);

	List<List<String>> getSubscriptionsWithCounts(String agentName);

}
