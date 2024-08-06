package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.ShippingRule;

@Repository
public interface ShippingRuleRepository extends JpaRepository<ShippingRule, String> {

    public List<ShippingRule> findAllByCustomerOrderByPriorityAsc(Customer customer);

    public List<ShippingRule> findByCustomerAndActionPropertyAndActionValueAndActiveTrue(Customer customer,
			String actionProperty, String actionValue);

    @Query("SELECT DISTINCT c FROM ShippingRule c " +
            "WHERE c.customer =?1 AND (?2 IS NULL OR (c.marketplace = ?2)) " +
            "AND c.ruleType =?3 AND c.ruleCodeName =?4 AND c.ruleCodeCondition =?5 AND (?6 IS NULL OR (c.ruleCodeValue = ?6)) " +
            "AND c.actionProperty =?7 " +
            "AND (?8 IS NULL OR (DATE(c.startDate) = DATE(?8))) " +
            "AND (?9 IS NULL OR (DATE(c.endDate) = DATE(?9)))")
    public List<ShippingRule> getAllDuplicate(Customer customer, Marketplace marketplace, String ruleType, String ruleCodeName, String ruleCodeCondition,
                                       String ruleCodeValue, String actionProperty, Date startDate, Date endDate);

    @Query("SELECT DISTINCT c FROM ShippingRule c " +
            "WHERE c.customer =?1 AND c.ruleType =?2 AND c.active =?3 " +
            "AND (c.startDate IS NULL OR (DATE(c.startDate) <= DATE(?4))) " +
            "AND (c.endDate IS NULL OR (DATE(c.endDate) >= DATE(?4))) ORDER BY c.priority ASC")
    public List<ShippingRule> getAllForCustomerWithinCurrentDate(Customer customer, String ruleType, Boolean active, Date currentDate);

    @Query("SELECT max(c.priority) FROM ShippingRule c WHERE c.customer =?1 AND c.ruleType =?2")
    public Optional<Integer> getMaxPriorityForCustomer(Customer customer, String ruleType);

}