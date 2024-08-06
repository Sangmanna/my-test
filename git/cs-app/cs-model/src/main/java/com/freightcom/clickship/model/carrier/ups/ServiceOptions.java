package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceOptions implements Serializable {

	private static final long serialVersionUID = -6470922269787629377L;

	@JsonProperty("Insurance")
	private UpsInsurance insurance;

	@JsonAlias({ "DeclaredValue", "ShipperDeclaredValue" })
	private UpsMoney declaredValue;

	@JsonProperty("InternationalForms")
	private InternationalForms internationalForms;

	@JsonProperty("DeliveryConfirmation")
	private DeliveryConfirmation deliveryConfirmation;

	@JsonProperty("NegotiatedRatesIndicator")
	private String negotiatedRatesIndicator;

	@JsonProperty("UserLevelDiscountIndicator")
	private String userLevelDiscountIndicator;

	public UpsInsurance getInsurance() {
		return insurance;
	}

	public void setInsurance(UpsInsurance insurance) {
		this.insurance = insurance;
	}

	public UpsMoney getDeclaredValue() {
		return declaredValue;
	}

	public void setDeclaredValue(UpsMoney declaredValue) {
		this.declaredValue = declaredValue;
	}

	public InternationalForms getInternationalForms() {
		return internationalForms;
	}

	public void setInternationalForms(InternationalForms internationalForms) {
		this.internationalForms = internationalForms;
	}

	public DeliveryConfirmation getDeliveryConfirmation() {
		return deliveryConfirmation;
	}

	public void setDeliveryConfirmation(DeliveryConfirmation deliveryConfirmation) {
		this.deliveryConfirmation = deliveryConfirmation;
	}

	public String getNegotiatedRatesIndicator() {
		return negotiatedRatesIndicator;
	}

	public void setNegotiatedRatesIndicator(String negotiatedRatesIndicator) {
		this.negotiatedRatesIndicator = negotiatedRatesIndicator;
	}

	public String getUserLevelDiscountIndicator() {
		return userLevelDiscountIndicator;
	}

	public void setUserLevelDiscountIndicator(String userLevelDiscountIndicator) {
		this.userLevelDiscountIndicator = userLevelDiscountIndicator;
	}

}
