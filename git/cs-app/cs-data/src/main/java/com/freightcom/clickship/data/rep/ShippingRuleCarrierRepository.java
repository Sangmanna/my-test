package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdvShippingRuleAction;
import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.CustomerCarrierPreference;
import com.freightcom.clickship.data.entity.ShippingRuleCarrier;

@Repository
public interface ShippingRuleCarrierRepository extends JpaRepository<ShippingRuleCarrier, String> {

	public List<ShippingRuleCarrier> findByAdvShippingRuleAction(AdvShippingRuleAction advShippingRuleAction);
	
	public void deleteByAdvShippingRuleAction(AdvShippingRuleAction advShippingRuleAction);
	    
    @Query("SELECT DISTINCT a.shippingRule FROM ShippingRuleCarrier s " +
            "INNER JOIN s.advShippingRuleAction a " +
            "WHERE s.customerCarrierPreference IN :customerCarrierPreferences AND (a.shippingRule.isDeleted = false OR a.shippingRule.isDeleted = true)")
    public List<AdvancedShippingRule> findAdvancedShippingRulesByCustomerCarrierPreferences(
         @Param("customerCarrierPreferences") List<CustomerCarrierPreference> customerCarrierPreferences);
    
    public void deleteByCustomerCarrierPreferenceIn(List<CustomerCarrierPreference> customerCarrierPreferences);
    
    public boolean existsByCustomerCarrierPreference(CustomerCarrierPreference ccp);
}
