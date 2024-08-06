package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.freightcom.clickship.model.constants.MarketplaceConstants;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceCallbackResponse {
	
	private String requestId;
	
	private String action;
	
	private String message;
	
	private boolean showLogin;
	
	private boolean showSignUp;
	
	private boolean showLanding;
	
	private boolean showErrorMessage;
	
	private String storeType = MarketplaceConstants.MARKETPLACE_TYPE_BIGCOMMERCE;
	
	public String getRequestId() {
		return requestId;
	}

	public BigCommerceCallbackResponse setRequestId(String requestId) {
		this.requestId = requestId;
		return this;
	}

	public String getAction() {
		return action;
	}

	public BigCommerceCallbackResponse setAction(String action) {
		this.action = action;
		return this;
	}

	public boolean isShowLanding() {
		return showLanding;
	}

	public BigCommerceCallbackResponse setShowLanding(boolean showLanding) {
		this.showLanding = showLanding;
		return this;
	}

	public boolean isShowLogin() {
		return showLogin;
	}

	public BigCommerceCallbackResponse setShowLogin(boolean showLogin) {
		this.showLogin = showLogin;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public BigCommerceCallbackResponse setMessage(String message) {
		this.message = message;
		return this;
	}

	public boolean isShowSignUp() {
		return showSignUp;
	}

	public BigCommerceCallbackResponse setShowSignUp(boolean showSignUp) {
		this.showSignUp = showSignUp;
		return this;
	}

	public boolean isShowErrorMessage() {
		return showErrorMessage;
	}

	public BigCommerceCallbackResponse setShowErrorMessage(boolean showErrorMessage) {
		this.showErrorMessage = showErrorMessage;
		return this;
	}

	public String getStoreType() {
		return storeType;
	}

	public BigCommerceCallbackResponse setStoreType(String storeType) {
		this.storeType = storeType;
		return this;
	}
	
}
