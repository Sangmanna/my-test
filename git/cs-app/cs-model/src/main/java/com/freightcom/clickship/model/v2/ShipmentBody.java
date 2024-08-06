package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ShipmentBody
 */

public class ShipmentBody {
	@JsonProperty("payment_method_id")
	private String paymentMethodId = null;

	@JsonProperty("billing_currency")
	private String billingCurrency = null;

	@JsonProperty("service_id")
	private String serviceId = null;

	@JsonProperty("details")
	private ShippingDetails details = null;

	@JsonProperty("customs_invoice")
	private ShipmentCustomsInvoice customsInvoice = null;

	@JsonProperty("pickup_details")
	private PickupDetails pickupDetails = null;

	@JsonProperty("dispatch_details")
	private DispatchDetails dispatchDetails = null;
	
	@JsonProperty("order_source")
	private String orderSource = "CS-Manual";
	
	@JsonProperty("rate_request_id")
	private String rateRequestId;

	public ShipmentBody paymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
		return this;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public ShipmentBody billingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
		return this;
	}

	public String getBillingCurrency() {
		return billingCurrency;
	}

	public void setBillingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
	}

	public ShipmentBody serviceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public ShipmentBody details(ShippingDetails details) {
		this.details = details;
		return this;
	}

	public ShippingDetails getDetails() {
		return details;
	}

	public void setDetails(ShippingDetails details) {
		this.details = details;
	}

	public ShipmentBody customsInvoice(ShipmentCustomsInvoice customsInvoice) {
		this.customsInvoice = customsInvoice;
		return this;
	}

	public ShipmentCustomsInvoice getCustomsInvoice() {
		return customsInvoice;
	}

	public void setCustomsInvoice(ShipmentCustomsInvoice customsInvoice) {
		this.customsInvoice = customsInvoice;
	}

	public ShipmentBody pickupDetails(PickupDetails pickupDetails) {
		this.pickupDetails = pickupDetails;
		return this;
	}

	public PickupDetails getPickupDetails() {
		return pickupDetails;
	}

	public void setPickupDetails(PickupDetails pickupDetails) {
		this.pickupDetails = pickupDetails;
	}

	public ShipmentBody dispatchDetails(DispatchDetails dispatchDetails) {
		this.dispatchDetails = dispatchDetails;
		return this;
	}

	public DispatchDetails getDispatchDetails() {
		return dispatchDetails;
	}

	public void setDispatchDetails(DispatchDetails dispatchDetails) {
		this.dispatchDetails = dispatchDetails;
	}
	
	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}	

	public String getRateRequestId() {
		return rateRequestId;
	}

	public void setRateRequestId(String rateRequestId) {
		this.rateRequestId = rateRequestId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShipmentBody shipmentBody = (ShipmentBody) o;
		return Objects.equals(this.paymentMethodId, shipmentBody.paymentMethodId)
				&& Objects.equals(this.billingCurrency, shipmentBody.billingCurrency)
				&& Objects.equals(this.serviceId, shipmentBody.serviceId)
				&& Objects.equals(this.details, shipmentBody.details)
				&& Objects.equals(this.customsInvoice, shipmentBody.customsInvoice)
				&& Objects.equals(this.pickupDetails, shipmentBody.pickupDetails)
				&& Objects.equals(this.dispatchDetails, shipmentBody.dispatchDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(paymentMethodId, billingCurrency, serviceId, details, customsInvoice, pickupDetails,
				dispatchDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShipmentBody {\n");

		sb.append("    paymentMethodId: ").append(toIndentedString(paymentMethodId)).append("\n");
		sb.append("    billingCurrency: ").append(toIndentedString(billingCurrency)).append("\n");
		sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
		sb.append("    details: ").append(toIndentedString(details)).append("\n");
		sb.append("    customsInvoice: ").append(toIndentedString(customsInvoice)).append("\n");
		sb.append("    pickupDetails: ").append(toIndentedString(pickupDetails)).append("\n");
		sb.append("    dispatchDetails: ").append(toIndentedString(dispatchDetails)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
