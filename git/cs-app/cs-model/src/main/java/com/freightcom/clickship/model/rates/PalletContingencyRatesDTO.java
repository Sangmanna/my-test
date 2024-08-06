package com.freightcom.clickship.model.rates;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class PalletContingencyRatesDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -6647051403664748818L;

	private String id;
	
	private String name;
	
	private double rate = 0d;
	
	private String currency = "CAD";
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}