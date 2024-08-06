package com.freightcom.clickship.model.marketplace.reebelo;

import java.util.List;

public class ReebeloLineItems {
	private String id;
	private int quantity;
	private List<String> imeiNumbers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<String> getImeiNumbers() {
		return imeiNumbers;
	}

	public void setImeiNumbers(List<String> imeiNumbers) {
		this.imeiNumbers = imeiNumbers;
	}
}
