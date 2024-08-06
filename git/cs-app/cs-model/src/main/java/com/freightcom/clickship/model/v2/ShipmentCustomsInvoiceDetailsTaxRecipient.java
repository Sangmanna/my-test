package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class ShipmentCustomsInvoiceDetailsTaxRecipient {
	/**
	 * Gets or Sets type
	 */
	public enum TypeEnum {
		SHIPPER("shipper"),

		RECEIVER("receiver"),
		
		THIRD_PARTY("third-party"),
		
		OTHER("other");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TypeEnum fromValue(String text) {
			for (TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("type")
	private TypeEnum type = null;

	@JsonProperty("shipper_tax_identifier")
	private String shipperTaxIdentifier = null;

	@JsonProperty("receiver_tax_identifier")
	private String receiverTaxIdentifier = null;
	
	@JsonProperty("third_party_tax_identifier")
	private String thirdPartyTaxIdentifier = null;

	@JsonProperty("other_tax_identifier")
	private String otherTaxIdentifier = null;

	@JsonProperty("reason_for_export")
	private String reasonForExport = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("address")
	private Address address = null;

	@JsonProperty("phone_number")
	private PhoneNumber phoneNumber = null;
	
	@JsonProperty("additional_remarks")
	private String additionalRemarks = null;
	
	

	public String getAdditionalRemarks() {
		return additionalRemarks;
	}

	public void setAdditionalRemarks(String additionalRemarks) {
		this.additionalRemarks = additionalRemarks;
	}

	public ShipmentCustomsInvoiceDetailsTaxRecipient type(TypeEnum type) {
		this.type = type;
		return this;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public ShipmentCustomsInvoiceDetailsTaxRecipient shipperTaxIdentifier(String shipperTaxIdentifier) {
		this.shipperTaxIdentifier = shipperTaxIdentifier;
		return this;
	}

	public String getShipperTaxIdentifier() {
		return shipperTaxIdentifier;
	}

	public void setShipperTaxIdentifier(String shipperTaxIdentifier) {
		this.shipperTaxIdentifier = shipperTaxIdentifier;
	}

	public ShipmentCustomsInvoiceDetailsTaxRecipient receiverTaxIdentifier(String receiverTaxIdentifier) {
		this.receiverTaxIdentifier = receiverTaxIdentifier;
		return this;
	}

	public String getReceiverTaxIdentifier() {
		return receiverTaxIdentifier;
	}

	public ShipmentCustomsInvoiceDetailsTaxRecipient setReceiverTaxIdentifier(String receiverTaxIdentifier) {
		this.receiverTaxIdentifier = receiverTaxIdentifier;
		return this;
	}
	
	public String getThirdPartyTaxIdentifier() {
		return thirdPartyTaxIdentifier;
	}

	public void setThirdPartyTaxIdentifier(String thirdPartyTaxIdentifier) {
		this.thirdPartyTaxIdentifier = thirdPartyTaxIdentifier;
	}
	
	public String getOtherTaxIdentifier() {
		return otherTaxIdentifier;
	}

	public void setOtherTaxIdentifier(String otherTaxIdentifier) {
		this.otherTaxIdentifier = otherTaxIdentifier;
	}

	public ShipmentCustomsInvoiceDetailsTaxRecipient name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShipmentCustomsInvoiceDetailsTaxRecipient address(Address address) {
		this.address = address;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ShipmentCustomsInvoiceDetailsTaxRecipient phoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getReasonForExport() {
		return reasonForExport;
	}

	public void setReasonForExport(String reasonForExport) {
		this.reasonForExport = reasonForExport;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShipmentCustomsInvoiceDetailsTaxRecipient shipmentCustomsInvoiceDetailsTaxRecipient = (ShipmentCustomsInvoiceDetailsTaxRecipient) o;
		return Objects.equals(this.type, shipmentCustomsInvoiceDetailsTaxRecipient.type)
				&& Objects.equals(this.shipperTaxIdentifier,
						shipmentCustomsInvoiceDetailsTaxRecipient.shipperTaxIdentifier)
				&& Objects.equals(this.receiverTaxIdentifier,
						shipmentCustomsInvoiceDetailsTaxRecipient.receiverTaxIdentifier)
				&& Objects.equals(this.name, shipmentCustomsInvoiceDetailsTaxRecipient.name)
				&& Objects.equals(this.address, shipmentCustomsInvoiceDetailsTaxRecipient.address)
				&& Objects.equals(this.phoneNumber, shipmentCustomsInvoiceDetailsTaxRecipient.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, shipperTaxIdentifier, receiverTaxIdentifier, name, address, phoneNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShipmentCustomsInvoiceDetailsTaxRecipient {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    shipperTaxIdentifier: ").append(toIndentedString(shipperTaxIdentifier)).append("\n");
		sb.append("    receiverTaxIdentifier: ").append(toIndentedString(receiverTaxIdentifier)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
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
