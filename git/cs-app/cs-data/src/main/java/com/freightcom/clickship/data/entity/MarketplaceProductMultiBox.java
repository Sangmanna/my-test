package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "marketplace_product_multi_box")
public class MarketplaceProductMultiBox extends BaseEntity {

	private static final long serialVersionUID = 451924292084493944L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_product_id")
	@JsonIgnore
	private MarketplaceProduct marketplaceProduct;
	
	@Column(name = "length_metric", nullable = false)
	private double lengthMetric;

	@Column(name = "length_imperial", nullable = false)
	private double lengthImperial;

	@Column(name = "width_metric", nullable = false)
	private double widthMetric;

	@Column(name = "width_imperial", nullable = false)
	private double widthImperial;

	@Column(name = "height_metric", nullable = false)
	private double heightMetric;

	@Column(name = "height_imperial", nullable = false)
	private double heightImperial;
	
	@Column(name = "weight_metric", nullable = false)
	private double weightMetric;

	@Column(name = "weight_imperial", nullable = false)
	private double weightImperial;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}
	
	public MarketplaceProductMultiBox() {
		super();
	}
	
	public MarketplaceProductMultiBox(MarketplaceProduct marketplaceProduct) {
		super();
		this.marketplaceProduct = marketplaceProduct;
	}

	public MarketplaceProduct getMarketplaceProduct() {
		return marketplaceProduct;
	}

	public MarketplaceProductMultiBox setMarketplaceProduct(MarketplaceProduct marketplaceProduct) {
		this.marketplaceProduct = marketplaceProduct;
		return this;
	}

	@Transient
	public String getMarketplaceProductMultiBoxId() {
		return this.getId();
	}

	public double getLengthMetric() {
		return lengthMetric;
	}

	public MarketplaceProductMultiBox setLengthMetric(double lengthMetric) {
		this.lengthMetric = (double) Math.round(lengthMetric * 100) / 100;
		return this;
	}

	public double getLengthImperial() {
		return lengthImperial;
	}

	public MarketplaceProductMultiBox setLengthImperial(double lengthImperial) {
		this.lengthImperial = (double) Math.round(lengthImperial * 100) / 100;
		return this;
	}

	public double getWidthMetric() {
		return widthMetric;
	}

	public MarketplaceProductMultiBox setWidthMetric(double widthMetric) {
		this.widthMetric = (double) Math.round(widthMetric * 100) / 100;
		return this;
	}

	public double getWidthImperial() {
		return widthImperial;
	}

	public MarketplaceProductMultiBox setWidthImperial(double widthImperial) {
		this.widthImperial = (double) Math.round(widthImperial * 100) / 100;
		return this;
	}

	public double getHeightMetric() {
		return heightMetric;
	}

	public MarketplaceProductMultiBox setHeightMetric(double heightMetric) {
		this.heightMetric = (double) Math.round(heightMetric * 100) / 100;
		return this;
	}

	public double getHeightImperial() {
		return heightImperial;
	}

	public MarketplaceProductMultiBox setHeightImperial(double heightImperial) {
		this.heightImperial = (double) Math.round(heightImperial * 100) / 100;
		return this;
	}

	public double getWeightImperial() {
		return weightImperial;
	}

	public double getWeightMetric() {
		return weightMetric;
	}

	public MarketplaceProductMultiBox setWeightMetric(double weightMetric) {
		this.weightMetric = (double) Math.round(weightMetric * 100) / 100;
		return this;
	}
	
	public MarketplaceProductMultiBox setWeightImperial(double weightImperial) {
		this.weightImperial = (double) Math.round(weightImperial * 100) / 100;
		return this;
	}
	
	public MarketplaceProductMultiBox setLengthImperial(double lengthImperial, double lengthMetric) {
		this.lengthImperial = (double) Math.round(lengthImperial * 100) / 100;
		this.lengthMetric = (double) Math.round(lengthMetric * 100) / 100;
		return this;
	}
	
	public MarketplaceProductMultiBox setWidthImperial(double widthImperial, double widthMetric) {
		this.widthImperial = (double) Math.round(widthImperial * 100) / 100;
		this.widthMetric = (double) Math.round(widthMetric * 100) / 100;
		return this;
	}
	
	public MarketplaceProductMultiBox setHeightImperial(double heightImperial, double heightMetric) {
		this.heightImperial = (double) Math.round(heightImperial * 100) / 100;
		this.heightMetric = (double) Math.round(heightMetric * 100) / 100;
		return this;
	}
	
	public MarketplaceProductMultiBox setWeightImperial(double weightImperial, double weightMetric) {
		this.weightImperial = (double) Math.round(weightImperial * 100) / 100;
		this.weightMetric = (double) Math.round(weightMetric * 100) / 100;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public MarketplaceProductMultiBox setDescription(String description) {
		this.description = description;
		return this;
	}
	
	

}
