package com.freightcom.clickship.model.order;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.freightcom.clickship.model.CommonDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderNotesDTO extends CommonDTO implements Serializable {

    private static final long serialVersionUID = -7854120369843045675L;

    private String id;

    private String marketplaceId;

    private String orderId;

    private String customerId;

    private String commentsInfo;

    private Date createdDateAndTime;

    private String createdBy;

    public String getId() {
        return id;
    }

    public OrderNotesDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getmarketplaceId() {
        return marketplaceId;
    }

    public OrderNotesDTO setmarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderNotesDTO setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderNotesDTO setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCommentsInfo() {
        return commentsInfo;
    }

    public OrderNotesDTO setCommentsInfo(String commentsInfo) {
        this.commentsInfo = commentsInfo;
        return this;
    }

    public Date getCreatedDateAndTime() {
        return createdDateAndTime;
    }

    public OrderNotesDTO setCreatedDateAndTime(Date createdDateAndTime) {
        this.createdDateAndTime = createdDateAndTime;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public OrderNotesDTO setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
