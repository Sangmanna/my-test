
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refundsType", propOrder = {
    "refund"
})
public class RefundsType {

    @XmlElement(required = true)
    protected List<RefundType> refund;

    public List<RefundType> getRefund() {
        if (refund == null) {
            refund = new ArrayList<RefundType>();
        }
        return this.refund;
    }

}
