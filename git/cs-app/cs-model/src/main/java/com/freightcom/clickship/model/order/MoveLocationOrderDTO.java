package com.freightcom.clickship.model.order;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoveLocationOrderDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -7615014466758386128L;

	private String orderId;
	
	private String marketplaceId;
	
	private String newLocationId;
	
	private String prevLocationId;
	
	private List<OrderlineDTO> lineItems;
	
	private String successMessage;
	
	private String errorMessage;

	public String getOrderId() {
		return orderId;
	}

	public MoveLocationOrderDTO setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public MoveLocationOrderDTO setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	public String getNewLocationId() {
		return newLocationId;
	}

	public MoveLocationOrderDTO setNewLocationId(String newLocationId) {
		this.newLocationId = newLocationId;
		return this;
	}

	public String getPrevLocationId() {
		return prevLocationId;
	}

	public MoveLocationOrderDTO setPrevLocationId(String prevLocationId) {
		this.prevLocationId = prevLocationId;
		return this;
	}

	public List<OrderlineDTO> getLineItems() {
		return lineItems;
	}

	public MoveLocationOrderDTO setLineItems(List<OrderlineDTO> lineItems) {
		this.lineItems = lineItems;
		return this;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public MoveLocationOrderDTO setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public MoveLocationOrderDTO setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	
}