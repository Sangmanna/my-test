package com.freightcom.clickship.model.marketplace.walmart.feeds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feed", propOrder = {
        "feedId",
        "feedSource",
        "feedType",
        "partnerId",
        "itemsReceived",
        "itemsSucceeded",
        "itemsFailed",
        "itemsProcessing",
        "feedStatus",
        "feedDate",
        "batchId",
        "modifiedDtm"
})
public class Feed {

    @XmlElement(name="feedId")
    public String feedId;
    @XmlElement(name="feedSource")
    public String feedSource;
    @XmlElement(name="feedType")
    public String feedType;
    @XmlElement(name="partnerId")
    public String partnerId;
    @XmlElement(name="itemsReceived")
    public int itemsReceived;
    @XmlElement(name="itemsSucceeded")
    public int itemsSucceeded;
    @XmlElement(name="itemsFailed")
    public int itemsFailed;
    @XmlElement(name="itemsProcessing")
    public int itemsProcessing;
    @XmlElement(name="feedStatus")
    public String feedStatus;
    @XmlElement(name="feedDate")
    public Date feedDate;
    @XmlElement(name="batchId")
    public String batchId;
    @XmlElement(name="modifiedDtm")
    public Date modifiedDtm;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getFeedSource() {
        return feedSource;
    }

    public void setFeedSource(String feedSource) {
        this.feedSource = feedSource;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public int getItemsReceived() {
        return itemsReceived;
    }

    public void setItemsReceived(int itemsReceived) {
        this.itemsReceived = itemsReceived;
    }

    public int getItemsSucceeded() {
        return itemsSucceeded;
    }

    public void setItemsSucceeded(int itemsSucceeded) {
        this.itemsSucceeded = itemsSucceeded;
    }

    public int getItemsFailed() {
        return itemsFailed;
    }

    public void setItemsFailed(int itemsFailed) {
        this.itemsFailed = itemsFailed;
    }

    public int getItemsProcessing() {
        return itemsProcessing;
    }

    public void setItemsProcessing(int itemsProcessing) {
        this.itemsProcessing = itemsProcessing;
    }

    public String getFeedStatus() {
        return feedStatus;
    }

    public void setFeedStatus(String feedStatus) {
        this.feedStatus = feedStatus;
    }

    public Date getFeedDate() {
        return feedDate;
    }

    public void setFeedDate(Date feedDate) {
        this.feedDate = feedDate;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Date getModifiedDtm() {
        return modifiedDtm;
    }

    public void setModifiedDtm(Date modifiedDtm) {
        this.modifiedDtm = modifiedDtm;
    }
}
