package com.freightcom.clickship.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

/**
 * Entity class for Custom Branding - Tracking Page tab's attributes
 * 
 * @author sangmann
 */
@Entity
@Table(name = "branding_tracking_settings")
public class BrandingTrackingSettings extends BaseEntity {
	
	private static final long serialVersionUID = -241813799652006159L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "branding_id", nullable = false, updatable = false)
	private Branding branding;
	
	@Column(name = "use_custom_branding_tracking")
	private boolean useCustomBrandingTracking = true;

	@Column(name = "store_logo")
	private boolean storeLogo = true;

	@Column(name = "store_website")
	private boolean storeWebsite = true;

	@Column(name = "email_address")
	private boolean emailAddress = true;

	@Column(name = "social_link")
	private boolean socialLink = true;

	@Column(name = "product_price")
	private boolean productPrice = true;

	@Column(name = "product_image")
	private boolean productImage = true;

	@Column(name = "carrier_logo")
	private boolean carrierLogo = true;

	@Column(name = "company_banner_image_url")
	private String companyBannerImageUrl;

	@Column(name = "company_banner_link_url")
	private String companyBannerLinkUrl;

	@Column(name = "promotional_banner_image_url")
	private String promotionalBannerImageUrl;

	@Column(name = "promotional_banner_link_url")
	private String promotionalBannerLinkUrl;

	@Column(name = "navigation_link_json")
	private String navigationLinkJson;

	public Branding getBranding() {
		return branding;
	}

	public void setBranding(Branding branding) {
		this.branding = branding;
	}
	
	public boolean isUseCustomBrandingTracking() {
		return useCustomBrandingTracking;
	}

	public void setUseCustomBrandingTracking(boolean useCustomBrandingTracking) {
		this.useCustomBrandingTracking = useCustomBrandingTracking;
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

	public String getNavigationLinkJson() {
		return navigationLinkJson;
	}

	public void setNavigationLinkJson(String navigationLinkJson) {
		this.navigationLinkJson = navigationLinkJson;
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

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}
}
