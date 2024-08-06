package com.freightcom.clickship.data.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;

@Entity
@Table(name = "adv_shipping_rule_action")
public class AdvShippingRuleAction extends BaseEntity implements CustomerAssociateEntity {

	private static final long serialVersionUID = 7889818998069004073L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipping_rule_id", nullable = false)
	private AdvancedShippingRule shippingRule;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_rule_additional_options_id", nullable = true)
	@JsonIgnore
	private ShippingRuleAdditionalOptions shippingRuleAdditionalOptions;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "advShippingRuleAction", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShippingRuleBox> shippingRuleBoxes;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipping_origin_id", nullable = true)
	private CustomerAddress shippingOrigin;

	@Column(name = "insurance_type")
	private int insuranceType;

	@Column(name = "insurance_amount")
	private Double insuranceAmount;

	@Column(name = "insurance_currency")
	private String insuranceCurrency;

	@Column(name = "insurance_signature_required")
	private boolean insuranceSignatureRequired;

	@Column(name = "insurance_adult_signature_required")
	private boolean insuranceAdultSignatureRequired;

	@Column(name = "accept_freightcom_insurance")
	private boolean acceptFreightcomInsurance;

	@Column(name = "accept_carrier_insurance")
	private boolean acceptCarrierInsurance;

	@Column(name = "shipping_preference")
	private String shippingPreference;
	
	@Column(name = "display_white_glove_rates")
	private boolean displayWhiteGloveRates;
	
	@Column(name = "display_pallet_and_package_rates")
	private boolean displayPalletAndPackageRates;

	@Column(name = "carrier_shipping_preference")
	private String carrierShippingPreference;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "advShippingRuleAction", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShippingRuleCarrier> shippingRuleCarriers;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "advShippingRuleAction", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShippingRuleTag> shippingRuleTags;

	@Column(name = "shipping_rate_type")
	private String shippingRateType;

	@Column(name = "shipping_rate_value")
	private Double shippingRateValue;

	@Column(name = "shipping_rate_currency")
	private String shippingRateCurrency;

	@Column(name = "shipping_rate_custom_message")
	private String shippingRateCustomMessage;
	
	@Column(name = "realtime_price_markup")
	private double realtimePriceMarkup = 0d;

	@Column(name = "is_realtime_price_percent")
	private boolean realtimePricePercent = false;

	@Column(name = "is_realtime_price_down")
	private boolean realtimePriceDown = false;

	@Column(name = "pallet_markup_mode")
	private boolean palletMarkupMode = false;

	@Column(name = "pallet_markup_type")
	private boolean palletMarkupType = false;

	@Column(name = "pallet_markup_value")
	private double palletMarkupValue = 0d;

	@Column(name = "auto_fulfill")
	private Boolean autoFulfill;

	@Column(name = "auto_fulfill_country")
	private String autoFulfillCountry;

