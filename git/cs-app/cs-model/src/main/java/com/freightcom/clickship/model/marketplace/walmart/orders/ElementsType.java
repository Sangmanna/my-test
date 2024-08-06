
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elementsType", propOrder = {
    "order"
})
public class ElementsType {

    @XmlElement(nillable = true)
    protected List<WalmartOrder> order;

    public List<WalmartOrder> getOrder() {
        if (order == null) {
            order = new ArrayList<WalmartOrder>();
        }
        return this.order;
    }

}
