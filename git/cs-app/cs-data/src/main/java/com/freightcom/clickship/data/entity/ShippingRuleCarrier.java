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

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "shipping_rule_carrier")
public class ShippingRuleCarrier extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6044109834900971718L;

	@Id
    @GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adv_shipping_rule_action_id", nullable = false)
	private AdvShippingRuleAction advShippingRuleAction;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "carrier_preference_id", nullable = false)
	private CustomerCarrierPreference customerCarrierPreference;

	public String getId() {
		return id;
	}
	
	public BaseEntity setId(String id) {
		return this;
	}

	public AdvShippingRuleAction getAdvShippingRuleAction() {
		return advShippingRuleAction;
	}

	public void setAdvShippingRuleAction(AdvShippingRuleAction advShippingRuleAction) {
		this.advShippingRuleAction = advShippingRuleAction;
	}

	public CustomerCarrierPreference getCustomerCarrierPreference() {
		return customerCarrierPreference;
	}

	public void setCustomerCarrierPreference(CustomerCarrierPreference customerCarrierPreference) {
		this.customerCarrierPreference = customerCarrierPreference;
	}	
}