	@Column(name = "rtr_processing_time")
	private boolean rtrProcessingTime = true;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "applied_actions")
	private String appliedActions;
	
	public AdvancedShippingRule getShippingRule() {
		return shippingRule;
	}

	public void setShippingRule(AdvancedShippingRule shippingRule) {
		this.shippingRule = shippingRule;
	}

	public CustomerAddress getShippingOrigin() {
		return shippingOrigin;
	}

	public void setShippingOrigin(CustomerAddress shippingOrigin) {
		this.shippingOrigin = shippingOrigin;
	}

	public int getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(int insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getShippingPreference() {
		return shippingPreference;
	}

	public void setShippingPreference(String shippingPreference) {
		this.shippingPreference = shippingPreference;
	}

	public String getShippingRateType() {
		return shippingRateType;
	}

	public void setShippingRateType(String shippingRateType) {
		this.shippingRateType = shippingRateType;
	}

	public Double getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public Double getShippingRateValue() {
		return shippingRateValue;
	}

	public void setShippingRateValue(Double shippingRateValue) {
		this.shippingRateValue = shippingRateValue;
	}

	public double getRealtimePriceMarkup() {
		return realtimePriceMarkup;
	}

	public void setRealtimePriceMarkup(double realtimePriceMarkup) {
		this.realtimePriceMarkup = realtimePriceMarkup;
	}

	public boolean isRealtimePricePercent() {
		return realtimePricePercent;
	}

	public void setRealtimePricePercent(boolean realtimePricePercent) {
		this.realtimePricePercent = realtimePricePercent;
	}

	public boolean isRealtimePriceDown() {
		return realtimePriceDown;
	}

	public void setRealtimePriceDown(boolean realtimePriceDown) {
		this.realtimePriceDown = realtimePriceDown;
	}

	public boolean isPalletMarkupMode() {
		return palletMarkupMode;
	}

	public void setPalletMarkupMode(boolean palletMarkupMode) {
		this.palletMarkupMode = palletMarkupMode;
	}

	public boolean isPalletMarkupType() {
		return palletMarkupType;
	}

	public void setPalletMarkupType(boolean palletMarkupType) {
		this.palletMarkupType = palletMarkupType;
	}

	public double getPalletMarkupValue() {
		return palletMarkupValue;
	}

	public void setPalletMarkupValue(double palletMarkupValue) {
		this.palletMarkupValue = palletMarkupValue;
	}

	public boolean isRtrProcessingTime() {
		return rtrProcessingTime;
	}

	public void setRtrProcessingTime(boolean rtrProcessingTime) {
		this.rtrProcessingTime = rtrProcessingTime;
	}

	public Boolean getAutoFulfill() {
		return autoFulfill;
	}

	public void setAutoFulfill(Boolean autoFulfill) {
		this.autoFulfill = autoFulfill;
	}

	public String getAutoFulfillCountry() {
		return autoFulfillCountry;
	}

	public void setAutoFulfillCountry(String autoFulfillCountry) {
		this.autoFulfillCountry = autoFulfillCountry;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		return this;
	}

	public ShippingRuleAdditionalOptions getShippingRuleAdditionalOptions() {
		return shippingRuleAdditionalOptions;
	}

	public void setShippingRuleAdditionalOptions(ShippingRuleAdditionalOptions shippingRuleAdditionalOptions) {
		this.shippingRuleAdditionalOptions = shippingRuleAdditionalOptions;
	}

	public List<ShippingRuleCarrier> getShippingRuleCarriers() {
		return shippingRuleCarriers;
	}

	public void setShippingRuleCarriers(List<ShippingRuleCarrier> shippingRuleCarriers) {
		if (shippingRuleCarriers != null) {
			shippingRuleCarriers.forEach(carrier -> carrier.setAdvShippingRuleAction(this));
		}
		this.shippingRuleCarriers = shippingRuleCarriers;
	}

	public List<ShippingRuleBox> getShippingRuleBoxes() {
		return shippingRuleBoxes;
	}

	public void setShippingRuleBoxes(List<ShippingRuleBox> shippingRuleBoxes) {
		if (shippingRuleBoxes != null) {
			shippingRuleBoxes.forEach(box -> box.setAdvShippingRuleAction(this));
		}
		this.shippingRuleBoxes = shippingRuleBoxes;
	}

	public String getInsuranceCurrency() {
		return insuranceCurrency;
	}

	public void setInsuranceCurrency(String insuranceCurrency) {
		this.insuranceCurrency = insuranceCurrency;
	}

	public String getShippingRateCurrency() {
		return shippingRateCurrency;
	}

	public void setShippingRateCurrency(String shippingRateCurrency) {
		this.shippingRateCurrency = shippingRateCurrency;
	}

	public List<ShippingRuleTag> getShippingRuleTags() {
		return shippingRuleTags;
	}

	public void setShippingRuleTags(List<ShippingRuleTag> shippingRuleTags) {
		if (shippingRuleTags != null) {
			shippingRuleTags.forEach(tag -> tag.setAdvShippingRuleAction(this));
		}
		this.shippingRuleTags = shippingRuleTags;
	}

	public boolean isAcceptFreightcomInsurance() {
		return acceptFreightcomInsurance;
	}

	public void setAcceptFreightcomInsurance(boolean acceptFreightcomInsurance) {
		this.acceptFreightcomInsurance = acceptFreightcomInsurance;
	}

	public boolean isAcceptCarrierInsurance() {
		return acceptCarrierInsurance;
	}

	public void setAcceptCarrierInsurance(boolean acceptCarrierInsurance) {
		this.acceptCarrierInsurance = acceptCarrierInsurance;
	}

	public boolean isInsuranceSignatureRequired() {
		return insuranceSignatureRequired;
	}

	public void setInsuranceSignatureRequired(boolean insuranceSignatureRequired) {
		this.insuranceSignatureRequired = insuranceSignatureRequired;
	}

	public boolean isInsuranceAdultSignatureRequired() {
		return insuranceAdultSignatureRequired;
	}

	public void setInsuranceAdultSignatureRequired(boolean insuranceAdultSignatureRequired) {
		this.insuranceAdultSignatureRequired = insuranceAdultSignatureRequired;
	}	
	public String getCarrierShippingPreference() {
		return carrierShippingPreference;
	}

	public void setCarrierShippingPreference(String carrierShippingPreference) {
		this.carrierShippingPreference = carrierShippingPreference;
	}

	public String getAppliedActions() {
		return appliedActions;
	}

	public void setAppliedActions(String appliedActions) {
		this.appliedActions = appliedActions;
	}

	public String getShippingRateCustomMessage() {
		return shippingRateCustomMessage;
	}

	public void setShippingRateCustomMessage(String shippingRateCustomMessage) {
		this.shippingRateCustomMessage = shippingRateCustomMessage;
	}

	public boolean isDisplayWhiteGloveRates() {
		return displayWhiteGloveRates;
	}

	public void setDisplayWhiteGloveRates(boolean displayWhiteGloveRates) {
		this.displayWhiteGloveRates = displayWhiteGloveRates;
	}

	public boolean isDisplayPalletAndPackageRates() {
		return displayPalletAndPackageRates;
	}

	public void setDisplayPalletAndPackageRates(boolean displayPalletAndPackageRates) {
		this.displayPalletAndPackageRates = displayPalletAndPackageRates;
	}
}
