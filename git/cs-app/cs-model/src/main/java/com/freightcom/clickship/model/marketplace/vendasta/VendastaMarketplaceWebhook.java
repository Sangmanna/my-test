package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaMarketplaceWebhook {

    @JsonProperty("account")
    private VendastaAccount account;

    @JsonProperty("order_form_submission_id")
    private String orderFormSubmissionId;

    @JsonProperty("vendor_order_id")
    private String vendorOrderId;

    @JsonProperty("order_form")
    private VendastaOrderForm orderForm;

    @JsonProperty("market_id")
    private String marketId;

    @JsonProperty("previous_edition_id")
    private String previousEditionId;

    @JsonProperty("app_id")
    private String appId;

    @JsonProperty("edition_id")
    private String editionId;

    @JsonProperty("activation_id")
    private String activationId;

    @JsonProperty("deactivation_time")
    private String deactivationTime;

    @JsonProperty("webhook_id")
    private String webhookId;

    @JsonProperty("action")
    private String action;

    @JsonProperty("activation_time")
    private String activationTime;

    @JsonProperty("partner_id")
    private String partnerId;

    @JsonProperty("addon_id")
    private String addonId;

    @JsonProperty("account_group_id")
    private String accountGroupId;

    @JsonProperty("cancellation_choices")
    private List<String> cancellationChoices;

    @JsonProperty("cancellation_comment")
    private String cancellationComment;

    @JsonProperty("cancellation_time")
    private String cancellationTime;

    public VendastaAccount getAccount() {
        return account;
    }

    public void setAccount(VendastaAccount account) {
        this.account = account;
    }

    public String getOrderFormSubmissionId() {
        return orderFormSubmissionId;
    }

    public void setOrderFormSubmissionId(String orderFormSubmissionId) {
        this.orderFormSubmissionId = orderFormSubmissionId;
    }

    public String getVendorOrderId() {
        return vendorOrderId;
    }

    public void setVendorOrderId(String vendorOrderId) {
        this.vendorOrderId = vendorOrderId;
    }

    public VendastaOrderForm getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(VendastaOrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getPreviousEditionId() {
        return previousEditionId;
    }

    public void setPreviousEditionId(String previousEditionId) {
        this.previousEditionId = previousEditionId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getEditionId() {
        return editionId;
    }

    public void setEditionId(String editionId) {
        this.editionId = editionId;
    }

    public String getActivationId() {
        return activationId;
    }

    public void setActivationId(String activationId) {
        this.activationId = activationId;
    }

    public String getDeactivationTime() {
        return deactivationTime;
    }

    public void setDeactivationTime(String deactivationTime) {
        this.deactivationTime = deactivationTime;
    }

    public String getWebhookId() {
        return webhookId;
    }

    public void setWebhookId(String webhookId) {
        this.webhookId = webhookId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(String activationTime) {
        this.activationTime = activationTime;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getAddonId() {
        return addonId;
    }

    public void setAddonId(String addonId) {
        this.addonId = addonId;
    }

    public String getAccountGroupId() {
        return accountGroupId;
    }

    public void setAccountGroupId(String accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    public List<String> getCancellationChoices() {
        return cancellationChoices;
    }

    public void setCancellationChoices(List<String> cancellationChoices) {
        this.cancellationChoices = cancellationChoices;
    }

    public String getCancellationComment() {
        return cancellationComment;
    }

    public void setCancellationComment(String cancellationComment) {
        this.cancellationComment = cancellationComment;
    }

    public String getCancellationTime() {
        return cancellationTime;
    }

    public void setCancellationTime(String cancellationTime) {
        this.cancellationTime = cancellationTime;
    }
}
