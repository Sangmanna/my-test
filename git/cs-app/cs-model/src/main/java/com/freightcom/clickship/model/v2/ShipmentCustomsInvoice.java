package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ShipmentCustomsInvoice
 */

public class ShipmentCustomsInvoice {
	/**
	 * The source of the customs invoice: details provided, will provide in person,
	 * or allow the carrier to handle it.
	 */
	public enum SourceEnum {
		DETAILS("details"),

		IN_PERSON("in-person"),

		CARRIER("carrier");

		private String value;

		SourceEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static SourceEnum fromValue(String text) {
			for (SourceEnum b : SourceEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("source")
	private SourceEnum source = null;

	@JsonProperty("broker")
	private ShipmentCustomsInvoiceBroker broker = null;

	@JsonProperty("details")
	private ShipmentCustomsInvoiceDetails details = null;

	public ShipmentCustomsInvoice source(SourceEnum source) {
		this.source = source;
		return this;
	}

	public SourceEnum getSource() {
		return source;
	}

	public void setSource(SourceEnum source) {
		this.source = source;
	}

	public ShipmentCustomsInvoice broker(ShipmentCustomsInvoiceBroker broker) {
		this.broker = broker;
		return this;
	}

	public ShipmentCustomsInvoiceBroker getBroker() {
		return broker;
	}

	public void setBroker(ShipmentCustomsInvoiceBroker broker) {
		this.broker = broker;
	}

	public ShipmentCustomsInvoice details(ShipmentCustomsInvoiceDetails details) {
		this.details = details;
		return this;
	}

	public ShipmentCustomsInvoiceDetails getDetails() {
		return details;
	}

	public void setDetails(ShipmentCustomsInvoiceDetails details) {
		this.details = details;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShipmentCustomsInvoice shipmentCustomsInvoice = (ShipmentCustomsInvoice) o;
		return Objects.equals(this.source, shipmentCustomsInvoice.source)
				&& Objects.equals(this.broker, shipmentCustomsInvoice.broker)
				&& Objects.equals(this.details, shipmentCustomsInvoice.details);
	}

	@Override
	public int hashCode() {
		return Objects.hash(source, broker, details);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShipmentCustomsInvoice {\n");

		sb.append("    source: ").append(toIndentedString(source)).append("\n");
		sb.append("    broker: ").append(toIndentedString(broker)).append("\n");
		sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
