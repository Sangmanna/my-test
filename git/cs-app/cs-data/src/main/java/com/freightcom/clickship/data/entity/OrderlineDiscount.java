package com.freightcom.clickship.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "orderline_discount")
public class OrderlineDiscount extends BaseEntity {
	
	private static final long serialVersionUID = -7474858524789025564L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "discount_id", updatable = false)
	@JsonIgnore
	private Discount discount;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "orderline_id", updatable = false)
	@JsonIgnore
	private Orderline orderline;
	
	@Column(name = "amount")
	private Double amount;
	
	public OrderlineDiscount() {
		
	}
	
	public OrderlineDiscount(Orderline orderline, Discount discount) {
		this.orderline = orderline;
		this.discount = discount;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public OrderlineDiscount setId(String id) {
		return this;
	}

	public Discount getDiscount() {
		return discount;
	}

	public OrderlineDiscount setDiscount(Discount discount) {
		this.discount = discount;
		return this;
	}

	public Orderline getOrderline() {
		return orderline;
	}

	public OrderlineDiscount setOrderline(Orderline orderline) {
		this.orderline = orderline;
		orderline.setOrderlineDiscount(this);
		return this;
	}

	public Double getAmount() {
		return amount;
	}

	public OrderlineDiscount setAmount(Double amount) {
		this.amount = amount;
		return this;
	}
}
