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
@Table(name = "shipping_rule_box")
public class ShippingRuleBox extends BaseEntity implements Serializable {
	
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
	@JoinColumn(name = "box_id")
	@JsonIgnore
	private Box box;
	
	@Column(name = "weight_type")
	private String weightType;
	
	@Column(name = "weight_units")
	private String weightUnits;
	
	@Column(name = "weight_imperial")
	private double weightImperial = 0d;
	
	@Column(name = "weight_metric")
	private double weightMetric = 0d;

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

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	public String getWeightType() {
		return weightType;
	}

	public void setWeightType(String weightType) {
		this.weightType = weightType;
	}

	public String getWeightUnits() {
		return weightUnits;
	}

	public void setWeightUnits(String weightUnits) {
		this.weightUnits = weightUnits;
	}

	public double getWeightImperial() {
		return weightImperial;
	}

	public void setWeightImperial(double weightImperial) {
		this.weightImperial = weightImperial;
	}

	public double getWeightMetric() {
		return weightMetric;
	}

	public void setWeightMetric(double weightMetric) {
		this.weightMetric = weightMetric;
	}	
	
}
