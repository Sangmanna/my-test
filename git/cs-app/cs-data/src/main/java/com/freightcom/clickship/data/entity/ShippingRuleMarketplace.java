package com.freightcom.clickship.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "shipping_rule_marketplace")
public class ShippingRuleMarketplace extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6044109834900971718L;

	@Id
    @GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adv_shipping_rule_condition_id", nullable = false)
	private AdvShippingRuleCondition advShippingRuleCondition;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_id")
	@JsonIgnore
	private Marketplace marketplace;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		return this;
	}

	public AdvShippingRuleCondition getAdvShippingRuleCondition() {
		return advShippingRuleCondition;
	}

	public void setAdvShippingRuleCondition(AdvShippingRuleCondition advShippingRuleCondition) {
		this.advShippingRuleCondition = advShippingRuleCondition;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}
	
}
