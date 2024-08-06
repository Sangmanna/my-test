package com.freightcom.clickship.model.custombranding;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.util.ObjectMapperUtil;

public class BrandingV2TrackingSettingDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -6018829207861299211L;
	
	private String id;
	
	private boolean storeLogo = true;
	
	private boolean storeWebsite = true;
	
	private boolean emailAddress = true;
	
	private boolean socialLink = true;
	
	private boolean productPrice = true;
	
	private boolean productImage = true;
	
	private boolean carrierLogo = true;
	
	private String companyBannerLinkUrl;
	
	private String companyBannerImageUrl;
	
	private List<KeyValue> navigationLink;
	
	private String promotionalBannerLinkUrl;
	
	private String promotionalBannerImageUrl;
	
	private boolean useCustomBrandingTracking = true;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(boolean storeLogo) {
		this.storeLogo = storeLogo;
	}

	public boolean isEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(boolean emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isStoreWebsite() {
		return storeWebsite;
	}

	public void setStoreWebsite(boolean storeWebsite) {
		this.storeWebsite = storeWebsite;
	}

	public String getNavigationLinkJson() {
		return ObjectMapperUtil.toJson(navigationLink);
	}

	public void setNavigationLinkJson(String navigationLinkJson) {
		this.navigationLink = ObjectMapperUtil.fromJson(navigationLinkJson, new TypeReference<List<KeyValue>>() {
		});
	}

	public boolean isSocialLink() {
		return socialLink;
	}

	public void setSocialLink(boolean socialLink) {
		this.socialLink = socialLink;
	}

	public boolean isProductPrice() {
		return productPrice;
	}

	public void setProductPrice(boolean productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isProductImage() {
		return productImage;
	}

	public void setProductImage(boolean productImage) {
		this.productImage = productImage;
	}

	public boolean isCarrierLogo() {
		return carrierLogo;
	}

	public void setCarrierLogo(boolean carrierLogo) {
		this.carrierLogo = carrierLogo;
	}

	public String getCompanyBannerImageUrl() {
		return companyBannerImageUrl;
	}

	public void setCompanyBannerImageUrl(String companyBannerImageUrl) {
		this.companyBannerImageUrl = companyBannerImageUrl;
	}

	public String getCompanyBannerLinkUrl() {
		return companyBannerLinkUrl;
	}

	public void setCompanyBannerLinkUrl(String companyBannerLinkUrl) {
		this.companyBannerLinkUrl = companyBannerLinkUrl;
	}

	public String getPromotionalBannerImageUrl() {
		return promotionalBannerImageUrl;
	}

	public void setPromotionalBannerImageUrl(String promotionalBannerImageUrl) {
		this.promotionalBannerImageUrl = promotionalBannerImageUrl;
	}

	public String getPromotionalBannerLinkUrl() {
		return promotionalBannerLinkUrl;
	}

	public void setPromotionalBannerLinkUrl(String promotionalBannerLinkUrl) {
		this.promotionalBannerLinkUrl = promotionalBannerLinkUrl;
	}

	public List<KeyValue> getNavigationLink() {
		return navigationLink;
	}

	public void setNavigationLink(List<KeyValue> navigationLink) {
		this.navigationLink = navigationLink;
	}

	public boolean isUseCustomBrandingTracking() {
		return useCustomBrandingTracking;
	}

	public void setUseCustomBrandingTracking(boolean useCustomBrandingTracking) {
		this.useCustomBrandingTracking = useCustomBrandingTracking;
	}
}