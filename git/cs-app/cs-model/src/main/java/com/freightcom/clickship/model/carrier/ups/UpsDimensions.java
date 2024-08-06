package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsDimensions implements Serializable {

	private static final long serialVersionUID = -1179770470020072009L;
	
	@JsonProperty("Height")
	private String height;
	
	@JsonProperty("Length")
	private String length;
	
	@JsonProperty("Width")
	private String width;
	
	@JsonProperty("UnitOfMeasurement")
	private CodeDescription description;

	public String getHeight() {
		return height;
	}

	public UpsDimensions setHeight(String height) {
		this.height = height;
		return this;
	}

	public String getLength() {
		return length;
	}

	public UpsDimensions setLength(String length) {
		this.length = length;
		return this;
	}

	public String getWidth() {
		return width;
	}

	public UpsDimensions setWidth(String width) {
		this.width = width;
		return this;
	}

	public CodeDescription getDescription() {
		return description;
	}

	public void setDescription(CodeDescription description) {
		this.description = description;
	}

}
