
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "asnType", propOrder = {
    "packageASN",
    "palletASN"
})
public class AsnType {

    @XmlElement(required = true)
    protected String packageASN;
    protected String palletASN;

    public String getPackageASN() {
        return packageASN;
    }

    public void setPackageASN(String value) {
        this.packageASN = value;
    }

    public String getPalletASN() {
        return palletASN;
    }

    public void setPalletASN(String value) {
        this.palletASN = value;
    }

}
