package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdvShippingRuleCondition;
import com.freightcom.clickship.data.entity.AdvancedShippingRule;

@Repository
public interface AdvShippingRuleConditionRepository extends JpaRepository<AdvShippingRuleCondition, String> {
	
	public List<AdvShippingRuleCondition> findByShippingRule(AdvancedShippingRule rule);
	
	@Query("SELECT c.shippingRule FROM AdvShippingRuleCondition c WHERE c = :condition AND (c.shippingRule.isDeleted = false OR c.shippingRule.isDeleted = true)")
	public AdvancedShippingRule findShippingRuleByCondition(@Param("condition") AdvShippingRuleCondition condition);

}