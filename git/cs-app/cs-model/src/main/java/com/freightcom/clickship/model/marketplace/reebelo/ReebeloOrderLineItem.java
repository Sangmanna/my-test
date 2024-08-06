package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloOrderLineItem implements Serializable {

	private static final long serialVersionUID = 1448364393080757894L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("line_item_id")
	private Long lineItemId;
	
	@JsonProperty("inventoryItemId")
	private Long inventoryItemId;
	
	@JsonProperty("shop_id")
	private Long shopId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("vendor")
	private String vendor;
	
	@JsonProperty("product_id")
	private long productId;
	
	@JsonProperty("title")
	private String productName;
	
	@JsonProperty("product_exists")
	private boolean productExist;
	
	@JsonProperty("requires_shipping")
	private boolean requiresShipping;
	
	@JsonProperty("taxable")
	private boolean taxable;
	
	@JsonProperty("gift_card")
	private boolean giftCard;
	
	@JsonProperty("variant_id")
	private long variantId;
	
	@JsonProperty("variant_title")
	private String variantName;
	
	@JsonProperty("sku")
	private String sku;
	
	@JsonProperty("grams")
	private double weight;
	
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("current_quantity")
	private int currentQuantity;
	
	@JsonProperty("fulfillable_quantity")
	private int fulfillableQuantity;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("total_discount")
	private double discount;
	
	@JsonProperty("fulfillment_order_id")
	private Long fulfillmentOrderId;
	
	@JsonProperty("fulfillment_service")
	private String fulfilmentService;
	
	@JsonProperty("fulfillment_status")
	private String fulfilmentStatus;
	
	@JsonProperty("tax_lines")
	private List<ReebeloTax> taxes;
	
	@JsonProperty("discount_allocations")
	private List<ReebeloLineItemDiscount> discounts;
	
	@JsonProperty("fulfillment_order_line_items")
	private List<ReebeloOrderLineItem> lineItemList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public ReebeloOrderLineItem setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ReebeloOrderLineItem setName(String name) {
		this.name = name;
		return this;
	}

	public long getProductId() {
		return productId;
	}

	public ReebeloOrderLineItem setProductId(long productId) {
		this.productId = productId;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public ReebeloOrderLineItem setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public boolean isProductExist() {
		return productExist;
	}

	public ReebeloOrderLineItem setProductExist(boolean productExist) {
		this.productExist = productExist;
		return this;
	}

	public long getVariantId() {
		return variantId;
	}

	public ReebeloOrderLineItem setVariantId(long variantId) {
		this.variantId = variantId;
		return this;
	}

	public String getVariantName() {
		return variantName;
	}

	public ReebeloOrderLineItem setVariantName(String variantName) {
		this.variantName = variantName;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public ReebeloOrderLineItem setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public double getWeight() {
		return weight;
	}

	public ReebeloOrderLineItem setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public ReebeloOrderLineItem setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public double getPrice() {
		return price;
	}
	
	public ReebeloOrderLineItem setPrice(double price) {
		this.price = price;
		return this;
	}
	
	public double getSubTotal() {
		return quantity * price;
	}

	public double getDiscount() {
		return discount;
	}

	public ReebeloOrderLineItem setDiscount(double discount) {
		this.discount = discount;
		return this;
	}

	public String getFulfilmentService() {
		return fulfilmentService;
	}

	public ReebeloOrderLineItem setFulfilmentService(String fulfilmentService) {
		this.fulfilmentService = fulfilmentService;
		return this;
	}

	public String getFulfilmentStatus() {
		return fulfilmentStatus;
	}

	public ReebeloOrderLineItem setFulfilmentStatus(String fulfilmentStatus) {
		this.fulfilmentStatus = fulfilmentStatus;
		return this;
	}

	public List<ReebeloTax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<ReebeloTax> taxes) {
		this.taxes = taxes;
	}

	public List<ReebeloLineItemDiscount> getDiscounts() {
		return discounts;
	}

	public ReebeloOrderLineItem setDiscounts(List<ReebeloLineItemDiscount> discounts) {
		this.discounts = discounts;
		return this;
	}

	public String getVendor() {
		return vendor;
	}

	public ReebeloOrderLineItem setVendor(String vendor) {
		this.vendor = vendor;
		return this;
	}

	public boolean isRequiresShipping() {
		return requiresShipping;
	}

	public ReebeloOrderLineItem setRequiresShipping(boolean requiresShipping) {
		this.requiresShipping = requiresShipping;
		return this;
	}

	public boolean isTaxable() {
		return taxable;
	}

	public ReebeloOrderLineItem setTaxable(boolean taxable) {
		this.taxable = taxable;
		return this;
	}

	public boolean isGiftCard() {
		return giftCard;
	}

	public ReebeloOrderLineItem setGiftCard(boolean giftCard) {
		this.giftCard = giftCard;
		return this;
	}

	public List<ReebeloOrderLineItem> getLineItemList() {
		return lineItemList;
	}

	public void setLineItemList(List<ReebeloOrderLineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}
	
	public void addLineItemToList(ReebeloOrderLineItem lineItem) {
		if(lineItemList == null) {
			lineItemList = new ArrayList<>();
		}
		
		lineItemList.add(lineItem);
	}

	public Long getFulfillmentOrderId() {
		return fulfillmentOrderId;
	}

	public void setFulfillmentOrderId(Long fulfillmentOrderId) {
		this.fulfillmentOrderId = fulfillmentOrderId;
	}
	
	public Long getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
	}

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public int getFulfillableQuantity() {
		return fulfillableQuantity;
	}

	public void setFulfillableQuantity(int fulfillableQuantity) {
		this.fulfillableQuantity = fulfillableQuantity;
	}
	
	public int getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	@Override
	public String toString() {
		return "ReebeloOrderLineItem [id=" + id + ", name=" + name + ", productName=" + productName + ", productId="
				+ productId + ", variantId=" + variantId + ", productExist=" + productExist + ", sku=" + sku
				+ ", quantity=" + quantity + "]";
	}
	
}
