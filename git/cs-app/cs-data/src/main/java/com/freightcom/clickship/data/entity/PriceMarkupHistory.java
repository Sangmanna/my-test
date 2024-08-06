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
@Table(name = "price_markup_history")
public class PriceMarkupHistory extends BaseEntity {

	private static final long serialVersionUID = -137737348293748786L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marketplace_setting_id", updatable = false)
	@JsonIgnore
	private MarketplaceSetting marketplaceSetting;
	
	@Column(name = "is_package_price_percent")
	private boolean packagePricePercent = false;
	
	@Column(name = "is_package_price_down")
	private boolean pacakgePriceDown = false;
	
	@Column(name = "package_price_markup")
	private double packagePriceMarkup = 0d;
	
	@Column(name = "is_pallet_price_percent")
	private boolean palletPricePercent = false;
	
	@Column(name = "is_pallet_price_down")
	private boolean palletPriceDown = false;
	
	@Column(name = "pallet_price_markup")
	private double palletPriceMarkup = 0d;

	public PriceMarkupHistory() {
		super();
	}
	
	public PriceMarkupHistory(MarketplaceSetting setting) {
		super();
		this.marketplaceSetting = setting;
		this.pacakgePriceDown = setting.isRealtimePriceDown();
		this.packagePriceMarkup = setting.getRealtimePriceMarkup();
		this.packagePricePercent = setting.isRealtimePricePercent();
		
		this.palletPriceDown = setting.isPalletMarkupMode();
		this.palletPricePercent = setting.isPalletMarkupType();
		this.palletPriceMarkup = setting.getPalletMarkupValue();
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public PriceMarkupHistory setId(String id) {
		this.id = id;
		return this;
	}

	public MarketplaceSetting getMarketplaceSetting() {
		return marketplaceSetting;
	}

	public PriceMarkupHistory setMarketplaceSetting(MarketplaceSetting marketplaceSetting) {
		this.marketplaceSetting = marketplaceSetting;
		return this;
	}

	public boolean isPackagePricePercent() {
		return packagePricePercent;
	}

	public PriceMarkupHistory setPackagePricePercent(boolean packagePricePercent) {
		this.packagePricePercent = packagePricePercent;
		return this;
	}

	public boolean isPackagePriceDown() {
		return pacakgePriceDown;
	}

	public PriceMarkupHistory setPackagePriceDown(boolean pacakgePriceDown) {
		this.pacakgePriceDown = pacakgePriceDown;
		return this;
	}

	public double getPackagePriceMarkup() {
		return packagePriceMarkup;
	}

	public PriceMarkupHistory setRealtimePriceMarkup(double packagePriceMarkup) {
		this.packagePriceMarkup = packagePriceMarkup;
		return this;
	}

	public boolean isPalletPricePercent() {
		return palletPricePercent;
	}

	public void setPalletPricePercent(boolean palletPricePercent) {
		this.palletPricePercent = palletPricePercent;
	}

	public boolean isPalletPriceDown() {
		return palletPriceDown;
	}

	public void setPalletPriceDown(boolean palletPriceDown) {
		this.palletPriceDown = palletPriceDown;
	}

	public double getPalletPriceMarkup() {
		return palletPriceMarkup;
	}

	public void setPalletPriceMarkup(double palletPriceMarkup) {
		this.palletPriceMarkup = palletPriceMarkup;
	}
}
