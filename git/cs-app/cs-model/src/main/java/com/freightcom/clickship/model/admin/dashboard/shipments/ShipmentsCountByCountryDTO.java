package com.freightcom.clickship.model.admin.dashboard.shipments;

import java.math.BigInteger;

public class ShipmentsCountByCountryDTO {

	private String country;

	private String provinceState;

	private BigInteger count;

	public ShipmentsCountByCountryDTO(Object[] columns) {
		super();
		this.country = (String) columns[0];
		this.provinceState = (String) columns[1];
		this.count = (BigInteger) columns[2];
	}

	public ShipmentsCountByCountryDTO(String country, String provinceState, Long count) {
		super();
		this.country = country;
		this.provinceState = provinceState;
		this.count = BigInteger.valueOf(count);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public void setProvinceState(String provinceState) {
		this.provinceState = provinceState;
	}

	public int getCount() {
		return count.intValueExact();
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

}
