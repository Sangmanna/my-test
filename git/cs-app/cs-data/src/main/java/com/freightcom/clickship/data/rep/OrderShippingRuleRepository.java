package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.OrderShippingRule;

@Repository
public interface OrderShippingRuleRepository extends JpaRepository<OrderShippingRule, String> {

	public List<OrderShippingRule> findByAdvancedShippingRuleAndOrder(AdvancedShippingRule rule, Order order);
	
	public List<OrderShippingRule> findByAdvancedShippingRule(AdvancedShippingRule rule);
	
	public List<OrderShippingRule> findByOrderAndAdvancedShippingRuleAndActiveIsTrue(Order order, AdvancedShippingRule rule);
	
	public List<OrderShippingRule> findByOrder(Order order);
	
	@Query("SELECT osr FROM OrderShippingRule osr " +
		       "WHERE osr.order.status IN :orderStatusList " +
		       "AND osr.advancedShippingRule = :advancedShippingRule " +
		       "AND osr.advancedShippingRule.ruleType = :ruleType")
		List<OrderShippingRule> findByOrderStatusAndAdvancedShippingRule(@Param("orderStatusList") List<String> orderStatusList,
				AdvancedShippingRule advancedShippingRule, String ruleType);

	@Query("SELECT osr FROM OrderShippingRule osr " +
		       "WHERE osr.order.id = :orderId " +
		       "AND osr.active = :status " +
		       "AND osr.advancedShippingRule.ruleType = :ruleType")
		List<OrderShippingRule> findByOrderAndAdvancedShippingRuleType(String orderId, String ruleType, boolean status);


}
