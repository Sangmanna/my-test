package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdvShippingRuleCondition;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.ShippingRuleMarketplace;

@Repository
public interface ShippingRuleMarketplaceRepository extends JpaRepository<ShippingRuleMarketplace, String> {

	public List<ShippingRuleMarketplace> findByAdvShippingRuleCondition(AdvShippingRuleCondition advShippingRuleCondition);

	public void deleteByAdvShippingRuleCondition(AdvShippingRuleCondition advShippingRuleCondition);
	 	 
	public List<ShippingRuleMarketplace> findByMarketplace(Marketplace marketplace);

}
