package com.freightcom.clickship.model.custombranding;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.customer.CustomerAddressDTO;
import com.freightcom.clickship.model.util.ObjectMapperUtil;

public class BrandingV2DTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = 8475206986939827188L;
	
	private String id;
	
	private String marketplaceId;
	
	private String marketplaceName;
	
	private String marketplaceType;
	
	private long marketplaceTypeSeq;
	
	private String customerAddressId;
	
	private String phoneNumber;
	
	private String companyName;
	
	private String emailAddress;
	
	private String storeLogoUrl;
	
	private String storeLogoClickLinkURL;
	
	private String trackButtonColor;
	
	private String trackButtonTextColor;
	
	private String fullOrderColor;
	
	private String fullOrderTextColor;
	
	private boolean applyLogoToShippingLabel;
	
	private boolean applyLogoToPackingSlips;
	
	private boolean addClickshipBrandingFromEmails = true;
	
	private boolean addClickshipBrandingFromTrackingPage = true;
	
	private List<KeyValue> socialLink;

	private String status = "step1";
	
	private CustomerAddressDTO customerAddressDTO;

	private List<BrandingV2EmailSettingDTO> brandingEmailSettings;
	
	private BrandingV2TrackingSettingDTO brandingTrackingSettings;
	
	private Timestamp updateDatetime;
	
	private Timestamp createDatetime;
	
	private boolean finishSave = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	
	public String getCustomerAddressId() {
		return customerAddressId;
	}

	public void setCustomerAddressId(String customerAddressId) {
		this.customerAddressId = customerAddressId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getStoreLogoUrl() {
		return storeLogoUrl;
	}

	public void setStoreLogoUrl(String storeLogoUrl) {
		this.storeLogoUrl = storeLogoUrl;
	}

	public String getStoreLogoClickLinkURL() {
		return storeLogoClickLinkURL;
	}

	public void setStoreLogoClickLinkURL(String storeLogoClickLinkURL) {
		this.storeLogoClickLinkURL = storeLogoClickLinkURL;
	}

	public String getSocialLinkJson() {
		return ObjectMapperUtil.toJson(socialLink);
	}

	public void setSocialLinkJson(String socialLinkJson) {
		this.socialLink = ObjectMapperUtil.fromJson(socialLinkJson, new TypeReference<List<KeyValue>>() {
		});
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BrandingV2EmailSettingDTO> getBrandingEmailSettings() {
		return brandingEmailSettings;
	}

	public void setBrandingEmailSettings(List<BrandingV2EmailSettingDTO> brandingEmailSettings) {
		this.brandingEmailSettings = brandingEmailSettings;
	}

	public BrandingV2TrackingSettingDTO getBrandingTrackingSettings() {
		return brandingTrackingSettings;
	}

	public void setBrandingTrackingSettings(BrandingV2TrackingSettingDTO brandingTrackingSettings) {
		this.brandingTrackingSettings = brandingTrackingSettings;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<KeyValue> getSocialLink() {
		return socialLink;
	}

	public void setSocialLink(List<KeyValue> socialLink) {
		this.socialLink = socialLink;
	}

	public CustomerAddressDTO getCustomerAddressDTO() {
		return customerAddressDTO;
	}

	public void setCustomerAddressDTO(CustomerAddressDTO customerAddressDTO) {
		this.customerAddressDTO = customerAddressDTO;
	}

	public String getTrackButtonColor() {
		return trackButtonColor;
	}

	public void setTrackButtonColor(String trackButtonColor) {
		this.trackButtonColor = trackButtonColor;
	}

	public String getTrackButtonTextColor() {
		return trackButtonTextColor;
	}

	public void setTrackButtonTextColor(String trackButtonTextColor) {
		this.trackButtonTextColor = trackButtonTextColor;
	}

	public String getFullOrderColor() {
		return fullOrderColor;
	}

	public void setFullOrderColor(String fullOrderColor) {
		this.fullOrderColor = fullOrderColor;
	}

	public String getFullOrderTextColor() {
		return fullOrderTextColor;
	}

	public void setFullOrderTextColor(String fullOrderTextColor) {
		this.fullOrderTextColor = fullOrderTextColor;
	}

	public boolean isApplyLogoToShippingLabel() {
		return applyLogoToShippingLabel;
	}

	public void setApplyLogoToShippingLabel(boolean applyLogoToShippingLabel) {
		this.applyLogoToShippingLabel = applyLogoToShippingLabel;
	}

	public boolean isApplyLogoToPackingSlips() {
		return applyLogoToPackingSlips;
	}

	public void setApplyLogoToPackingSlips(boolean applyLogoToPackingSlips) {
		this.applyLogoToPackingSlips = applyLogoToPackingSlips;
	}

	public boolean isFinishSave() {
		return finishSave;
	}

	public void setFinishSave(boolean finishSave) {
		this.finishSave = finishSave;
	}

	public String getMarketplaceName() {
		return marketplaceName;
	}

	public void setMarketplaceName(String marketplaceName) {
		this.marketplaceName = marketplaceName;
	}

	public String getMarketplaceType() {
		return marketplaceType;
	}

	public void setMarketplaceType(String marketplaceType) {
		this.marketplaceType = marketplaceType;
	}

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public long getMarketplaceTypeSeq() {
		return marketplaceTypeSeq;
	}

	public void setMarketplaceTypeSeq(long marketplaceTypeSeq) {
		this.marketplaceTypeSeq = marketplaceTypeSeq;
	}

	public boolean isAddClickshipBrandingFromTrackingPage() {
		return addClickshipBrandingFromTrackingPage;
	}

	public void setAddClickshipBrandingFromTrackingPage(boolean addClickshipBrandingFromTrackingPage) {
		this.addClickshipBrandingFromTrackingPage = addClickshipBrandingFromTrackingPage;
	}

	public boolean isAddClickshipBrandingFromEmails() {
		return addClickshipBrandingFromEmails;
	}

	public void setAddClickshipBrandingFromEmails(boolean addClickshipBrandingFromEmails) {
		this.addClickshipBrandingFromEmails = addClickshipBrandingFromEmails;
	}
}