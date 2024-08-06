package com.freightcom.clickship.data.entity;

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
@Table(name = "user_marketplaces")
public class UserMarketplaces extends BaseEntity {

	private static final long serialVersionUID = -8504606635995295695L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id", updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "username", updatable = false)
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "marketplace_id", nullable = false, updatable = false)
	private Marketplace marketplace;
	
	public UserMarketplaces() {
		super();
	}

	public UserMarketplaces(Customer customer, User user, Marketplace marketplace) {
		super();
		this.customer = customer;
		this.user = user;
		this.marketplace = marketplace;
	}

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public UserMarketplaces setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public User getUser() {
		return user;
	}

	public UserMarketplaces setUser(User user) {
		this.user = user;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public UserMarketplaces setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

}
