package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillmentOrderWebhook implements Serializable {
	
	private static final long serialVersionUID = 2805654709137715900L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("reason")
	private String reason;
	
	@JsonProperty("preparable")
	private boolean preparable;
	
	@JsonProperty("reason_notes")
	private String reasonNotes;
	
	@JsonProperty("request_status")
	private String requestStatus;
	
	@JsonProperty("new_location_id")
	private Long newLocationId;
	
	@JsonProperty("fulfillment_order_id")
	private String fulfillmentOrderId;
	
	@JsonProperty("assigned_location_id")
	private String assignedLocationId;
	
	@JsonProperty("destination_location_id")
	private String destinationLocationId;
	
	@JsonProperty("delivery_method")
	private ShopifyDeliveryMethod deliveryMethod;
	
	@JsonProperty("fulfillment_order")
	private ShopifyFulfillmentOrderWebhook fulfillmentOrder;
	
	@JsonProperty("moved_fulfillment_order")
	private ShopifyFulfillmentOrderWebhook movedFulfillmentOrder;
	
	@JsonProperty("fulfillment_holds")
	private List<ShopifyFulfillmentOrderWebhook> fulfillmentHolds;
	
	@JsonProperty("fulfillment_order_merchant_request")
	private ShopifyFulfillmentOrderWebhook fulfillmentOrderMerchant;
	
	@JsonProperty("original_fulfillment_order")
	private ShopifyFulfillmentOrderWebhook originalFulfillmentOrder;
	
	@JsonProperty("remaining_fulfillment_order")
	private ShopifyFulfillmentOrderWebhook remainingFulfillmentOrder;
	
	@JsonProperty("submitted_fulfillment_order")
	private ShopifyFulfillmentOrderWebhook submittedFulfillmentOrder;
	
	@JsonProperty("replacement_fulfillment_order")
	private ShopifyFulfillmentOrderWebhook fulfillmentOrderReplacement;
	
	@JsonProperty("merge_intents")
	private List<ShopifyFulfillmentOrderWebhook> mergeIntents;
	
	@JsonProperty("fulfill_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date fulfillAt;

	public String getId() {
		return id;
	}

	public ShopifyFulfillmentOrderWebhook setId(String id) {
		this.id = id;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public ShopifyFulfillmentOrderWebhook setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ShopifyFulfillmentOrderWebhook setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getReason() {
		return reason;
	}

	public ShopifyFulfillmentOrderWebhook setReason(String reason) {
		this.reason = reason;
		return this;
	}

	public boolean isPreparable() {
		return preparable;
	}

	public ShopifyFulfillmentOrderWebhook setPreparable(boolean preparable) {
		this.preparable = preparable;
		return this;
	}

	public String getReasonNotes() {
		return reasonNotes;
	}

	public ShopifyFulfillmentOrderWebhook setReasonNotes(String reasonNotes) {
		this.reasonNotes = reasonNotes;
		return this;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public ShopifyFulfillmentOrderWebhook setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
		return this;
	}

	public String getAssignedLocationId() {
		return assignedLocationId;
	}

	public ShopifyFulfillmentOrderWebhook setAssignedLocationId(String assignedLocationId) {
		this.assignedLocationId = assignedLocationId;
		return this;
	}

	public String getDestinationLocationId() {
		return destinationLocationId;
	}

	public ShopifyFulfillmentOrderWebhook setDestinationLocationId(String destinationLocationId) {
		this.destinationLocationId = destinationLocationId;
		return this;
	}

	public ShopifyDeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public ShopifyFulfillmentOrderWebhook setDeliveryMethod(ShopifyDeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
		return this;
	}

	public ShopifyFulfillmentOrderWebhook getFulfillmentOrder() {
		return fulfillmentOrder;
	}

	public ShopifyFulfillmentOrderWebhook setFulfillmentOrder(ShopifyFulfillmentOrderWebhook fulfillmentOrder) {
		this.fulfillmentOrder = fulfillmentOrder;
		return this;
	}

	public ShopifyFulfillmentOrderWebhook getMovedFulfillmentOrder() {
		return movedFulfillmentOrder;
	}

	public ShopifyFulfillmentOrderWebhook setMovedFulfillmentOrder(ShopifyFulfillmentOrderWebhook movedFulfillmentOrder) {
		this.movedFulfillmentOrder = movedFulfillmentOrder;
		return this;
	}

	public List<ShopifyFulfillmentOrderWebhook> getFulfillmentHolds() {
		return fulfillmentHolds;
	}

	public ShopifyFulfillmentOrderWebhook setFulfillmentHolds(List<ShopifyFulfillmentOrderWebhook> fulfillmentHolds) {
		this.fulfillmentHolds = fulfillmentHolds;
		return this;
	}

	public ShopifyFulfillmentOrderWebhook getFulfillmentOrderMerchant() {
		return fulfillmentOrderMerchant;
	}

	public ShopifyFulfillmentOrderWebhook setFulfillmentOrderMerchant(ShopifyFulfillmentOrderWebhook fulfillmentOrderMerchant) {
		this.fulfillmentOrderMerchant = fulfillmentOrderMerchant;
		return this;
	}

	public ShopifyFulfillmentOrderWebhook getOriginalFulfillmentOrder() {
		return originalFulfillmentOrder;
	}

	public ShopifyFulfillmentOrderWebhook setOriginalFulfillmentOrder(ShopifyFulfillmentOrderWebhook originalFulfillmentOrder) {
		this.originalFulfillmentOrder = originalFulfillmentOrder;
		return this;
	}
	
	public ShopifyFulfillmentOrderWebhook getRemainingFulfillmentOrder() {
		return remainingFulfillmentOrder;
	}

	public void setRemainingFulfillmentOrder(ShopifyFulfillmentOrderWebhook remainingFulfillmentOrder) {
		this.remainingFulfillmentOrder = remainingFulfillmentOrder;
	}

	public ShopifyFulfillmentOrderWebhook getSubmittedFulfillmentOrder() {
		return submittedFulfillmentOrder;
	}

	public ShopifyFulfillmentOrderWebhook setSubmittedFulfillmentOrder(ShopifyFulfillmentOrderWebhook submittedFulfillmentOrder) {
		this.submittedFulfillmentOrder = submittedFulfillmentOrder;
		return this;
	}

	public ShopifyFulfillmentOrderWebhook getFulfillmentOrderReplacement() {
		return fulfillmentOrderReplacement;
	}

	public ShopifyFulfillmentOrderWebhook setFulfillmentOrderReplacement(ShopifyFulfillmentOrderWebhook fulfillmentOrderReplacement) {
		this.fulfillmentOrderReplacement = fulfillmentOrderReplacement;
		return this;
	}

	public Date getFulfillAt() {
		return fulfillAt;
	}

	public ShopifyFulfillmentOrderWebhook setFulfillAt(Date fulfillAt) {
		this.fulfillAt = fulfillAt;
		return this;
	}

	public Long getNewLocationId() {
		return newLocationId;
	}

	public ShopifyFulfillmentOrderWebhook setNewLocationId(Long newLocationId) {
		this.newLocationId = newLocationId;
		return this;
	}

	public String getFulfillmentOrderId() {
		return fulfillmentOrderId;
	}

	public ShopifyFulfillmentOrderWebhook setFulfillmentOrderId(String fulfillmentOrderId) {
		this.fulfillmentOrderId = fulfillmentOrderId;
		return this;
	}

	public List<ShopifyFulfillmentOrderWebhook> getMergeIntents() {
		return mergeIntents;
	}

	public ShopifyFulfillmentOrderWebhook setMergeIntents(List<ShopifyFulfillmentOrderWebhook> mergeIntents) {
		this.mergeIntents = mergeIntents;
		return this;
	}

}
