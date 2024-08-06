package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.chargebee.dto.ChargebeeCustomer;
import com.freightcom.clickship.chargebee.dto.ChargebeeInvoice;
import com.freightcom.clickship.chargebee.dto.ChargebeeSubscription;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerSubPlan;
import com.freightcom.clickship.data.entity.SubTier;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningTableDTO;
import com.freightcom.clickship.model.admin.dashboard.subscription.SubscriptionTableDTO;

public interface SubscriptionService {
	
	public void cardAdded(ChargebeeCustomer customer);
	
	public void cardDeleted(ChargebeeCustomer customer);
	
	public SubTier findSubscriptionPlanByName(String subTier);
	
	public void saveSubscription(CustomerSubPlan customerSubPlan);
	
	public void paymentFailed(ChargebeeSubscription subscription);
	
	public CustomerSubPlan findActivePlanByCustomer(Customer customer);
	
	public void changeSubscriptionPlan(ChargebeeSubscription subscription);
	
	public void paymentSuccess(ChargebeeInvoice invoice, String customerId);
	
	public void updateSubscriptionPlanInClickship(ChargebeeSubscription subscription);

	public List<SubscriptionTableDTO> getDataforSubscriptionTable(String agentName);

	public List<CsEarningTableDTO> getEarningsFromSubscription(String fromDate, String toDate, String businessName);

	public List<SubscriptionTableDTO> getUpgradedSubsriptions(String agentName, String from, String to);

	public List<SubscriptionTableDTO> getDowngradedSubsriptions(String agentName, String from, String to);
	
	public void updateSubscriptionPlanInClickship(Customer customer, ChargebeeSubscription subscription);

	
	List<List<String>> getAllSubscriptionsWithCounts(String agentName);
	
}
