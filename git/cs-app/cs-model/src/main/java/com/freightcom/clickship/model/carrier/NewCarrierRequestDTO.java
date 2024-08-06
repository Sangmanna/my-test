package com.freightcom.clickship.model.carrier;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewCarrierRequestDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 4447758126357329796L;
	
	private String name;
	
	private String email;
	
	private List<String> carriers;

	public String getName() {
		return name;
	}

	public NewCarrierRequestDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public NewCarrierRequestDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public List<String> getCarriers() {
		return carriers;
	}

	public NewCarrierRequestDTO setCarriers(List<String> carriers) {
		this.carriers = carriers;
		return this;
	}

}
