package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceVariant {
	
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("product_id")
	private int productId;
	
	@JsonProperty("cost_price")
	private double costPrice;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("sales_price")
	private double salesPrice;
	
	@JsonProperty("retail_price")
	private double retailPrice;
	
	@JsonProperty("weight")
	private double weight;
	
	@JsonProperty("width")
	private double width;
	
	@JsonProperty("height")
	private double height;
	
	@JsonProperty("depth")
	private double depth;
	
	@JsonProperty("sku")
	private String sku;
	
	@JsonProperty("sku_id")
	private int skuId;
	
	@JsonProperty("calculated_price")
	private double calculatedPrice;
	
	@JsonProperty("calculated_weight")
	private int calculatedWeight;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("option_values")
	private List<BigCommerceVariantOptions> options;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@JsonIgnore
	public String getVariantId() {
		return String.valueOf(id);
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public double getCalculatedPrice() {
		return calculatedPrice;
	}

	public void setCalculatedPrice(double calculatedPrice) {
		this.calculatedPrice = calculatedPrice;
	}

	public int getCalculatedWeight() {
		return calculatedWeight;
	}

	public void setCalculatedWeight(int calculatedWeight) {
		this.calculatedWeight = calculatedWeight;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public List<BigCommerceVariantOptions> getOptions() {
		return options;
	}

	public void setOptions(List<BigCommerceVariantOptions> options) {
		this.options = options;
	}

	public static class BigCommerceVariantOptions {
		
		@JsonProperty("id")
		private long id;
		
		@JsonProperty("label")
		private String label;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
		
	}

}
