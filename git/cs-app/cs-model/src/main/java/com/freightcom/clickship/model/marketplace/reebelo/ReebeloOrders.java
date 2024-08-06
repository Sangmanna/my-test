package com.freightcom.clickship.model.marketplace.reebelo;

import java.util.List;

public class ReebeloOrders {
	private List<ReebeloOrder> orders;
	private int count;
	private int totalPages;
	private boolean hasNextPage;

	public List<ReebeloOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ReebeloOrder> orders) {
		this.orders = orders;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
}
