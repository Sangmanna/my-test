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
@Table(name = "marketplace_address")
public class MarketplaceAddress extends BaseEntity {
	
	private static final long serialVersionUID = 1185733724610555718L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_id", nullable = false, updatable = false)
	@JsonIgnore
	private Marketplace marketplace;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private CustomerAddress customerAddress;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public MarketplaceAddress setId(String id) {
		this.id = id;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public MarketplaceAddress setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public MarketplaceAddress setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
		return this;
	}
}
