package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixTotals {

    @JsonProperty("subtotal")
    private String subtotal;

    @JsonProperty("shipping")
    private String shipping;

    @JsonProperty("tax")
    private String tax;

    @JsonProperty("discount")
    private String discount;

    @JsonProperty("total")
    private String total;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("refund")
    private String refund;

    @JsonProperty("giftCard")
    private String giftCard;

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    public String getGiftCard() {
        return giftCard;
    }

    public void setGiftCard(String giftCard) {
        this.giftCard = giftCard;
    }
}
