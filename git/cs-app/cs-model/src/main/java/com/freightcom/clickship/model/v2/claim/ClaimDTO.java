package com.freightcom.clickship.model.v2.claim;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.v2.Contact;
import com.freightcom.clickship.model.v2.FreightcomDateDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaimDTO extends CommonDTO {
	private String id;
	
	private String csOrderId;

	@JsonProperty("customer_id")
	private String customerId;

	@JsonProperty("shipment_id")
	private String shipmentId;

	private String type; // "missing", "damaged"
	private String name;
	private String state;

	@JsonProperty("shipment_verified")
	private boolean shipmentVerified;

	private Contact contact;

	@JsonProperty("damaged_properties")
	private DamagedPropertiesDTO damagedProperties;

	@JsonProperty("missing_properties")
	private MissingPropertiesDTO missingProperties;

	private ClaimPaymentDTO payout;

	@JsonProperty("payout_accepted")
	private boolean payoutAccepted;

	@JsonProperty("shipping_details")
	public ShippingDetails shippingDetails;

	@JsonProperty("ship_date")
	private FreightcomDateDTO shipDate;

	@JsonProperty("primary_tracking_number")
	private String primaryTrackingNumber;

	@JsonProperty("carrier_id")
	private String carrierId;

	@JsonProperty("service_id")
	private String serviceId;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("submitted_at")
	private Date submittedAt;
	
	@JsonProperty("expires_on")
	private FreightcomDateDTO expiresOn;
	
	@JsonProperty("num_new_admin_messages")
	private int num_new_admin_messages;

	public String getId() {
		return id;
	}

	public ClaimDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getCsOrderId() {
		return csOrderId;
	}

	public ClaimDTO setCsOrderId(String csOrderId) {
		this.csOrderId = csOrderId;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public ClaimDTO setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public ClaimDTO setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public String getType() {
		return type;
	}

	public ClaimDTO setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public ClaimDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getState() {
		return state;
	}

	public ClaimDTO setState(String state) {
		this.state = state;
		return this;
	}

	public boolean isShipmentVerified() {
		return shipmentVerified;
	}

	public ClaimDTO setShipmentVerified(boolean shipmentVerified) {
		this.shipmentVerified = shipmentVerified;
		return this;
	}

	public Contact getContact() {
		return contact;
	}

	public ClaimDTO setContact(Contact contact) {
		this.contact = contact;
		return this;
	}

	public DamagedPropertiesDTO getDamagedProperties() {
		return damagedProperties;
	}

	public ClaimDTO setDamagedProperties(DamagedPropertiesDTO damagedProperties) {
		this.damagedProperties = damagedProperties;
		return this;
	}

	public MissingPropertiesDTO getMissingProperties() {
		return missingProperties;
	}

	public ClaimDTO setMissingProperties(MissingPropertiesDTO missingProperties) {
		this.missingProperties = missingProperties;
		return this;
	}

	public ClaimPaymentDTO getPayout() {
		return payout;
	}

	public ClaimDTO setPayout(ClaimPaymentDTO payout) {
		this.payout = payout;
		return this;
	}

	public boolean isPayoutAccepted() {
		return payoutAccepted;
	}

	public ClaimDTO setPayoutAccepted(boolean payoutAccepted) {
		this.payoutAccepted = payoutAccepted;
		return this;
	}

	public ShippingDetails getShippingDetails() {
		return shippingDetails;
	}

	public ClaimDTO setShippingDetails(ShippingDetails shippingDetails) {
		this.shippingDetails = shippingDetails;
		return this;
	}

	public FreightcomDateDTO getShipDate() {
		return shipDate;
	}

	public ClaimDTO setShipDate(FreightcomDateDTO shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	public String getPrimaryTrackingNumber() {
		return primaryTrackingNumber;
	}

	public ClaimDTO setPrimaryTrackingNumber(String primaryTrackingNumber) {
		this.primaryTrackingNumber = primaryTrackingNumber;
		return this;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public ClaimDTO setCarrierId(String carrierId) {
		this.carrierId = carrierId;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public ClaimDTO setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public ClaimDTO setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public ClaimDTO setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public Date getSubmittedAt() {
		return submittedAt;
	}

	public ClaimDTO setSubmittedAt(Date submittedAt) {
		this.submittedAt = submittedAt;
		return this;
	}

	public FreightcomDateDTO getExpiresOn() {
		return expiresOn;
	}

	public ClaimDTO setExpiresOn(FreightcomDateDTO expiresOn) {
		this.expiresOn = expiresOn;
		return this;
	}

	public int getNum_new_admin_messages() {
		return num_new_admin_messages;
	}

	public ClaimDTO setNum_new_admin_messages(int num_new_admin_messages) {
		this.num_new_admin_messages = num_new_admin_messages;
		return this;
	}
	
}
