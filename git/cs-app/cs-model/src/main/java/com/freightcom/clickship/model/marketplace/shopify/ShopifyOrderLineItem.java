package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrderLineItem implements Serializable {

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
	private List<ShopifyTax> taxes;
	
	@JsonProperty("discount_allocations")
	private List<ShopifyLineItemDiscount> discounts;
	
	@JsonProperty("fulfillment_order_line_items")
	private List<ShopifyOrderLineItem> lineItemList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public ShopifyOrderLineItem setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ShopifyOrderLineItem setName(String name) {
		this.name = name;
		return this;
	}

	public long getProductId() {
		return productId;
	}

	public ShopifyOrderLineItem setProductId(long productId) {
		this.productId = productId;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public ShopifyOrderLineItem setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public boolean isProductExist() {
		return productExist;
	}

	public ShopifyOrderLineItem setProductExist(boolean productExist) {
		this.productExist = productExist;
		return this;
	}

	public long getVariantId() {
		return variantId;
	}

	public ShopifyOrderLineItem setVariantId(long variantId) {
		this.variantId = variantId;
		return this;
	}

	public String getVariantName() {
		return variantName;
	}

	public ShopifyOrderLineItem setVariantName(String variantName) {
		this.variantName = variantName;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public ShopifyOrderLineItem setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public double getWeight() {
		return weight;
	}

	public ShopifyOrderLineItem setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public ShopifyOrderLineItem setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public double getPrice() {
		return price;
	}
	
	public ShopifyOrderLineItem setPrice(double price) {
		this.price = price;
		return this;
	}
	
	public double getSubTotal() {
		return quantity * price;
	}

	public double getDiscount() {
		return discount;
	}

	public ShopifyOrderLineItem setDiscount(double discount) {
		this.discount = discount;
		return this;
	}

	public String getFulfilmentService() {
		return fulfilmentService;
	}

	public ShopifyOrderLineItem setFulfilmentService(String fulfilmentService) {
		this.fulfilmentService = fulfilmentService;
		return this;
	}

	public String getFulfilmentStatus() {
		return fulfilmentStatus;
	}

	public ShopifyOrderLineItem setFulfilmentStatus(String fulfilmentStatus) {
		this.fulfilmentStatus = fulfilmentStatus;
		return this;
	}

	public List<ShopifyTax> getTaxes() {
		return taxes;
	}

	public ShopifyOrderLineItem setTaxes(List<ShopifyTax> taxes) {
		this.taxes = taxes;
		return this;
	}

	public List<ShopifyLineItemDiscount> getDiscounts() {
		return discounts;
	}

	public ShopifyOrderLineItem setDiscounts(List<ShopifyLineItemDiscount> discounts) {
		this.discounts = discounts;
		return this;
	}

	public String getVendor() {
		return vendor;
	}

	public ShopifyOrderLineItem setVendor(String vendor) {
		this.vendor = vendor;
		return this;
	}

	public boolean isRequiresShipping() {
		return requiresShipping;
	}

	public ShopifyOrderLineItem setRequiresShipping(boolean requiresShipping) {
		this.requiresShipping = requiresShipping;
		return this;
	}

	public boolean isTaxable() {
		return taxable;
	}

	public ShopifyOrderLineItem setTaxable(boolean taxable) {
		this.taxable = taxable;
		return this;
	}

	public boolean isGiftCard() {
		return giftCard;
	}

	public ShopifyOrderLineItem setGiftCard(boolean giftCard) {
		this.giftCard = giftCard;
		return this;
	}

	public List<ShopifyOrderLineItem> getLineItemList() {
		return lineItemList;
	}

	public void setLineItemList(List<ShopifyOrderLineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}
	
	public void addLineItemToList(ShopifyOrderLineItem lineItem) {
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
		return "ShopifyOrderLineItem [id=" + id + ", name=" + name + ", productName=" + productName + ", productId="
				+ productId + ", variantId=" + variantId + ", productExist=" + productExist + ", sku=" + sku
				+ ", quantity=" + quantity + "]";
	}
	
}
