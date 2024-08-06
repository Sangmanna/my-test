package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.freightcom.clickship.model.marketplace.shopify.graphql.ShopifyGraphQLUserErrors;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyRecurringCharge implements Serializable {

	private static final long serialVersionUID = -5189600382345063264L;

	private String id;

	private String name;

	private Double price;

	private String currency;
	
	private String status;

	private String terms;

	private Boolean test;

	@JsonAlias({ "activated_on", "activatedOn" })
	private String activatedOn;

	@JsonAlias({ "billing_on", "billingOn" })
	private String billingOn;

	@JsonAlias({ "cancelled_on", "cancelledOn" })
	private String cancelledOn;

	@JsonAlias({ "capped_amount", "cappedAmount" })
	private String cappedAmount;

	@JsonAlias({ "confirmation_url", "confirmationUrl" })
	private String confirmationUrl;

	@JsonAlias({ "created_at", "createdAt" })
	private String createdAt;

	@JsonAlias({ "return_url", "returnUrl" })
	private String returnUrl;
	
	@JsonAlias({ "trial_days", "trialDays" })
	private int trialDays = 0;

	@JsonAlias({ "trial_ends_on", "trialEndsOn" })
	private Date trialEndsOn;

	@JsonAlias({ "updated_at", "updatedAt" })
	private String updatedAt;
	
	@JsonAlias({ "admin_graphql_api_id", "adminGraphqlApiId" })
	private String apiId;
	
	@JsonAlias({ "appSubscription", "app_subscription", "recurring_application_charge" })
	private ShopifyRecurringCharge appSubscription;
	
	@JsonAlias({ "lineItems", "line_items" })
	private List<ShopifyRecurringCharge> lineItems;
	
	private boolean showShopifyWindow = true;
	
//	@JsonAlias({ "errors", "userErrors" })
//	private List<ShopifyGraphQLUserErrors> errors;

	public ShopifyRecurringCharge() {
		super();
	}

	public String getId() {
		return id;
	}

	public ShopifyRecurringCharge setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ShopifyRecurringCharge setName(String name) {
		this.name = name;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public ShopifyRecurringCharge setPrice(Double price) {
		this.price = price;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public ShopifyRecurringCharge setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public ShopifyRecurringCharge setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getTerms() {
		return terms;
	}

	public ShopifyRecurringCharge setTerms(String terms) {
		this.terms = terms;
		return this;
	}

	public Boolean getTest() {
		return test;
	}

	public ShopifyRecurringCharge setTest(Boolean test) {
		this.test = test;
		return this;
	}

	public String getActivatedOn() {
		return activatedOn;
	}

	public ShopifyRecurringCharge setActivatedOn(String activatedOn) {
		this.activatedOn = activatedOn;
		return this;
	}

	public String getBillingOn() {
		return billingOn;
	}

	public ShopifyRecurringCharge setBillingOn(String billingOn) {
		this.billingOn = billingOn;
		return this;
	}

	public String getCancelledOn() {
		return cancelledOn;
	}

	public ShopifyRecurringCharge setCancelledOn(String cancelledOn) {
		this.cancelledOn = cancelledOn;
		return this;
	}

	public String getCappedAmount() {
		return cappedAmount;
	}

	public ShopifyRecurringCharge setCappedAmount(String cappedAmount) {
		this.cappedAmount = cappedAmount;
		return this;
	}

	public String getConfirmationUrl() {
		return confirmationUrl;
	}

	public ShopifyRecurringCharge setConfirmationUrl(String confirmationUrl) {
		this.confirmationUrl = confirmationUrl;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public ShopifyRecurringCharge setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public ShopifyRecurringCharge setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}

	public int getTrialDays() {
		return trialDays;
	}

	public ShopifyRecurringCharge setTrialDays(int trialDays) {
		this.trialDays = trialDays;
		return this;
	}

	public Date getTrialEndsOn() {
		return trialEndsOn;
	}

	public ShopifyRecurringCharge setTrialEndsOn(Date trialEndsOn) {
		this.trialEndsOn = trialEndsOn;
		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public ShopifyRecurringCharge setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public ShopifyRecurringCharge getAppSubscription() {
		return appSubscription;
	}

	public ShopifyRecurringCharge setAppSubscription(ShopifyRecurringCharge appSubscription) {
		this.appSubscription = appSubscription;
		return this;
	}

	public String getApiId() {
		return apiId;
	}

	public ShopifyRecurringCharge setApiId(String apiId) {
		this.apiId = apiId;
		return this;
	}

	public boolean isShowShopifyWindow() {
		return showShopifyWindow;
	}

	public ShopifyRecurringCharge setShowShopifyWindow(boolean showShopifyWindow) {
		this.showShopifyWindow = showShopifyWindow;
		return this;
	}

	public List<ShopifyRecurringCharge> getLineItems() {
		return lineItems;
	}

	public ShopifyRecurringCharge setLineItems(List<ShopifyRecurringCharge> lineItems) {
		this.lineItems = lineItems;
		return this;
	}

/**	public List<ShopifyGraphQLUserErrors> getErrors() {
		return errors;
	}

	public ShopifyRecurringCharge setErrors(List<ShopifyGraphQLUserErrors> errors) {
		this.errors = errors;
		return this;
	} */
}
