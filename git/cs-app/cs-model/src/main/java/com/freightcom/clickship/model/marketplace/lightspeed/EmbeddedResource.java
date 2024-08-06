package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbeddedResource {

    @JsonProperty("id")
    private String id;

    @JsonProperty("supplierTitle")
    private String supplierTitle;

    @JsonProperty("brandTitle")
    private String brandTitle;

    @JsonProperty("productTitle")
    private String productTitle;

    @JsonProperty("variantTitle")
    private String variantTitle;

    @JsonProperty("taxRate")
    private float taxRate;

    @JsonProperty("taxRates")
    private List<LightSpeedTaxRates> taxRates;

    @JsonProperty("quantityOrdered")
    private Integer quantityOrdered;

    @JsonProperty("quantityShipped")
    private Integer quantityShipped;

    @JsonProperty("quantityRefunded")
    private Integer quantityRefunded;

    @JsonProperty("quantityReturned")
    private Integer quantityReturned;

    @JsonProperty("ean")
    private String ean;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("priceIncl")
    private float priceIncl;

    @JsonProperty("priceExcl")
    private float priceExcl;

    @JsonProperty("discountIncl")
    private float discountIncl;

    @JsonProperty("discountExcl")
    private float discountExcl;

    @JsonProperty("product")
    private ProductResource product;

    @JsonProperty("variant")
    private ProductResource variant;

    @JsonProperty("basePriceExcl")
    private float basePriceExcl;

    @JsonProperty("basePriceIncl")
    private float basePriceIncl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplierTitle() {
        return supplierTitle;
    }

    public void setSupplierTitle(String supplierTitle) {
        this.supplierTitle = supplierTitle;
    }

    public String getBrandTitle() {
        return brandTitle;
    }

    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getVariantTitle() {
        return variantTitle;
    }

    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public List<LightSpeedTaxRates> getTaxRates() {
        return taxRates;
    }

    public void setTaxRates(List<LightSpeedTaxRates> taxRates) {
        this.taxRates = taxRates;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(Integer quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    public Integer getQuantityRefunded() {
        return quantityRefunded;
    }

    public void setQuantityRefunded(Integer quantityRefunded) {
        this.quantityRefunded = quantityRefunded;
    }

    public Integer getQuantityReturned() {
        return quantityReturned;
    }

    public void setQuantityReturned(Integer quantityReturned) {
        this.quantityReturned = quantityReturned;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public float getPriceIncl() {
        return priceIncl;
    }

    public void setPriceIncl(float priceIncl) {
        this.priceIncl = priceIncl;
    }

    public float getPriceExcl() {
        return priceExcl;
    }

    public void setPriceExcl(float priceExcl) {
        this.priceExcl = priceExcl;
    }

    public float getDiscountIncl() {
        return discountIncl;
    }

    public void setDiscountIncl(float discountIncl) {
        this.discountIncl = discountIncl;
    }

    public float getDiscountExcl() {
        return discountExcl;
    }

    public void setDiscountExcl(float discountExcl) {
        this.discountExcl = discountExcl;
    }

    public ProductResource getProduct() {
        return product;
    }

    public void setProduct(ProductResource product) {
        this.product = product;
    }

    public ProductResource getVariant() {
        return variant;
    }

    public void setVariant(ProductResource variant) {
        this.variant = variant;
    }

    public float getBasePriceExcl() {
        return basePriceExcl;
    }

    public void setBasePriceExcl(float basePriceExcl) {
        this.basePriceExcl = basePriceExcl;
    }

    public float getBasePriceIncl() {
        return basePriceIncl;
    }

    public void setBasePriceIncl(float basePriceIncl) {
        this.basePriceIncl = basePriceIncl;
    }
}
