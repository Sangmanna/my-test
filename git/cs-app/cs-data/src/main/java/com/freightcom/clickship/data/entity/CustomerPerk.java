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
@Table(name = "customer_perks")
public class CustomerPerk extends BaseEntity {

	private static final long serialVersionUID = -7426739929586242653L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "perk_id")
	@JsonIgnore
	private Perks perks;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "perk_enabled", nullable = false, updatable = false)
	private boolean perkEnabled = true;

	public Customer getCustomer() {
		return customer;
	}

	public Perks getPerks() {
		return perks;
	}

	public void setPerks(Perks perks) {
		this.perks = perks;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public boolean isPerkEnabled() {
		return perkEnabled;
	}

	public CustomerPerk setPerkEnabled(boolean perkEnabled) {
		this.perkEnabled = perkEnabled;
		return this;
	}
	
	

}

