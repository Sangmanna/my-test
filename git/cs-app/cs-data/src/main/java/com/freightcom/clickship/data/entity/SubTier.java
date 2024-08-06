package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "subs_tier")
public class SubTier extends BaseEntity {

	private static final long serialVersionUID = -1526058227304954039L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "shipment_allowed")
	private Integer shipmentAllowed;

	@Column(name = "num_marketplace")
	private Integer numMarketplace;

	@Column(name = "num_users")
	private Integer numUsers;
	
	@Column(name = "load_own_rate")
	private Boolean loadOwnRate;

	@Column(name = "custom_branding")
	private Boolean customBranding;
	
	@Column(name = "sub_plan_price")
	private double subPlanPrice;

	public String getId() {
		return id;
	}

	public SubTier setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public SubTier setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getShipmentAllowed() {
		return shipmentAllowed;
	}

	public SubTier setShipmentAllowed(Integer shipmentAllowed) {
		this.shipmentAllowed = shipmentAllowed;
		return this;
	}

	public Integer getNumMarketplace() {
		return numMarketplace;
	}

	public SubTier setNumMarketplace(Integer numMarketplace) {
		this.numMarketplace = numMarketplace;
		return this;
	}

	public Integer getNumUsers() {
		return numUsers;
	}

	public SubTier setNumUsers(Integer numUsers) {
		this.numUsers = numUsers;
		return this;
	}

	public Boolean getLoadOwnRate() {
		return loadOwnRate;
	}

	public SubTier setLoadOwnRate(Boolean loadOwnRate) {
		this.loadOwnRate = loadOwnRate;
		return this;
	}

	public Boolean getCustomBranding() {
		return customBranding;
	}

	public SubTier setCustomBranding(Boolean customBranding) {
		this.customBranding = customBranding;
		return this;
	}

	public double getSubPlanPrice() {
		return subPlanPrice;
	}

	public void setSubPlanPrice(double subPlanPrice) {
		this.subPlanPrice = subPlanPrice;
	}
}
