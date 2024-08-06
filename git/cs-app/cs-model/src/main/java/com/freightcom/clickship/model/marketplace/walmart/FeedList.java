package com.freightcom.clickship.model.marketplace.walmart;

import com.freightcom.clickship.model.marketplace.walmart.feeds.Results;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedList {

    @XmlElement(name="totalResults")
    private int totalResults;
    @XmlElement(name="offset")
    private int offset;
    @XmlElement(name="limit")
    private int limit;
    @XmlElement(name="results")
    private Results results;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
