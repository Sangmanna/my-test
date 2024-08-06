package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceProduct {
	
	@JsonProperty("id")
	private long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private String type;

	@JsonProperty("sku")
	private String sku;

	@JsonProperty("description")
	private String description;

	@JsonProperty("weight")
	private double weight;

	@JsonProperty("width")
	private double width;

	@JsonProperty("depth")
	private double depth;

	@JsonProperty("height")
	private double height;

	@JsonProperty("price")
	private double price;

	@JsonProperty("cost_price")
	private double costPrice;

	@JsonProperty("retail_price")
	private double retailPrice;

	@JsonProperty("sale_price")
	private double salePrice;

	@JsonProperty("map_price")
	private int map_price;

	@JsonProperty("tax_class_id")
	private int taxClassId;

	@JsonProperty("product_tax_code")
	private String productTaxCode;

	@JsonProperty("categories")
	private List<Integer> categories;

	@JsonProperty("brand_id")
	private int brandId;

	@JsonProperty("fixed_cost_shipping_price")
	private double fixedCostShippingPrice;

	@JsonProperty("upc")
	private String upc;

	@JsonProperty("availability")
	private String availability;

	@JsonProperty("availability_description")
	private String availabilityDescription;

	@JsonProperty("images")
	private List<BigCommerceImage> images;

	@JsonProperty("base_variant_id")
	private int baseVariantId;

	@JsonProperty("variants")
	private List<BigCommerceVariant> variants;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@JsonIgnore
	public String getProductId() {
		return String.valueOf(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getMap_price() {
		return map_price;
	}

	public void setMap_price(int map_price) {
		this.map_price = map_price;
	}

	public int getTaxClassId() {
		return taxClassId;
	}

	public void setTaxClassId(int taxClassId) {
		this.taxClassId = taxClassId;
	}

	public String getProductTaxCode() {
		return productTaxCode;
	}

	public void setProductTaxCode(String productTaxCode) {
		this.productTaxCode = productTaxCode;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public double getFixedCostShippingPrice() {
		return fixedCostShippingPrice;
	}

	public void setFixedCostShippingPrice(double fixedCostShippingPrice) {
		this.fixedCostShippingPrice = fixedCostShippingPrice;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getAvailabilityDescription() {
		return availabilityDescription;
	}

	public void setAvailabilityDescription(String availabilityDescription) {
		this.availabilityDescription = availabilityDescription;
	}

	public List<BigCommerceImage> getImages() {
		return images;
	}

	public void setImages(List<BigCommerceImage> images) {
		this.images = images;
	}
	
	public int getBaseVariantId() {
		return baseVariantId;
	}

	public void setBaseVariantId(int baseVariantId) {
		this.baseVariantId = baseVariantId;
	}

	public List<BigCommerceVariant> getVariants() {
		return variants;
	}

	public void setVariants(List<BigCommerceVariant> variants) {
		this.variants = variants;
	}
}
