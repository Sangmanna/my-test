package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate extends BaseEntity {

	private static final long serialVersionUID = 6117890812437884155L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class )
	@Column(name = "id", nullable = false, updatable = false)	
	private String id;
	
	@Column(name = "currency_unit", nullable = false)
	private String currencyUnit;

	@Column(name = "rate", nullable = false)
	private String rate;
	
	@Column(name = "dateStr", nullable = false)
	private String dateStr;

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public ExchangeRate setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public ExchangeRate setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
		return this;
	}

	public String getRate() {
		return rate;
	}

	public ExchangeRate setRate(String rate) {
		this.rate = rate;
		return this;
	}

	public String getDateStr() {
		return dateStr;
	}

	public ExchangeRate setDateStr(String dateStr) {
		this.dateStr = dateStr;
		return this;
	}
}
