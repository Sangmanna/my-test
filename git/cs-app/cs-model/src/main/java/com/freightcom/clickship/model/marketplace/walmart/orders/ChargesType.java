
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargesType", propOrder = {
    "charge"
})
public class ChargesType {

    protected List<ChargeType> charge;

    public List<ChargeType> getCharge() {
        if (charge == null) {
            charge = new ArrayList<ChargeType>();
        }
        return this.charge;
    }

}
