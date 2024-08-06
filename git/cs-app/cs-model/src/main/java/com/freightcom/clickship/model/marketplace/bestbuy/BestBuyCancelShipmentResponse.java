package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyCancelShipmentResponse {

	@JsonProperty("shipments")
	private List<CancelShipmentSuccess> cancelShipmentSuccess;

	@JsonProperty("shipment_errors")
	private List<CancelShipmentErrors> cancelShipmentErrors;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class CancelShipmentSuccess {

		@JsonProperty("id")
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class CancelShipmentErrors {

		@JsonProperty("id")
		private String id;

		@JsonProperty("message")
		private String message;
		
		@Override
		public String toString() {
			return "CancelShipmentErrors [message=" + message + ", orderId=" + id + "]";
		}
	}

	public List<CancelShipmentSuccess> getCancelShipmentSuccess() {
		return cancelShipmentSuccess;
	}

	public void setCancelShipmentSuccess(List<CancelShipmentSuccess> cancelShipmentSuccess) {
		this.cancelShipmentSuccess = cancelShipmentSuccess;
	}

	public List<CancelShipmentErrors> getCancelShipmentErrors() {
		return cancelShipmentErrors;
	}

	public void setCancelShipmentErrors(List<CancelShipmentErrors> cancelShipmentErrors) {
		this.cancelShipmentErrors = cancelShipmentErrors;
	}

	

}
