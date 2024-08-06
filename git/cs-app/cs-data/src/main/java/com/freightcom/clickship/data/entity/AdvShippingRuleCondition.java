package com.freightcom.clickship.data.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;

@Entity
@Table(name = "adv_shipping_rule_condition")
public class AdvShippingRuleCondition extends BaseEntity implements CustomerAssociateEntity {

	private static final long serialVersionUID = 7889818998069007073L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shipping_rule_id", nullable = false)
	private AdvancedShippingRule shippingRule;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "advShippingRuleCondition", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShippingRuleMarketplace> shippingRuleMarketplaces;
	
	@Column(name = "field")
	private String field;

	@Column(name = "operator")
	private String operator;

	@Column(name = "value1")
	private String value1;

	@Column(name = "value2")
	private String value2;
	
	@Column(name = "value3")
	private String value3;
	
	@Column(name = "units")
	private String units;
	
	@Column(name = "order_date_start")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDateStart;

	@Column(name = "order_date_end")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDateEnd;
	
	@Column(name = "active")
	private Boolean active;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		return this;
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

	public AdvancedShippingRule getShippingRule() {
		return shippingRule;
	}

	public void setShippingRule(AdvancedShippingRule shippingRule) {
		this.shippingRule = shippingRule;
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

	public List<ShippingRuleMarketplace> getShippingRuleMarketplaces() {
		return shippingRuleMarketplaces;
	}

	public void setShippingRuleMarketplaces(List<ShippingRuleMarketplace> shippingRuleMarketplaces) {
		if (shippingRuleMarketplaces != null) {
			shippingRuleMarketplaces.forEach(marketplace -> marketplace.setAdvShippingRuleCondition(this));
		}
		this.shippingRuleMarketplaces = shippingRuleMarketplaces;
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