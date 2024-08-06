
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metaType", propOrder = {
    "totalCount",
    "limit",
    "nextCursor"
})
public class MetaType {

    protected Integer totalCount;
    protected int limit;
    protected String nextCursor;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer value) {
        this.totalCount = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String value) {
        this.nextCursor = value;
    }

}
