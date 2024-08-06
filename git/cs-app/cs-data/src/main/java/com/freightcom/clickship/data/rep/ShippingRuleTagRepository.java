package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdvShippingRuleAction;
import com.freightcom.clickship.data.entity.ShippingRuleTag;
import com.freightcom.clickship.data.entity.Tag;

@Repository
public interface ShippingRuleTagRepository extends JpaRepository<ShippingRuleTag, String> {

	public void deleteByTag(Tag tag);
	
	public List<ShippingRuleTag> findByTag(Tag tag);
	
	public void deleteByAdvShippingRuleAction(AdvShippingRuleAction advShippingRuleAction);
	
	public List<ShippingRuleTag> findByAdvShippingRuleAction(AdvShippingRuleAction advShippingRuleAction);

}
