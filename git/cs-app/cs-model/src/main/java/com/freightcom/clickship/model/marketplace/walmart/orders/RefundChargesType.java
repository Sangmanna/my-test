
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refundChargesType", propOrder = {
    "refundCharge"
})
public class RefundChargesType {

    protected List<RefundChargeType> refundCharge;

    public List<RefundChargeType> getRefundCharge() {
        if (refundCharge == null) {
            refundCharge = new ArrayList<RefundChargeType>();
        }
        return this.refundCharge;
    }

}
