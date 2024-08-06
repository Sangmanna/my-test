package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyOrder {

	@JsonProperty("orders")
	private List<BestBuyOrders> orders;
	
	@JsonProperty("total_count")
	private int totalCount;

	public List<BestBuyOrders> getOrders() {
		return orders;
	}

	public void setOrders(List<BestBuyOrders> orders) {
		this.orders = orders;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	

}
