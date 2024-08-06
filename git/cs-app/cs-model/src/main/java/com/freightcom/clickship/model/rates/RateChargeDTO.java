package com.freightcom.clickship.model.rates;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class RateChargeDTO  extends CommonDTO implements Serializable {
	private static final long serialVersionUID = -8060271154494787667L;
	private String description;
	private Double charge;
	private String currency;
	private String name;
	
	public String getDescription() {
		return description;
	}
	public RateChargeDTO setDescription(String description) {
		this.description = description;
		return this;
	}
	public Double getCharge() {
		return charge;
	}
	public RateChargeDTO setCharge(Double charge) {
		this.charge = charge;
		return this;
	}
	public String getCurrency() {
		return currency;
	}
	public RateChargeDTO setCurrency(String currency) {
		this.currency = currency;
		return this;
	}
	public String getName() {
		return name;
	}
	public RateChargeDTO setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String toString() {
		return name + ":" + charge + " " + currency;
	}	
	
}
