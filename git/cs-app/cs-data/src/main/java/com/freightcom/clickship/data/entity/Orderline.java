package com.freightcom.clickship.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

@Entity
@Table(name = "orderline")
public class Orderline extends BaseEntity {
	
	private static final long serialVersionUID = 7459776842239494211L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, updatable = false)
	@JsonIgnore
	private Order order;
	
	@OneToOne(mappedBy = "orderline", cascade = CascadeType.ALL)
	private OrderlineDiscount orderlineDiscount;
	
	@Column(name = "line_number")
	private Integer lineNumber;
	
	@Column(name = "external_line_number")
	private String externalLineNumber;

	@Column(name = "external_line_id")
	private String externalLineId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_product_id")
	@JsonIgnore
	private MarketplaceProduct marketplaceProduct;

	@Column(name = "variant_id")
	private String variantId;

	@Column(name = "sku")
	private String sku;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "unit_price")
	private Double unitPrice;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "line_subtotal")
	private Double lineSubtotal;

	@Column(name = "message")
	private String message;
	
	@Column(name = "hs_code")
	private String hsCode;
	
	@Column(name = "origin")
	private String origin;
	
	@Transient
	private String imageUrl;
	
	@Transient
	private double weight;
	
	@Transient
	private double weightMetric;
	
	public String getExternalLineNumber() {
		return externalLineNumber;
	}

	public Orderline setExternalLineNumber(String externalLineNumber) {
		this.externalLineNumber = externalLineNumber;
		return this;
	}

	public String getExternalLineId() {
		return externalLineId;
	}

	public Orderline setExternalLineId(String externalLineId) {
		this.externalLineId = externalLineId;
		return this;
	}

	public String getVariantId() {
		return variantId;
	}

	public Orderline setVariantId(String variantId) {
		this.variantId = variantId;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public Orderline setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Orderline setTitle(String title) {
		String accents = ClickshipStringUtil.getStringStripAccents(title);
		this.title = ClickshipStringUtil.truncateString(accents, 255);
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Orderline setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Orderline setQuantity(Integer quantity) {
		this.quantity = quantity;
		setLineSubTotal();
		return this;
	}

	private void setLineSubTotal() {
		if (this.quantity != null && this.unitPrice != null) {
			this.lineSubtotal = this.quantity * this.unitPrice;
		}
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public Orderline setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
		setLineSubTotal();
		return this;
	}

	public Double getDiscount() {
		return discount;
	}

	public Orderline setDiscount(Double discount) {
		this.discount = discount;
		return this;
	}
	
	public Double getLineSubtotal() {
		setLineSubTotal();
		return lineSubtotal;
	}

	public Orderline setLineSubtotal(Double lineSubtotal) {
		this.lineSubtotal = lineSubtotal;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Orderline setMessage(String message) {
		this.message = message;
		return this;
	}

	public MarketplaceProduct getMarketplaceProduct() {
		return marketplaceProduct;
	}

	public Orderline setMarketplaceProduct(MarketplaceProduct marketplaceProduct) {
		this.marketplaceProduct = marketplaceProduct;
		return this;
	}

	public String getId() {
		return id;
	}

	public Orderline setId(String id) {
		this.id = id;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public Orderline setOrder(Order order) {
		this.order = order;
		return this;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	public Orderline setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
		return this;
	}

	public String getHsCode() {
		return hsCode == null && marketplaceProduct != null ? marketplaceProduct.getHsCode() : hsCode;
	}

	public Orderline setHsCode(String hsCode) {
		this.hsCode = hsCode;
		return this;
	}

	public String getOrigin() {
		return origin;
	}

	public Orderline setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public OrderlineDiscount getOrderlineDiscount() {
		return orderlineDiscount;
	}

	public Orderline setOrderlineDiscount(OrderlineDiscount orderlineDiscount) {
		this.orderlineDiscount = orderlineDiscount;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Orderline && ((Orderline) obj).getExternalLineId().equals(this.getExternalLineId());
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + (StringUtils.isNotEmpty(this.externalLineId) ? this.externalLineId.hashCode() : 0);
	}

	public String getImageUrl() {
		return imageUrl == null && marketplaceProduct != null ? marketplaceProduct.getImageUrl() : imageUrl;
	}

	public Orderline setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public double getWeight() {
		return marketplaceProduct != null ? marketplaceProduct.getWeight() : weight;	
	}

	public Orderline setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	public double getWeightMetric() {
		return marketplaceProduct != null ? marketplaceProduct.getWeight() : weightMetric;
	}

	public Orderline setWeightMetric(double weightMetric) {
		this.weightMetric = weightMetric;
		return this;
	}
	
}