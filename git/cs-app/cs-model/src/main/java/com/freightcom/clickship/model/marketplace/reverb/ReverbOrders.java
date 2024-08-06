package com.freightcom.clickship.model.marketplace.reverb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ReverbOrders {
	@JsonProperty("total")
	private int total;
	@JsonProperty("current_page")
	private int currentPage;
	@JsonProperty("total_pages")
	private int totalPages;
	@JsonProperty("orders")
	private List<ReverbOrder> orders;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<ReverbOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<ReverbOrder> orders) {
		this.orders = orders;
	}
	
}
