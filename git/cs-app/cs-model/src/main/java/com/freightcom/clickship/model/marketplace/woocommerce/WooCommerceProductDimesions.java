package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceProductDimesions implements Serializable {
	
	private static final long serialVersionUID = -4978540155977829087L;

	private double width;
	
	private double height;
	
	private double length;

	public Double getWidth() {
		return width;
	}

	public WooCommerceProductDimesions setWidth(double width) {
		this.width = width;
		return this;
	}

	public Double getHeight() {
		return height;
	}

	public WooCommerceProductDimesions setHeight(double height) {
		this.height = height;
		return this;
	}

	public Double getLength() {
		return length;
	}

	public WooCommerceProductDimesions setLength(double length) {
		this.length = length;
		return this;
	}

}