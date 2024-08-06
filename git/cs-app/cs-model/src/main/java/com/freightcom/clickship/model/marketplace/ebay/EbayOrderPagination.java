package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EbayOrderPagination {

    @JsonProperty("href")
    private String href;

    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("next")
    private String next;

    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("orders")
    private List<EbayOrder> orders;

    @JsonProperty("prev")
    private String prev;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("warnings")
    private List<Error> warnings;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Error> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Error> warnings) {
        this.warnings = warnings;
    }

    public List<EbayOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<EbayOrder> orders) {
        this.orders = orders;
    }
}
