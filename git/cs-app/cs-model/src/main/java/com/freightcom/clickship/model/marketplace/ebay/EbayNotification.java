package com.freightcom.clickship.model.marketplace.ebay;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EbayNotification implements Serializable {

	private static final long serialVersionUID = -1839260649443529342L;
	
	private String userId;
	
	private String username;
	
	private String eiasToken;

	private EbayNotificationData notification;
	
	private EbayNotificationMetaData metadata;

	public String getUserId() {
		return userId;
	}

	public EbayNotification setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public EbayNotification setUsername(String username) {
		this.username = username;
		return this;		
	}

	public String getEiasToken() {
		return eiasToken;
	}

	public EbayNotification setEiasToken(String eiasToken) {
		this.eiasToken = eiasToken;
		return this;		
	}
	
	public EbayNotificationData getNotification() {
		return notification;
	}

	public void setNotification(EbayNotificationData notification) {
		this.notification = notification;
	}

	public EbayNotificationMetaData getMetadata() {
		return metadata;
	}

	public EbayNotification setMetadata(EbayNotificationMetaData metadata) {
		this.metadata = metadata;
		return this;		
	}
	
}
