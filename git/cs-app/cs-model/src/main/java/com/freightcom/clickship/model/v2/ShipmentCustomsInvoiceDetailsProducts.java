package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipmentCustomsInvoiceDetailsProducts {
	@JsonProperty("product_name")
	private String productName = null;

	@JsonProperty("weight")
	private Weight weight = null;

	@JsonProperty("hs_code")
	private String hsCode = null;

	@JsonProperty("country_of_origin")
	private String countryOfOrigin = null;

	@JsonProperty("num_units")
	private Integer numUnits = null;

	@JsonProperty("unit_price")
	private Money unitPrice = null;

	@JsonProperty("description")
	private String description = null;

	public ShipmentCustomsInvoiceDetailsProducts productName(String productName) {
		this.productName = productName;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ShipmentCustomsInvoiceDetailsProducts weight(Weight weight) {
		this.weight = weight;
		return this;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public ShipmentCustomsInvoiceDetailsProducts hsCode(String hsCode) {
		this.hsCode = hsCode;
		return this;
	}

	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	public ShipmentCustomsInvoiceDetailsProducts countryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
		return this;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public ShipmentCustomsInvoiceDetailsProducts numUnits(Integer numUnits) {
		this.numUnits = numUnits;
		return this;
	}

	public Integer getNumUnits() {
		return numUnits;
	}

	public void setNumUnits(Integer numUnits) {
		this.numUnits = numUnits;
	}

	public ShipmentCustomsInvoiceDetailsProducts unitPrice(Money unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public Money getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Money unitPrice) {
		this.unitPrice = unitPrice;
	}

	public ShipmentCustomsInvoiceDetailsProducts description(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShipmentCustomsInvoiceDetailsProducts shipmentCustomsInvoiceDetailsProducts = (ShipmentCustomsInvoiceDetailsProducts) o;
		return Objects.equals(this.productName, shipmentCustomsInvoiceDetailsProducts.productName)
				&& Objects.equals(this.weight, shipmentCustomsInvoiceDetailsProducts.weight)
				&& Objects.equals(this.hsCode, shipmentCustomsInvoiceDetailsProducts.hsCode)
				&& Objects.equals(this.countryOfOrigin, shipmentCustomsInvoiceDetailsProducts.countryOfOrigin)
				&& Objects.equals(this.numUnits, shipmentCustomsInvoiceDetailsProducts.numUnits)
				&& Objects.equals(this.unitPrice, shipmentCustomsInvoiceDetailsProducts.unitPrice)
				&& Objects.equals(this.description, shipmentCustomsInvoiceDetailsProducts.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productName, weight, hsCode, countryOfOrigin, numUnits, unitPrice, description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShipmentCustomsInvoiceDetailsProducts {\n");

		sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
		sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
		sb.append("    hsCode: ").append(toIndentedString(hsCode)).append("\n");
		sb.append("    countryOfOrigin: ").append(toIndentedString(countryOfOrigin)).append("\n");
		sb.append("    numUnits: ").append(toIndentedString(numUnits)).append("\n");
		sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
