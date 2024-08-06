package com.freightcom.clickship.event.service;

import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.model.exception.ShippingRuleException;

public interface AdvanceShippingRuleService {

	public AdvancedShippingRule getFirstApplicableOrderShippingRule(Order order);
	
	public void checkAndCreateRTROrderShippingRule(Order order, String shippingRuleId);
		
	public AdvancedShippingRule getFirstApplicableRTRShippingRule(Order order) throws ShippingRuleException;
}
