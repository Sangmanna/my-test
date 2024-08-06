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
@Table(name = "orderline_single_sku_multi_box")
public class OrderlineSingleSkuMultibox extends BaseEntity {

	private static final long serialVersionUID = 451924292084493944L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_line_id")
	@JsonIgnore
	private Orderline orderLine;

	@Column(name = "length_metric")
	private double lengthMetric;

	@Column(name = "length_imperial")
	private double lengthImperial;

	@Column(name = "width_metric")
	private double widthMetric;

	@Column(name = "width_imperial")
	private double widthImperial;

	@Column(name = "height_metric")
	private double heightMetric;

	@Column(name = "height_imperial")
	private double heightImperial;

	@Column(name = "weight_metric")
	private double weightMetric;

	@Column(name = "weight_imperial")
	private double weightImperial;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public OrderlineSingleSkuMultibox() {
		super();
	}

	public OrderlineSingleSkuMultibox(Order order) {
		super();
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public OrderlineSingleSkuMultibox setOrder(Order order) {
		this.order = order;
		return this;
	}
	
	public OrderlineSingleSkuMultibox(Orderline orderLine) {
		super();
		this.orderLine = orderLine;
	}
	
	public Orderline getOrderLine() {
		return orderLine;
	}

	public OrderlineSingleSkuMultibox setOrderLine(Orderline orderLine) {
		this.orderLine = orderLine;
		return this;
	}

	@Transient
	public String getMarketplaceProductMultiBoxId() {
		return this.getId();
	}

	public double getLengthMetric() {
		return lengthMetric;
	}

	public OrderlineSingleSkuMultibox setLengthMetric(double lengthMetric) {
		this.lengthMetric = (double) Math.round(lengthMetric * 100) / 100;
		return this;
	}

	public double getLengthImperial() {
		return lengthImperial;
	}

	public OrderlineSingleSkuMultibox setLengthImperial(double lengthImperial) {
		this.lengthImperial = (double) Math.round(lengthImperial * 100) / 100;
		return this;
	}

	public double getWidthMetric() {
		return widthMetric;
	}

	public OrderlineSingleSkuMultibox setWidthMetric(double widthMetric) {
		this.widthMetric = (double) Math.round(widthMetric * 100) / 100;
		return this;
	}

	public double getWidthImperial() {
		return widthImperial;
	}

	public OrderlineSingleSkuMultibox setWidthImperial(double widthImperial) {
		this.widthImperial = (double) Math.round(widthImperial * 100) / 100;
		return this;
	}

	public double getHeightMetric() {
		return heightMetric;
	}

	public OrderlineSingleSkuMultibox setHeightMetric(double heightMetric) {
		this.heightMetric = (double) Math.round(heightMetric * 100) / 100;
		return this;
	}

	public double getHeightImperial() {
		return heightImperial;
	}

	public OrderlineSingleSkuMultibox setHeightImperial(double heightImperial) {
		this.heightImperial = (double) Math.round(heightImperial * 100) / 100;
		return this;
	}

	public double getWeightImperial() {
		return weightImperial;
	}

	public double getWeightMetric() {
		return weightMetric;
	}

	public OrderlineSingleSkuMultibox setWeightMetric(double weightMetric) {
		this.weightMetric = (double) Math.round(weightMetric * 100) / 100;
		return this;
	}

	public OrderlineSingleSkuMultibox setWeightImperial(double weightImperial) {
		this.weightImperial = (double) Math.round(weightImperial * 100) / 100;
		return this;
	}

	public OrderlineSingleSkuMultibox setLengthImperial(double lengthImperial, double lengthMetric) {
		this.lengthImperial = (double) Math.round(lengthImperial * 100) / 100;
		this.lengthMetric = (double) Math.round(lengthMetric * 100) / 100;
		return this;
	}

	public OrderlineSingleSkuMultibox setWidthImperial(double widthImperial, double widthMetric) {
		this.widthImperial = (double) Math.round(widthImperial * 100) / 100;
		this.widthMetric = (double) Math.round(widthMetric * 100) / 100;
		return this;
	}

	public OrderlineSingleSkuMultibox setHeightImperial(double heightImperial, double heightMetric) {
		this.heightImperial = (double) Math.round(heightImperial * 100) / 100;
		this.heightMetric = (double) Math.round(heightMetric * 100) / 100;
		return this;
	}

	public OrderlineSingleSkuMultibox setWeightImperial(double weightImperial, double weightMetric) {
		this.weightImperial = (double) Math.round(weightImperial * 100) / 100;
		this.weightMetric = (double) Math.round(weightMetric * 100) / 100;
		return this;
	}

}
