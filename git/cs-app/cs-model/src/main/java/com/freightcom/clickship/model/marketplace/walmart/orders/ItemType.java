
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemType", propOrder = {
    "productName",
    "sku"
})
public class ItemType {

    @XmlElement(required = true)
    protected String productName;
    @XmlElement(required = true)
    protected String sku;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String value) {
        this.productName = value;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String value) {
        this.sku = value;
    }

}
