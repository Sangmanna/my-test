
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fulfillmentType", propOrder = {
    "fulfillmentOption",
    "shipMethod",
    "storeId",
    "offerId",
    "pickUpDateTime",
    "pickUpBy"
})
public class FulfillmentType {

    protected String fulfillmentOption;
    protected String shipMethod;
    protected String storeId;
    protected String offerId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pickUpDateTime;
    protected String pickUpBy;

    public String getFulfillmentOption() {
        return fulfillmentOption;
    }

    public void setFulfillmentOption(String value) {
        this.fulfillmentOption = value;
    }

    public String getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(String value) {
        this.shipMethod = value;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String value) {
        this.storeId = value;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String value) {
        this.offerId = value;
    }

    public XMLGregorianCalendar getPickUpDateTime() {
        return pickUpDateTime;
    }

    public void setPickUpDateTime(XMLGregorianCalendar value) {
        this.pickUpDateTime = value;
    }

    public String getPickUpBy() {
        return pickUpBy;
    }

    public void setPickUpBy(String value) {
        this.pickUpBy = value;
    }

}
