package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductExtensionAttributes implements Serializable {

	private static final long serialVersionUID = 5981241398846795042L;

	@JsonProperty("stock_item")
	private MagentoProductStockItem item;

	public MagentoProductStockItem getItem() {
		return item;
	}

	public ProductExtensionAttributes setItem(MagentoProductStockItem item) {
		this.item = item;
		return this;
	}
	
}
