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
@Table(name = "shipping_rule_tag")
public class ShippingRuleTag extends BaseEntity implements Serializable {
	
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
	@JoinColumn(name = "tag_id")
	@JsonIgnore
	private Tag tag;

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

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
