package com.freightcom.clickship.data.entity;

import jakarta.persistence.CascadeType;
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
@Table(name = "customer_sub_plan")
public class CustomerSubPlan extends BaseEntity {

	private static final long serialVersionUID = -3644996643605510237L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_tire_id", nullable = true, updatable = false)
	private SubTier subTire;

	//TODO rename this column
	@Column(name = "shippements_remain")
	private Integer shippementsRemain;

	@Column(name = "marketplace_remain")
	private Integer marketplaceRemain;

	@Column(name = "user_accounts_remain")
	private Integer userAccountsRemain;

	@Column(name = "load_own_rate")
	private Boolean loadOwnRate;

	@Column(name = "status")
	private Boolean status;

	public String getId() {
		return id;
	}

	public CustomerSubPlan setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public CustomerSubPlan setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public SubTier getSubTire() {
		return subTire;
	}

	public CustomerSubPlan setSubTire(SubTier subTire) {
		this.subTire = subTire;
		return this;
	}

	public Integer getShippementsRemain() {
		return shippementsRemain;
	}

	public CustomerSubPlan setShippementsRemain(Integer shippementsRemain) {
		this.shippementsRemain = shippementsRemain;
		return this;
	}

	public Integer getMarketplaceRemain() {
		return marketplaceRemain;
	}

	public CustomerSubPlan setMarketplaceRemain(Integer marketplaceRemain) {
		this.marketplaceRemain = marketplaceRemain;
		return this;
	}

	public Integer getUserAccountsRemain() {
		return userAccountsRemain;
	}

	public CustomerSubPlan setUserAccountsRemain(Integer userAccountsRemain) {
		this.userAccountsRemain = userAccountsRemain;
		return this;
	}

	public Boolean getStatus() {
		return status;
	}

	public CustomerSubPlan setStatus(Boolean status) {
		this.status = status;
		return this;
	}

	public Boolean getLoadOwnRate() {
		return loadOwnRate;
	}

	public CustomerSubPlan setLoadOwnRate(Boolean loadOwnRate) {
		this.loadOwnRate = loadOwnRate;
		return this;
	}

}
