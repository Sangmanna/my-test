package com.freightcom.clickship.data.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "discount")
public class Discount extends BaseEntity {
	
	private static final long serialVersionUID = -7253428556737874075L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, updatable = false)
	@JsonIgnore
	private Order order;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "value")
	private Double value;
	
	@Column(name = "value_type")
	private String valueType;
	
	@Column(name = "allocation_method")
	private String allocationMethod;
	
	@Column(name = "target_selection")
	private String targetSelection;
	
	@Column(name = "target_type")
	private String targetType;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "discount", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<OrderlineDiscount> orderlineDiscountList;
	
	public Discount() {

	}

	public Discount(Order order) {
		this.order = order;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public Discount setId(String id) {
		this.id = id;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public Discount setOrder(Order order) {
		this.order = order;
		return this;
	}

	public String getType() {
		return type;
	}

	public Discount setType(String type) {
		this.type = type;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Discount setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getCode() {
		return code;
	}

	public Discount setCode(String code) {
		this.code = code;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Discount setDescription(String description) {
		this.description = description;
		return this;
	}

	public Double getValue() {
		return value;
	}

	public Discount setValue(Double value) {
		this.value = value;
		return this;
	}

	public String getValueType() {
		return valueType;
	}

	public Discount setValueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	public String getAllocationMethod() {
		return allocationMethod;
	}

	public Discount setAllocationMethod(String allocationMethod) {
		this.allocationMethod = allocationMethod;
		return this;
	}

	public String getTargetSelection() {
		return targetSelection;
	}

	public Discount setTargetSelection(String targetSelection) {
		this.targetSelection = targetSelection;
		return this;
	}

	public String getTargetType() {
		return targetType;
	}

	public Discount setTargetType(String targetType) {
		this.targetType = targetType;
		return this;
	}

	public List<OrderlineDiscount> getOrderlineDiscountList() {
		return orderlineDiscountList;
	}

	public Discount setOrderlineDiscountList(List<OrderlineDiscount> orderlineDiscountList) {
		this.orderlineDiscountList = orderlineDiscountList;
		return this;
	}
}
