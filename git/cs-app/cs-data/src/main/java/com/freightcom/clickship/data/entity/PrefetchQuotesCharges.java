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
@Table(name = "prefetch_quote_charges")
public class PrefetchQuotesCharges extends BaseEntity {

	private static final long serialVersionUID = 7537764466297132877L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prefetch_quote_id")
	@JsonIgnore
	private PrefetchQuotes prefetchQuotes;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "charge")
	private Double charge;

	@Column(name = "currency")
	private String currency;

	public String getId() {
		return id;
	}

	public PrefetchQuotesCharges setId(String id) {
		this.id = id;
		return this;
	}

	public PrefetchQuotes getPrefetchQuotes() {
		return prefetchQuotes;
	}

	public PrefetchQuotesCharges setPrefetchQuotes(PrefetchQuotes prefetchQuotes) {
		this.prefetchQuotes = prefetchQuotes;
		return this;
	}

	public String getName() {
		return name;
	}

	public PrefetchQuotesCharges setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public PrefetchQuotesCharges setDescription(String description) {
		this.description = description;
		return this;
	}

	public Double getCharge() {
		return charge;
	}

	public PrefetchQuotesCharges setCharge(Double charge) {
		this.charge = charge;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public PrefetchQuotesCharges setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

}
