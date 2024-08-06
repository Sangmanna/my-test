package com.freightcom.clickship.model.mandrill;

import java.io.Serializable;

public class MandrillOrderline  implements Serializable {
	
	private static final long serialVersionUID = -3439853765171334288L;

	private Integer quantity;
	
	private String productSku;
	
	private String productTitle;
	
	private String productImageUrl;
	
	private String price;
	
	private String currency;

	public Integer getQuantity() {
		return quantity;
	}

	public MandrillOrderline setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getProductSku() {
		return productSku;
	}

	public MandrillOrderline setProductSku(String productSku) {
		this.productSku = productSku;
		return this;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public MandrillOrderline setProductTitle(String productTitle) {
		this.productTitle = productTitle;
		return this;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public MandrillOrderline setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
		return this;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
