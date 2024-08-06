package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoOrderItem implements Serializable {

	private static final long serialVersionUID = -7481643813463267030L;

	@JsonProperty("entity_id")
	private Integer entityId;

	@JsonProperty("order_id")
	private Integer orderId;
	
	@JsonAlias({ "item_id", "order_item_id" })
	private Integer itemId;
	
	//use only for add MAGENTO shipment 
	@JsonProperty("orderItemId")
	private Integer orderItemId;
	
	private String name;
	
	@JsonProperty("product_id")
	private Long productId;
	
	@JsonProperty("parent_item_id")
	private Long parentItemId;
	
	@JsonProperty("parent_item")
	private MagentoOrderItem parentItem;
	
	private String sku;
	
	@JsonProperty("qty_ordered")
	private Integer quantity;
	
	//use only for add MAGENTO shipment 
	@JsonProperty("qty")
	private Integer qty;
	
	private Double price;
	
	@JsonProperty("row_total")
	private Double totalAmount;
	
	@JsonProperty("tax_amount")
	private Double taxAmount;
	
	@JsonProperty("discount_amount")
	private Double discountAmount;
	
	@JsonProperty("row_total_incl_tax")
	private Double totalIncTaxAmount;
	
	@JsonProperty("amount_refunded")
	private Double amountRefunded;

	public Integer getEntityId() {
		return entityId;
	}

	public MagentoOrderItem setEntityId(Integer entityId) {
		this.entityId = entityId;
		return this;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public MagentoOrderItem setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}
	
	public Integer getItemId() {
		return itemId;
	}

	public MagentoOrderItem setItemId(Integer itemId) {
		this.itemId = itemId;
		return this;
	}
	
	public Integer getOrderItemId() {
		return orderItemId;
	}

	public MagentoOrderItem setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public String getName() {
		return name;
	}

	public MagentoOrderItem setName(String name) {
		this.name = name;
		return this;
	}

	public Long getProductId() {
		return productId;
	}

	public MagentoOrderItem setProductId(Long productId) {
		this.productId = productId;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public MagentoOrderItem setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public MagentoOrderItem setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public Integer getQty() {
		return qty;
	}

	public MagentoOrderItem setQty(Integer qty) {
		this.qty = qty;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public MagentoOrderItem setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public MagentoOrderItem setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public MagentoOrderItem setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
		return this;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public MagentoOrderItem setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
		return this;
	}

	public Double getTotalIncTaxAmount() {
		return totalIncTaxAmount;
	}

	public MagentoOrderItem setTotalIncTaxAmount(Double totalIncTaxAmount) {
		this.totalIncTaxAmount = totalIncTaxAmount;
		return this;
	}

	public Double getAmountRefunded() {
		return amountRefunded;
	}

	public MagentoOrderItem setAmountRefunded(Double amountRefunded) {
		this.amountRefunded = amountRefunded;
		return this;
	}

	public Long getParentItemId() {
		return parentItemId;
	}

	public MagentoOrderItem setParentItemId(Long parentItemId) {
		this.parentItemId = parentItemId;
		return this;
	}

	public MagentoOrderItem getParentItem() {
		return parentItem;
	}

	public MagentoOrderItem setParentItem(MagentoOrderItem parentItem) {
		this.parentItem = parentItem;
		return this;
	}
	
}
