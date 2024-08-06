package com.freightcom.clickship.model.order;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.product.MarketplaceProductDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class OrderlineDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = 2970228996741741726L;

	private int quantity;
	
	private String originalOrderlineId;

	private MarketplaceProductDTO orderMarketplaceProduct;

	public OrderlineDTO() {
		super();
	}

	public MarketplaceProductDTO getOrderMarketplaceProduct() {
		return orderMarketplaceProduct;
	}

	public OrderlineDTO setOrderMarketpalceProduct(MarketplaceProductDTO orderMarketplaceProduct) {
		this.orderMarketplaceProduct = orderMarketplaceProduct;
		return this;
	}

	public String getOriginalItemId() {
		return originalOrderlineId;
	}

	public OrderlineDTO setOriginalItemId(String originalItemId) {
		this.originalOrderlineId = originalItemId;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public OrderlineDTO setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
}