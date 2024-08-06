package com.freightcom.clickship.model.marketplace.walmart.items;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemResponse", propOrder = {
        "mart",
        "sku",
        "wpid",
        "upc",
        "gtin",
        "productName",
        "shelf",
        "productType",
        "price",
        "publishedStatus"
})
public class ItemResponse {
    @XmlElement(name = "mart")
    private String mart;
    @XmlElement(name = "sku")
    private String sku;
    @XmlElement(name = "wpid")
    private String wpid;
    @XmlElement(name = "upc")
    private String upc;
    @XmlElement(name = "gtin")
    private String gtin;
    @XmlElement(name = "productName")
    private String productName;
    @XmlElement(name = "shelf")
    private String shelf;
    @XmlElement(name = "productType")
    private String productType;
    @XmlElement(name = "price")
    private Price price;
    @XmlElement(name = "publishedStatus")
    private String publishedStatus;

    public String getMart() {
        return mart;
    }

    public void setMart(String mart) {
        this.mart = mart;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getWpid() {
        return wpid;
    }

    public void setWpid(String wpid) {
        this.wpid = wpid;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getPublishedStatus() {
        return publishedStatus;
    }

    public void setPublishedStatus(String publishedStatus) {
        this.publishedStatus = publishedStatus;
    }
}
