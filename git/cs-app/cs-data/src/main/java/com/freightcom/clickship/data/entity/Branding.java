package com.freightcom.clickship.data.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;

/**
 * Entity class for Custom Branding - Global Setting tab's attributes
 * 
 * @author sangmann
 */
@Entity
@Table(name = "branding")
public class Branding extends BaseEntity implements CustomerAssociateEntity {

	private static final long serialVersionUID = 6867316874381049239L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	private Customer customer;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_id")
	private Marketplace marketplace;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "branding", cascade = CascadeType.ALL)
	private BrandingTrackingSettings brandingTrackingSettings;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "branding", cascade = CascadeType.ALL)
	private List<BrandingEmailSettings> brandingEmailSettings;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_address_id")
	private CustomerAddress customerAddress;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "store_logo_url")
	private String storeLogoUrl;

	@Column(name = "store_logo_click_link_url")
	private String storeLogoClickLinkURL;

	@Column(name = "track_button_color")
	private String trackButtonColor;

	@Column(name = "track_button_text_color")
	private String trackButtonTextColor;

	@Column(name = "full_order_color")
	private String fullOrderColor;

	@Column(name = "full_order_text_color")
	private String fullOrderTextColor;

	@Column(name = "apply_logo_to_shipping_label")
	private boolean applyLogoToShippingLabel;

	@Column(name = "apply_logo_to_packing_slips")
	private boolean applyLogoToPackingSlips;
	
	@Column(name = "add_clickship_branding_from_tracking_page")
	private boolean addClickshipBrandingFromTrackingPage = true;
	
	@Column(name = "add_clickship_branding_from_emails")
	private boolean addClickshipBrandingFromEmails = true;

	@Column(name = "social_link_json")
	private String socialLinkJson;

	@Column(name = "status")
	private String status = "step1";

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	public BrandingTrackingSettings getBrandingTrackingSettings() {
		return brandingTrackingSettings;
	}

	public void setBrandingTracking(BrandingTrackingSettings brandingTrackingSettings) {
		this.brandingTrackingSettings = brandingTrackingSettings;
		if (brandingTrackingSettings.getBranding() == null) {
			brandingTrackingSettings.setBranding(this);
		}
	}

	public List<BrandingEmailSettings> getBrandingEmails() {
		return brandingEmailSettings;
	}

	public void setBrandingEmailSettings(List<BrandingEmailSettings> brandingEmailSettings) {
		this.brandingEmailSettings = brandingEmailSettings;
		brandingEmailSettings.forEach(be -> {
			if (be.getBranding() == null) {
				be.setBranding(this);
			}
		});
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
		return socialLinkJson;
	}

	public void setSocialLinkJson(String socialLinkJson) {
		this.socialLinkJson = socialLinkJson;
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

	public String getStatus() {
		return status;
	}

	/**
	 * 'step1': before the first tab saved
	 * 'step2': before the second tab saved
	 * 'step3': before the 3rd tab saved
	 * 'active': after 3rd tab saved
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
