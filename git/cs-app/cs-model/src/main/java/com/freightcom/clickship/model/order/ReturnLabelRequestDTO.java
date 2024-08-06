package com.freightcom.clickship.model.order;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class ReturnLabelRequestDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;

	public String getEmail() {
		return email;
	}

	public ReturnLabelRequestDTO setEmail(String email) {
		this.email = email;
		return this;
	}

}
