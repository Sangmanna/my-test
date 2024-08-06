package com.freightcom.clickship.model.marketplace.walmart.inventory;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InventoryHeader", propOrder = {
    "version",
    "feedDate"
})
public class InventoryHeader {

    @XmlElement(required = true, defaultValue = "1.4")
    protected String version;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar feedDate;

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

    public XMLGregorianCalendar getFeedDate() {
        return feedDate;
    }

    public void setFeedDate(XMLGregorianCalendar value) {
        this.feedDate = value;
    }

}
