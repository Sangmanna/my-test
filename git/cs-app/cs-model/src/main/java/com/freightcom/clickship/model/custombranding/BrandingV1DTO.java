package com.freightcom.clickship.model.custombranding;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandingV1DTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -7614192275027672931L;

	private String emailSubject;
	
	private String emailMessage;
	
	private boolean logoEnabled;
	
	private boolean applyToEmail;
	
	private String emailHeadline;
	
	private String twitterHandle;
	
	private String linkedinHandle;
	
	private String facebookHandle;
	
	private boolean applyToLabels;
	
	private String instagramHandle;
	
	private int brandingImageWidth;

	private int brandingImageHeight;
	
	private String brandingImageUrl;
	
	private boolean applyToPackingSlips;
	
	private boolean emailSettingsEnabled;
	
	private String customerEmail;
	
	public String getBrandingImageUrl() {
		return brandingImageUrl;
	}

	public BrandingV1DTO setBrandingImageUrl(String brandingImageUrl) {
		this.brandingImageUrl = brandingImageUrl;
		return this;
	}

	public int getBrandingImageWidth() {
		return brandingImageWidth;
	}

	public BrandingV1DTO setBrandingImageWidth(int brandingImageWidth) {
		this.brandingImageWidth = brandingImageWidth;
		return this;
	}

	public int getBrandingImageHeight() {
		return brandingImageHeight;
	}

	public BrandingV1DTO setBrandingImageHeight(int brandingImageHeight) {
		this.brandingImageHeight = brandingImageHeight;
		return this;
	}

	public boolean getLogoEnabled() {
		return logoEnabled;
	}

	public BrandingV1DTO setLogoEnabled(boolean logoEnabled) {
		this.logoEnabled = logoEnabled;
		return this;
	}

	public boolean getApplyToEmail() {
		return applyToEmail;
	}

	public BrandingV1DTO setApplyToEmail(boolean applyToEmail) {
		this.applyToEmail = applyToEmail;
		return this;
	}

	public boolean getApplyToPackingSlips() {
		return applyToPackingSlips;
	}

	public BrandingV1DTO setApplyToPackingSlips(boolean applyToPackingSlips) {
		this.applyToPackingSlips = applyToPackingSlips;
		return this;
	}

	public boolean getApplyToLabels() {
		return applyToLabels;
	}

	public BrandingV1DTO setApplyToLabels(boolean applyToLabels) {
		this.applyToLabels = applyToLabels;
		return this;
	}

	public boolean getEmailSettingsEnabled() {
		return emailSettingsEnabled;
	}

	public BrandingV1DTO setEmailSettingsEnabled(boolean emailSettingsEnabled) {
		this.emailSettingsEnabled = emailSettingsEnabled;
		return this;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public BrandingV1DTO setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
		return this;
	}

	public String getEmailHeadline() {
		return emailHeadline;
	}

	public BrandingV1DTO setEmailHeadline(String emailHeadline) {
		this.emailHeadline = emailHeadline;
		return this;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public BrandingV1DTO setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
		return this;
	}

	public String getInstagramHandle() {
		return instagramHandle;
	}

	public BrandingV1DTO setInstagramHandle(String instagramHandle) {
		this.instagramHandle = instagramHandle;
		return this;
	}

	public String getFacebookHandle() {
		return facebookHandle;
	}

	public BrandingV1DTO setFacebookHandle(String facebookHandle) {
		this.facebookHandle = facebookHandle;
		return this;
	}

	public String getTwitterHandle() {
		return twitterHandle;
	}

	public BrandingV1DTO setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
		return this;
	}

	public String getLinkedinHandle() {
		return linkedinHandle;
	}

	public BrandingV1DTO setLinkedinHandle(String linkedinHandle) {
		this.linkedinHandle = linkedinHandle;
		return this;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public BrandingV1DTO setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
		return this;
	}

}
