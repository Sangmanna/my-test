package com.freightcom.clickship.model.marketplace.walmart.feeds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "results", propOrder = {
        "feed"
})
public class Results {

    @XmlElement(name="feed")
    private List<Feed> feed;

    public List<Feed> getFeed() {
        return feed;
    }

    public void setFeed(List<Feed> feed) {
        this.feed = feed;
    }
}
