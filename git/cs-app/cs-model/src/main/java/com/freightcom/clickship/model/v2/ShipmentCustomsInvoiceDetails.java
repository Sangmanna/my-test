package com.freightcom.clickship.model.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class ShipmentCustomsInvoiceDetails {
	@JsonProperty("tax_recipient")
	private ShipmentCustomsInvoiceDetailsTaxRecipient taxRecipient = null;

	@JsonProperty("general_description_of_goods")
	private String generalDescriptionOfGoods = null;

	@JsonProperty("additional_remarks")
	private String additionalRemarks = null;

	/**
	 * Gets or Sets palletDeclaration
	 */
	public enum PalletDeclarationEnum {
		CA_OR_US_WOOD("ca-or-us-wood"),

		ISPM_15_TREATED_WOOD("ispm-15-treated-wood"),

		MANUFACTURED_WOOD_OR_NON_WOOD("manufactured-wood-or-non-wood");

		private String value;

		PalletDeclarationEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static PalletDeclarationEnum fromValue(String text) {
			for (PalletDeclarationEnum b : PalletDeclarationEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("pallet_declaration")
	private PalletDeclarationEnum palletDeclaration = null;

	@JsonProperty("products")
	private List<ShipmentCustomsInvoiceDetailsProducts> products = null;

	public ShipmentCustomsInvoiceDetails taxRecipient(ShipmentCustomsInvoiceDetailsTaxRecipient taxRecipient) {
		this.taxRecipient = taxRecipient;
		return this;
	}

	public ShipmentCustomsInvoiceDetailsTaxRecipient getTaxRecipient() {
		return taxRecipient;
	}

	public void setTaxRecipient(ShipmentCustomsInvoiceDetailsTaxRecipient taxRecipient) {
		this.taxRecipient = taxRecipient;
	}

	public ShipmentCustomsInvoiceDetails generalDescriptionOfGoods(String generalDescriptionOfGoods) {
		this.generalDescriptionOfGoods = generalDescriptionOfGoods;
		return this;
	}

	public String getGeneralDescriptionOfGoods() {
		return generalDescriptionOfGoods;
	}

	public void setGeneralDescriptionOfGoods(String generalDescriptionOfGoods) {
		this.generalDescriptionOfGoods = generalDescriptionOfGoods;
	}

	public ShipmentCustomsInvoiceDetails additionalRemarks(String additionalRemarks) {
		this.additionalRemarks = additionalRemarks;
		return this;
	}

	public String getAdditionalRemarks() {
		return additionalRemarks;
	}

	public void setAdditionalRemarks(String additionalRemarks) {
		this.additionalRemarks = additionalRemarks;
	}

	public ShipmentCustomsInvoiceDetails palletDeclaration(PalletDeclarationEnum palletDeclaration) {
		this.palletDeclaration = palletDeclaration;
		return this;
	}

	public PalletDeclarationEnum getPalletDeclaration() {
		return palletDeclaration;
	}

	public void setPalletDeclaration(PalletDeclarationEnum palletDeclaration) {
		this.palletDeclaration = palletDeclaration;
	}

	public ShipmentCustomsInvoiceDetails products(List<ShipmentCustomsInvoiceDetailsProducts> products) {
		this.products = products;
		return this;
	}

	public ShipmentCustomsInvoiceDetails addProductsItem(ShipmentCustomsInvoiceDetailsProducts productsItem) {
		if (this.products == null) {
			this.products = new ArrayList<ShipmentCustomsInvoiceDetailsProducts>();
		}
		this.products.add(productsItem);
		return this;
	}

	public List<ShipmentCustomsInvoiceDetailsProducts> getProducts() {
		return products;
	}

	public void setProducts(List<ShipmentCustomsInvoiceDetailsProducts> products) {
		this.products = products;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShipmentCustomsInvoiceDetails shipmentCustomsInvoiceDetails = (ShipmentCustomsInvoiceDetails) o;
		return Objects.equals(this.taxRecipient, shipmentCustomsInvoiceDetails.taxRecipient)
				&& Objects.equals(this.generalDescriptionOfGoods,
						shipmentCustomsInvoiceDetails.generalDescriptionOfGoods)
				&& Objects.equals(this.additionalRemarks, shipmentCustomsInvoiceDetails.additionalRemarks)
				&& Objects.equals(this.palletDeclaration, shipmentCustomsInvoiceDetails.palletDeclaration)
				&& Objects.equals(this.products, shipmentCustomsInvoiceDetails.products);
	}

	@Override
	public int hashCode() {
		return Objects.hash(taxRecipient, generalDescriptionOfGoods, additionalRemarks,
				palletDeclaration, products);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShipmentCustomsInvoiceDetails {\n");

		sb.append("    taxRecipient: ").append(toIndentedString(taxRecipient)).append("\n");
		sb.append("    generalDescriptionOfGoods: ").append(toIndentedString(generalDescriptionOfGoods)).append("\n");
		sb.append("    additionalRemarks: ").append(toIndentedString(additionalRemarks)).append("\n");
		sb.append("    palletDeclaration: ").append(toIndentedString(palletDeclaration)).append("\n");
		sb.append("    products: ").append(toIndentedString(products)).append("\n");
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
