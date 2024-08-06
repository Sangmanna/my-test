package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoProductStockItem implements Serializable {
	
	private static final long serialVersionUID = -930189583369238187L;

	@JsonProperty("product_id")
	private String productId;
	
	@JsonProperty("qty")
	private Integer quantity;

	public String getProductId() {
		return productId;
	}

	public MagentoProductStockItem setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public MagentoProductStockItem setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

}
