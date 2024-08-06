package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyShipping  implements Serializable {

	private static final long serialVersionUID = 6420328808663312948L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("source")
	private String source;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("title")
	private String service;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("tax_lines")
	private List<ShopifyTax> taxes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<ShopifyTax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<ShopifyTax> taxes) {
		this.taxes = taxes;
	}
	
}
