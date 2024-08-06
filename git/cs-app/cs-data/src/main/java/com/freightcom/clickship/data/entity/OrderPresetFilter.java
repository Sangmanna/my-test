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
@Table(name = "order_preset_filter")
public class OrderPresetFilter extends BaseEntity {

	private static final long serialVersionUID = -6564787249634263473L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@Column(name="store_names")
	private String storeNames;
	
	@Column(name="from_date")
	private String fromDate;
		
	@Column(name="to_date")
	private String toDate;
		
	@Column(name="order_type")
	private String orderType;
		
	@Column(name="destination")
	private String destination;
	
	@Column(name="preset_name")
	private String presetName;
	
	@Column(name="search_value")
	private String searchValue;
	
	@Column(name="tag")
	private String tag;

	public String getId() {
		return id;
	}

	public OrderPresetFilter setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public OrderPresetFilter setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getStoreNames() {
		return storeNames;
	}

	public OrderPresetFilter setStoreNames(String storeNames) {
		this.storeNames = storeNames;
		return this;
	}

	public String getFromDate() {
		return fromDate;
	}

	public OrderPresetFilter setFromDate(String fromDate) {
		this.fromDate = fromDate;
		return this;
	}

	public String getToDate() {
		return toDate;
	}

	public OrderPresetFilter setToDate(String toDate) {
		this.toDate = toDate;
		return this;
	}

	public String getOrderType() {
		return orderType;
	}

	public OrderPresetFilter setOrderType(String orderType) {
		this.orderType = orderType;
		return this;
	}

	public String getDestination() {
		return destination;
	}

	public OrderPresetFilter setDestination(String destination) {
		this.destination = destination;
		return this;
	}

	public String getPresetName() {
		return presetName;
	}

	public OrderPresetFilter setPresetName(String presetName) {
		this.presetName = presetName;
		return this;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public OrderPresetFilter setSearchValue(String searchValue) {
		this.searchValue = searchValue;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}