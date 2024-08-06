package com.freightcom.clickship.model.marketplace.walmart;

import com.freightcom.clickship.model.marketplace.walmart.items.ItemResponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ItemResponses")
@XmlAccessorType(XmlAccessType.FIELD)
public class WalmartItemResponse {

	@XmlElement(name = "errors")
	private List<String> errors;

	@XmlElement(name = "ItemResponse")
	private List<ItemResponse> itemResponse;

	@XmlElement(name = "totalItems")
	private Integer totalItems;

	@XmlElement(name = "nextCursor")
	private String nextCursor;

	public List<ItemResponse> getItemResponse() {
		return itemResponse;
	}

	public void setItemResponse(List<ItemResponse> itemResponse) {
		this.itemResponse = itemResponse;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public String getNextCursor() {
		return nextCursor;
	}

	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}
}
