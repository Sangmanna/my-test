package com.freightcom.clickship.model.carrier.freightcom.v2;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FCPhoneNumber implements Serializable {
	
	private static final long serialVersionUID = 7990916340381799107L;

	@JsonProperty("number")
	private String number;

	@JsonProperty("extension")
	private String extension;

	public FCPhoneNumber number(String number) {
		this.number = number;
		return this;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public FCPhoneNumber extension(String extension) {
		this.extension = extension;
		return this;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}
