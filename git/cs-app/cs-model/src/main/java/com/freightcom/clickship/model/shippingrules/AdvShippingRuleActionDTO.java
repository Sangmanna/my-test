package com.freightcom.clickship.model.shippingrules;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.freightcom.clickship.model.customer.CustomerAddressDTO;

public class AdvShippingRuleActionDTO {
	private String id;
	private int insuranceType;
    private Double insuranceAmount;
    private String insuranceCurrency;
    private boolean acceptFreightcomInsurance;
    private boolean acceptCarrierInsurance;
    private boolean insuranceSignatureRequired;
    private boolean insuranceAdultSignatureRequired;
    @NotNull
	@EnumValidate(value = ShippingPreferenceType.class, enumMethod = "getType")
    private String shippingPreference;
    @NotNull
  	@EnumValidate(value = ShippingPreferenceType.class, enumMethod = "getType")
    private String carrierShippingPreference;
    private String shippingRateType;
    private Double shippingRateValue;
    private String shippingRateCurrency;
    private double realtimePriceMarkup;
    private boolean realtimePricePercent;
    private boolean realtimePriceDown;
    private boolean palletMarkupMode;
    private boolean palletMarkupType;
    private double palletMarkupValue;
    private Boolean autoFulfill;
    private String autoFulfillCountry;
    private boolean rtrProcessingTime;
    private Boolean active;
    private String appliedActions;
    private String shippingRateCustomMessage;
	private boolean displayWhiteGloveRates;
	private boolean displayPalletAndPackageRates;
    private ShippingRuleAdditionalOptionsDTO shippingRuleAdditionalOptionsDTO;
    private List<ShippingRuleBoxDTO> shippingRuleBoxDTOs;
    private List<ShippingRuleCarrierDTO> shippingRuleCarrierDTOs;
    private List<ShippingRuleTagDTO> shippingRuleTagDTOs;
    private CustomerAddressDTO shippingOriginDTO;
	
	public int getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(int insuranceType) {
		this.insuranceType = insuranceType;
	}
	public Double getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
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
	public boolean isRtrProcessingTime() {
		return rtrProcessingTime;
	}
	public void setRtrProcessingTime(boolean rtrProcessingTime) {
		this.rtrProcessingTime = rtrProcessingTime;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public ShippingRuleAdditionalOptionsDTO getShippingRuleAdditionalOptionsDTO() {
		return shippingRuleAdditionalOptionsDTO;
	}
	public void setShippingRuleAdditionalOptionsDTO(ShippingRuleAdditionalOptionsDTO shippingRuleAdditionalOptionsDTO) {
		this.shippingRuleAdditionalOptionsDTO = shippingRuleAdditionalOptionsDTO;
	}
	public List<ShippingRuleBoxDTO> getShippingRuleBoxDTOs() {
		return shippingRuleBoxDTOs;
	}
	public void setShippingRuleBoxDTOs(List<ShippingRuleBoxDTO> shippingRuleBoxDTOs) {
		this.shippingRuleBoxDTOs = shippingRuleBoxDTOs;
	}
	public List<ShippingRuleCarrierDTO> getShippingRuleCarrierDTOs() {
		return shippingRuleCarrierDTOs;
	}
	public void setShippingRuleCarrierDTOs(List<ShippingRuleCarrierDTO> shippingRuleCarrierDTOs) {
		this.shippingRuleCarrierDTOs = shippingRuleCarrierDTOs;
	}	
	public CustomerAddressDTO getShippingOriginDTO() {
		return shippingOriginDTO;
	}
	public void setShippingOriginDTO(CustomerAddressDTO shippingOriginDTO) {
		this.shippingOriginDTO = shippingOriginDTO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<ShippingRuleTagDTO> getShippingRuleTagDTOs() {
		return shippingRuleTagDTOs;
	}
	public void setShippingRuleTagDTOs(List<ShippingRuleTagDTO> shippingRuleTagDTOs) {
		this.shippingRuleTagDTOs = shippingRuleTagDTOs;
	}
	public String getShippingRateCurrency() {
		return shippingRateCurrency;
	}
	public void setShippingRateCurrency(String shippingRateCurrency) {
		this.shippingRateCurrency = shippingRateCurrency;
	}
	public String getInsuranceCurrency() {
		return insuranceCurrency;
	}
	public void setInsuranceCurrency(String insuranceCurrency) {
		this.insuranceCurrency = insuranceCurrency;
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
