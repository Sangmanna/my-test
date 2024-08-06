package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.Customer;

@Repository
public interface AdvancedShippingRuleRepository extends JpaRepository<AdvancedShippingRule, String> {

    public List<AdvancedShippingRule> findByCustomerAndRuleTypeAndActiveOrderByPriorityAsc(Customer customer, String ruleType, Boolean active);
    
    public List<AdvancedShippingRule> findByCustomerAndRuleType(Customer customer, String ruleType);
    
    public List<AdvancedShippingRule> findByCustomerAndRuleTypeAndRuleName(Customer customer, String ruleType, String ruleName);
    
    public List<AdvancedShippingRule> findByCustomerAndActive(Customer customer, boolean active);
    
    public List<AdvancedShippingRule> findAllByCustomerOrderByPriorityAsc(Customer customer);

    @Query("SELECT COALESCE(MAX(priority), 0) + 1 FROM AdvancedShippingRule WHERE ruleType = :ruleType AND customer = :customer")
    public Integer findTop1ByRuleTypeAndCustomerOrderByPriorityDesc(String ruleType, Customer customer);
  
    @Query("SELECT MAX(e.priority) FROM AdvancedShippingRule e WHERE e.customer=:customer AND e.ruleType = :ruleType")
    public Integer findMaxPriorityByRuleType(@Param("ruleType") String ruleType, Customer customer);
    
    @Query("SELECT rule.ruleName FROM AdvancedShippingRule rule WHERE rule.customer = :customer")
    public List<String> findRuleNamesByCustomer(@Param("customer") Customer customer);
}