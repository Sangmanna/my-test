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

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "pallet_contingency_rates")
public class PalletContingencyRates extends BaseEntity {
	
	private static final long serialVersionUID = -6783109430298634058L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "box_id", updatable = false)
	private Box box;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marketplace_id", updatable = false)
	private Marketplace marketplace;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_setting_id", updatable = false)
	private MarketplaceSetting marketplaceSetting;
	
	@Column(name = "rate")
	private double rate = 0d;
	
	@Column(name = "currency")
	private String currency = "CAD";
	
	public PalletContingencyRates() {
		super();
	}

	public PalletContingencyRates(Box box, Marketplace marketplace, MarketplaceSetting marketplaceSetting) {
		super();
		this.box = box;
		this.marketplace = marketplace;
		this.marketplaceSetting = marketplaceSetting;
	}

	public String getId() {
		return id;
	}

	public PalletContingencyRates setId(String id) {
		this.id = id;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public PalletContingencyRates setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public Box getBox() {
		return box;
	}

	public PalletContingencyRates setBox(Box box) {
		this.box = box;
		return this;
	}

	public MarketplaceSetting getMarketplaceSetting() {
		return marketplaceSetting;
	}

	public PalletContingencyRates setMarketplaceSetting(MarketplaceSetting marketplaceSetting) {
		this.marketplaceSetting = marketplaceSetting;
		return this;
	}

	public double getRate() {
		return rate;
	}

	public PalletContingencyRates setRate(double rate) {
		this.rate = rate;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public PalletContingencyRates setCurrency(String currency) {
		this.currency = currency;
		return this;
	}
	
}