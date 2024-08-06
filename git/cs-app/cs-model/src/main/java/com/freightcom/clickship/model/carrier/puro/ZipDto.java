package com.freightcom.clickship.model.carrier.puro;

import java.io.Serializable;

public class ZipDto implements Serializable {

	private static final long serialVersionUID = -4245920275034803850L;

	private String city;

	private String provinceState;
	
	private String country;

	private String postalCode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public void setProvinceState(String provinceState) {
		this.provinceState = provinceState;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
