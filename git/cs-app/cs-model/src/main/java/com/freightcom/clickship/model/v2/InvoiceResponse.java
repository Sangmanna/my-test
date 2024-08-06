package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("number")
    private String number;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("due_date")
    private Date dueDate;

    @JsonProperty("amount")
    private Money amount;

    @JsonProperty("owing")
    private Money owing;

    @JsonProperty("urls")
    private PublicUrl urls;

    @JsonProperty("payments")
    private List<InvoicePayment> payments;

    @JsonProperty("line_items")
    private List<V2LineItems> lineItems;

    public String getId() {
        return id;
    }

    public InvoiceResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public InvoiceResponse setType(String type) {
        this.type = type;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public InvoiceResponse setNumber(String number) {
        this.number = number;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public InvoiceResponse setDate(Date date) {
        this.date = date;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public InvoiceResponse setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Money getAmount() {
        return amount;
    }

    public InvoiceResponse setAmount(Money amount) {
        this.amount = amount;
        return this;
    }

    public Money getOwing() {
        return owing;
    }

    public InvoiceResponse setOwing(Money owing) {
        this.owing = owing;
        return this;
    }

    public PublicUrl getUrls() {
        return urls;
    }

    public InvoiceResponse setUrls(PublicUrl urls) {
        this.urls = urls;
        return this;
    }

    public List<InvoicePayment> getPayments() {
        return payments;
    }

    public InvoiceResponse setPayments(List<InvoicePayment> payments) {
        this.payments = payments;
        return this;
    }

    public List<V2LineItems> getLineItems() {
        return lineItems;
    }

    public InvoiceResponse setLineItems(List<V2LineItems> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PublicUrl {

        @JsonProperty("description")
        private String description;

        @JsonProperty("default")
        private String defaultUrl;

        public String getDescription() {
            return description;
        }

        public PublicUrl setDescription(String description) {
            this.description = description;
            return this;
        }

        public String getDefaultUrl() {
            return defaultUrl;
        }

        public PublicUrl setDefaultUrl(String defaultUrl) {
            this.defaultUrl = defaultUrl;
            return this;
        }
    }
}
