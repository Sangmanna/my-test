package com.freightcom.clickship.service.service;

import com.freightcom.clickship.chargebee.dto.ChargebeeSubscription;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerSubPlan;

public interface CustomerSubscriptionService {
	
	public boolean canLoadOwnCarrierRate(Customer customer);
	
	public boolean canLoadOwnUpsCarrierRate(Customer customer);
	
	public boolean canLoadOwnCanparCarrierRate(Customer customer);
	
	public boolean canLoadOwnMidlandCarrierRate(Customer customer);
	
	public boolean canLoadOwnCanadaPostCarrierRate(Customer customer);
	
	public CustomerSubPlan findCustomerActivePlan(Customer customer);
	
	public CustomerSubPlan saveSubtierPlanForCustomer(Customer customer);
	
	public CustomerSubPlan saveCustomerSubscriptionPlan(CustomerSubPlan plan);
	
	public void updateSubscriptionPlanInCs(Customer customer, String eventType, ChargebeeSubscription subscription);
}
