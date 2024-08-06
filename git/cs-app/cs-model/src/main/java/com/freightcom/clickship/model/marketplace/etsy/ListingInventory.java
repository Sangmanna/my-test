package com.freightcom.clickship.model.marketplace.etsy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingInventory implements Serializable {

	private static final long serialVersionUID = 4279544365781705533L;

	@JsonProperty("products")
    List<ListingProduct> products;

    @JsonProperty("price_on_property")
    private long[] priceOnProperty;

    @JsonProperty("quantity_on_property")
    private long[] quantityOnProperty;

    @JsonProperty("sku_on_property")
    private long[] skuOnProperty;

    public List<ListingProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ListingProduct> products) {
        this.products = products;
    }

    public long[] getPriceOnProperty() {
        return priceOnProperty;
    }

    public void setPriceOnProperty(long[] priceOnProperty) {
        this.priceOnProperty = priceOnProperty;
    }

    public long[] getQuantityOnProperty() {
        return quantityOnProperty;
    }

    public void setQuantityOnProperty(long[] quantityOnProperty) {
        this.quantityOnProperty = quantityOnProperty;
    }

    public long[] getSkuOnProperty() {
        return skuOnProperty;
    }

    public void setSkuOnProperty(long[] skuOnProperty) {
        this.skuOnProperty = skuOnProperty;
    }
}
