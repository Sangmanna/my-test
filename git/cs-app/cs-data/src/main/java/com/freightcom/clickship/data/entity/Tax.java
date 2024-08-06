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
@Table(name = "tax")
public class Tax extends BaseEntity {
	
	private static final long serialVersionUID = 1165790254232669233L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, updatable = false)
	@JsonIgnore
	private Order order;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private Double price;

	@Column(name = "rate")
	private Double rate;
	
	public Tax() {
		
	}
	
	public Tax(Order order) {
		this.order = order;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Tax setId(String id) {
		this.id = id;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public Tax setOrder(Order order) {
		this.order = order;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Tax setTitle(String title) {
		this.title = title;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public Tax setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Double getRate() {
		return rate;
	}

	public Tax setRate(Double rate) {
		this.rate = rate;
		return this;
	}
}
