

package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shippingLineType", propOrder = {
    "lineNumber",
    "shipFromCountry",
    "orderLineStatuses"
})
public class ShippingLineType {

    @XmlElement(required = true)
    protected String lineNumber;

    @XmlElement(required = true)
    protected String shipFromCountry;
    
    @XmlElement(required = true)
    protected ShipLineStatusesType orderLineStatuses;
    
    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String value) {
        this.lineNumber = value;
    }

    public ShipLineStatusesType getOrderLineStatuses() {
        return orderLineStatuses;
    }

    public void setOrderLineStatuses(ShipLineStatusesType value) {
        this.orderLineStatuses = value;
    }

	public String getShipFromCountry() {
		return shipFromCountry;
	}

	public void setShipFromCountry(String shipFromCountry) {
		this.shipFromCountry = shipFromCountry;
	}
}
