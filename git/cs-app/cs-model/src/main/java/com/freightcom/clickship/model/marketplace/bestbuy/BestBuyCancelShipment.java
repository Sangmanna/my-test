package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyCancelShipment {
	
	@JsonProperty("shipments")
	private List<CancelBestBuyShipment> cancelShipment;

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CancelBestBuyShipment{
		
		@JsonProperty("id")
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		
	}

	public List<CancelBestBuyShipment> getCancelShipment() {
		return cancelShipment;
	}

	public void setCancelShipment(List<CancelBestBuyShipment> cancelShipment) {
		this.cancelShipment = cancelShipment;
	}
	
	

}
