package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomLineItems {

	@JsonProperty("id")
	private String id;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("refundQuantity")
	private Integer refundQuantity;

	@JsonProperty("price")
	private WixEcomAmount price;

	@JsonProperty("totalDiscount")
	private WixEcomAmount totalDiscount;

	@JsonProperty("priceBeforeDiscounts")
	private WixEcomAmount priceBeforeDiscounts;

	@JsonProperty("totalPriceBeforeTax")
	private WixEcomAmount totalPriceBeforeTax;

	@JsonProperty("totalPriceAfterTax")
	private WixEcomAmount totalPriceAfterTax;

	@JsonProperty("lineItemPrice")
	private WixEcomAmount lineItemPrice;

	@JsonProperty("productName")
	private WixEcomProductName productName;

	@JsonProperty("catalogReference")
	private WixEcomCatalogReference catalogReference;

	@JsonProperty("image")
	private WixEcomImage image;

	@JsonProperty("paymentOption")
	private String paymentOption;

	@JsonProperty("taxDetails")
	private WixEcomTaxDetails taxDetails;

	@JsonProperty("fulfillerId")
	private String fulfillerId;

	@JsonProperty("physicalProperties")
	private WixEcomPhysicalProperties physicalProperties;

	// for refund
	@JsonProperty("lineItemId")
	private String lineItemId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getRefundQuantity() {
		return refundQuantity;
	}

	public void setRefundQuantity(Integer refundQuantity) {
		this.refundQuantity = refundQuantity;
	}

	public WixEcomAmount getPrice() {
		return price;
	}

	public void setPrice(WixEcomAmount price) {
		this.price = price;
	}

	public WixEcomAmount getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(WixEcomAmount totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public WixEcomAmount getPriceBeforeDiscounts() {
		return priceBeforeDiscounts;
	}

	public void setPriceBeforeDiscounts(WixEcomAmount priceBeforeDiscounts) {
		this.priceBeforeDiscounts = priceBeforeDiscounts;
	}

	public WixEcomAmount getTotalPriceBeforeTax() {
		return totalPriceBeforeTax;
	}

	public void setTotalPriceBeforeTax(WixEcomAmount totalPriceBeforeTax) {
		this.totalPriceBeforeTax = totalPriceBeforeTax;
	}

	public WixEcomAmount getTotalPriceAfterTax() {
		return totalPriceAfterTax;
	}

	public void setTotalPriceAfterTax(WixEcomAmount totalPriceAfterTax) {
		this.totalPriceAfterTax = totalPriceAfterTax;
	}

	public WixEcomAmount getLineItemPrice() {
		return lineItemPrice;
	}

	public void setLineItemPrice(WixEcomAmount lineItemPrice) {
		this.lineItemPrice = lineItemPrice;
	}

	public WixEcomProductName getProductName() {
		return productName;
	}

	public void setProductName(WixEcomProductName productName) {
		this.productName = productName;
	}

	public WixEcomCatalogReference getCatalogReference() {
		return catalogReference;
	}

	public void setCatalogReference(WixEcomCatalogReference catalogReference) {
		this.catalogReference = catalogReference;
	}

	public WixEcomImage getImage() {
		return image;
	}

	public void setImage(WixEcomImage image) {
		this.image = image;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public WixEcomTaxDetails getTaxDetails() {
		return taxDetails;
	}

	public void setTaxDetails(WixEcomTaxDetails taxDetails) {
		this.taxDetails = taxDetails;
	}

	public String getFulfillerId() {
		return fulfillerId;
	}

	public void setFulfillerId(String fulfillerId) {
		this.fulfillerId = fulfillerId;
	}

	public WixEcomPhysicalProperties getPhysicalProperties() {
		return physicalProperties;
	}

	public void setPhysicalProperties(WixEcomPhysicalProperties physicalProperties) {
		this.physicalProperties = physicalProperties;
	}

	public String getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(String lineItemId) {
		this.lineItemId = lineItemId;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomPhysicalProperties {

		@JsonProperty("weight")
		private Double weight;

		@JsonProperty("sku")
		private String sku;

		@JsonProperty("shippable")
		private Boolean shippable;

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku;
		}

		public Boolean getShippable() {
			return shippable;
		}

		public void setShippable(Boolean shippable) {
			this.shippable = shippable;
		}
	}
}
