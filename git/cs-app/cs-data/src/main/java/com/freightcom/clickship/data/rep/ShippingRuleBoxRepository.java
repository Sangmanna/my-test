package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdvShippingRuleAction;
import com.freightcom.clickship.data.entity.AdvancedShippingRule;
import com.freightcom.clickship.data.entity.Box;
import com.freightcom.clickship.data.entity.ShippingRuleBox;

@Repository
public interface ShippingRuleBoxRepository extends JpaRepository<ShippingRuleBox, String> {

	public List<ShippingRuleBox> findByAdvShippingRuleAction(AdvShippingRuleAction advShippingRuleAction);

	public void deleteByAdvShippingRuleAction(AdvShippingRuleAction advShippingRuleAction);

	@Query(value = "SELECT srb FROM ShippingRuleBox srb " +
			"WHERE srb.advShippingRuleAction.id = :advShippingRuleActionId " +
			"AND srb.box.packageType = :packageType")
	public List<ShippingRuleBox> findByAdvShippingRuleActionAndPackageType(
			@Param("advShippingRuleActionId") String advShippingRuleActionId,
			@Param("packageType") String packageType
			);

	@Query("SELECT DISTINCT a.shippingRule FROM ShippingRuleBox s " +
			"INNER JOIN s.advShippingRuleAction a " +
			"WHERE s.box = :box AND (a.shippingRule.isDeleted = false OR a.shippingRule.isDeleted = true)")
	public List<AdvancedShippingRule> findAdvancedShippingRulesByBox(
			@Param("box") Box box);
	public void deleteByBox(Box box);

}
