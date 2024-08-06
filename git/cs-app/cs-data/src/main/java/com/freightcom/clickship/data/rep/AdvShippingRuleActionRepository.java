package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdvShippingRuleAction;
import com.freightcom.clickship.data.entity.AdvancedShippingRule;

@Repository
public interface AdvShippingRuleActionRepository extends JpaRepository<AdvShippingRuleAction, String> {
	
	public AdvShippingRuleAction findByShippingRule(AdvancedShippingRule rule);
		
	public List<AdvShippingRuleAction> findByShippingOrigin_Id(String shippingOriginId);
}