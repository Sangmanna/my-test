package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PricingSummary {

    @JsonProperty("adjustment")
    private Amount adjustment;

    @JsonProperty("deliveryCost")
    private Amount deliveryCost;

    @JsonProperty("deliveryDiscount")
    private Amount deliveryDiscount;

    @JsonProperty("fee")
    private Amount fee;

    @JsonProperty("priceDiscountSubtotal")
    private Amount priceDiscountSubtotal;

    @JsonProperty("priceDiscount")
    private Amount priceDiscount;

    @JsonProperty("priceSubtotal")
    private Amount priceSubtotal;

    @JsonProperty("tax")
    private Amount tax;

    @JsonProperty("total")
    private Amount total;

    public Amount getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Amount adjustment) {
        this.adjustment = adjustment;
    }

    public Amount getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Amount deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Amount getDeliveryDiscount() {
        return deliveryDiscount;
    }

    public void setDeliveryDiscount(Amount deliveryDiscount) {
        this.deliveryDiscount = deliveryDiscount;
    }

    public Amount getFee() {
        return fee;
    }

    public void setFee(Amount fee) {
        this.fee = fee;
    }

    public Amount getPriceDiscountSubtotal() {
        return priceDiscountSubtotal;
    }

    public void setPriceDiscountSubtotal(Amount priceDiscountSubtotal) {
        this.priceDiscountSubtotal = priceDiscountSubtotal;
    }

    public Amount getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Amount priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Amount getPriceSubtotal() {
        return priceSubtotal;
    }

    public void setPriceSubtotal(Amount priceSubtotal) {
        this.priceSubtotal = priceSubtotal;
    }

    public Amount getTax() {
        return tax;
    }

    public void setTax(Amount tax) {
        this.tax = tax;
    }

    public Amount getTotal() {
        return total;
    }

    public void setTotal(Amount total) {
        this.total = total;
    }
}
