package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingAssignments implements Serializable {

	private static final long serialVersionUID = -4690834936885040478L;
	
	@JsonProperty("shipping")
	private MagentoShipping shipping;
	
	@JsonProperty("items")
	private List<MagentoOrderItem> items;
	
	@JsonProperty("total_count")
	private int totalShipmentsCount;

	public MagentoShipping getShipping() {
		return shipping;
	}

	public ShippingAssignments setShipping(MagentoShipping shipping) {
		this.shipping = shipping;
		return this;
	}
	
	public List<MagentoOrderItem> getItems() {
		return items;
	}

	public ShippingAssignments setItems(List<MagentoOrderItem> items) {
		this.items = items;
		return this;
	}

	public int getTotalShipmentsCount() {
		return totalShipmentsCount;
	}

	public void setTotalShipmentsCount(int totalShipmentsCount) {
		this.totalShipmentsCount = totalShipmentsCount;
	}
	
}
