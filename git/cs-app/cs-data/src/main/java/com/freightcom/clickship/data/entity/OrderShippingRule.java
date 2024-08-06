package com.freightcom.clickship.data.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "order_shipping_rule")
public class OrderShippingRule extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6044109834900971718L;

	@Id
    @GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false, updatable = false)
    private Order order;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adv_shipping_rule_id", nullable = false)
	private AdvancedShippingRule advancedShippingRule;
	
	@Column(name = "shipping_cost")
	private Double shippingCost;

	@Column(name = "shipping_currency")
	private String shippingCurrency;
	
	@Column(name = "service_type")
	private String serviceType;

	@Column(name = "service_type_code")
	private String serviceTypeCode;
	
	@Column(name = "transit_time")
	private Integer transitTime;
	
	@Column(name = "rate_request_id")
	private String rateRequestId;
	
	@Column(name = "rule_errors")
	private String ruleErrors;
	
	@Column(name = "active")
    private Boolean active = false;
	
	@Column(name = "rate_fetched_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Date rateFetchedTime;
	
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public AdvancedShippingRule getAdvancedShippingRule() {
		return advancedShippingRule;
	}

	public void setAdvancedShippingRule(AdvancedShippingRule advancedShippingRule) {
		this.advancedShippingRule = advancedShippingRule;
	}

	public String getRuleErrors() {
		return ruleErrors;
	}

	public void setRuleErrors(String ruleErrors) {
		this.ruleErrors = ruleErrors;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getShippingCurrency() {
		return shippingCurrency;
	}

	public void setShippingCurrency(String shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceTypeCode() {
		return serviceTypeCode;
	}

	public void setServiceTypeCode(String serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
	}
	
	public Integer getTransitTime() {
		return transitTime;
	}

	public void setTransitTime(Integer transitTime) {
		this.transitTime = transitTime;
	}

	public Date getRateFetchedTime() {
		return rateFetchedTime;
	}

	public void setRateFetchedTime(Date rateFetchedTime) {
		this.rateFetchedTime = rateFetchedTime;
	}

	public String getRateRequestId() {
		return rateRequestId;
	}

	public void setRateRequestId(String rateRequestId) {
		this.rateRequestId = rateRequestId;
	}	
		
}
