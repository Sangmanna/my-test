package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceImages implements Serializable{
	
	private static final long serialVersionUID = 4615328041552945498L;

	private Long id;
	
	private String name;
	
	private String alt;
	
	private String src;

	public Long getId() {
		return id;
	}

	public WooCommerceImages setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public WooCommerceImages setName(String name) {
		this.name = name;
		return this;
	}

	public String getAlt() {
		return alt;
	}

	public WooCommerceImages setAlt(String alt) {
		this.alt = alt;
		return this;
	}

	public String getSrc() {
		return src;
	}

	public WooCommerceImages setSrc(String src) {
		this.src = src;
		return this;
	}
}