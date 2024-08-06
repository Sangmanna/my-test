package com.freightcom.clickship.model.shippingrules;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

public class AdvShippingRuleConditionDTO {
	private String id;
	@NotNull
	@EnumValidate(value = ShippingRuleFieldType.class, enumMethod = "getType")
	private String field;
	@NotNull
	@EnumValidate(value = ShippingRuleOperator.class, enumMethod = "getType")	
	private String operator;
	private List<ShippingRuleMarketplaceDTO> shippingRuleMarketplaceDTOs;
	private String value1;
	private String value2;
	private String value3;
	private String units;
	private Date orderDateStart;
	private Date orderDateEnd;
	private Boolean active;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
	public Date getOrderDateStart() {
		return orderDateStart;
	}

	public void setOrderDateStart(Date orderDateStart) {
		this.orderDateStart = orderDateStart;
	}

	public Date getOrderDateEnd() {
		return orderDateEnd;
	}

	public void setOrderDateEnd(Date orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}

	public List<ShippingRuleMarketplaceDTO> getShippingRuleMarketplaceDTOs() {
		return shippingRuleMarketplaceDTOs;
	}

	public void setShippingRuleMarketplaceDTOs(List<ShippingRuleMarketplaceDTO> shippingRuleMarketplaceDTOs) {
		this.shippingRuleMarketplaceDTOs = shippingRuleMarketplaceDTOs;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

}
