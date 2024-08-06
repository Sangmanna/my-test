package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class ShipmentTemp {

    @JsonProperty("MidBOLNumber")
    private String midBOLNumber;
    @JsonProperty("Reference")
    private String reference;
    @JsonProperty("PONumber")
    private String pONumber;
    @JsonProperty("ShippingTerms")
    private String shippingTerms;
    @JsonProperty("ManifestNumber")
    private String manifestNumber;
    @JsonProperty("ShipYear")
    private String shipYear;
    @JsonProperty("ShipMonth")
    private String shipMonth;
    @JsonProperty("ShipDay")
    private String shipDay;
    @JsonProperty("ConsigneeName")
    private String consigneeName;
    @JsonProperty("ConsigneeAddress1")
    private String consigneeAddress1;
    @JsonProperty("ConsigneeAddress2")
    private String consigneeAddress2;
    @JsonProperty("ConsigneeCity")
    private String consigneeCity;
    @JsonProperty("ConsigneeProvince")
    private String consigneeProvince;
    @JsonProperty("ConsigneeCountry")
    private String consigneeCountry;
    @JsonProperty("ConsigneePostalCode")
    private String consigneePostalCode;
    @JsonProperty("ConsigneeAreaCode")
    private String consigneeAreaCode;
    @JsonProperty("ConsigneePhone")
    private String consigneePhone;
    @JsonProperty("Service")
    private String service;
    @JsonProperty("Pieces")
    private String pieces;
    @JsonProperty("Weight")
    private String weight;
    @JsonProperty("WeightQualifier")
    private String weightQualifier;
    @JsonProperty("CubicWeight")
    private String cubicWeight;
    @JsonProperty("CubicWeightQualifier")
    private String cubicWeightQualifier;
    @JsonProperty("DangerousGoods")
    private String dangerousGoods;
    @JsonProperty("HeatedService")
    private String heatedService;
    @JsonProperty("WeekendDelivery")
    private String weekendDelivery;
    @JsonProperty("COD")
    private String cod;
    @JsonProperty("CODAmount")
    private String codAmount;
    @JsonProperty("SpecialInstructions1")
    private String specialInstructions1;
    @JsonProperty("SpecialInstructions2")
    private String specialInstructions2;
    @JsonProperty("InsuranceValue")
    private String insuranceValue;
    @JsonProperty("AuthorizationNumber")
    private String authorizationNumber;
    @JsonProperty("AppointmentDelivery")
    private String appointmentDelivery;
    @JsonProperty("AppointmentDate")
    private String appointmentDate;
    @JsonProperty("AppointmentTime")
    private String appointmentTime;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("ChequeReturnAmount")
    private String chequeReturnAmount;
    @JsonProperty("HoldForPickup")
    private String holdForPickup;
    @JsonProperty("9amDelivery")
    private String nineAMDelivery;
    @JsonProperty("PrivateResidence")
    private String privateResidence;
    @JsonProperty("HydraulicLift")
    private String hydraulicLift;
    @JsonProperty("NoSignatureRequired")
    private String noSignatureRequired;
    @JsonProperty("SignatureRequired")
    private String signatureRequired;

    public String getMidBOLNumber() {
        return midBOLNumber;
    }

    public void setMidBOLNumber(String midBOLNumber) {
        this.midBOLNumber = midBOLNumber;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getpONumber() {
        return pONumber;
    }

    public void setpONumber(String pONumber) {
        this.pONumber = pONumber;
    }

    public String getShippingTerms() {
        return shippingTerms;
    }

    public void setShippingTerms(String shippingTerms) {
        this.shippingTerms = shippingTerms;
    }

    public String getManifestNumber() {
        return manifestNumber;
    }

    public void setManifestNumber(String manifestNumber) {
        this.manifestNumber = manifestNumber;
    }

    public String getShipYear() {
        return shipYear;
    }

    public void setShipYear(String shipYear) {
        this.shipYear = shipYear;
    }

    public String getShipMonth() {
        return shipMonth;
    }

    public void setShipMonth(String shipMonth) {
        this.shipMonth = shipMonth;
    }

    public String getShipDay() {
        return shipDay;
    }

    public void setShipDay(String shipDay) {
        this.shipDay = shipDay;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAddress1() {
        return consigneeAddress1;
    }

    public void setConsigneeAddress1(String consigneeAddress1) {
        this.consigneeAddress1 = consigneeAddress1;
    }

    public String getConsigneeAddress2() {
        return consigneeAddress2;
    }

    public void setConsigneeAddress2(String consigneeAddress2) {
        this.consigneeAddress2 = consigneeAddress2;
    }

    public String getConsigneeCity() {
        return consigneeCity;
    }

    public void setConsigneeCity(String consigneeCity) {
        this.consigneeCity = consigneeCity;
    }

    public String getConsigneeProvince() {
        return consigneeProvince;
    }

    public void setConsigneeProvince(String consigneeProvince) {
        this.consigneeProvince = consigneeProvince;
    }

    public String getConsigneeCountry() {
        return consigneeCountry;
    }

    public void setConsigneeCountry(String consigneeCountry) {
        this.consigneeCountry = consigneeCountry;
    }

    public String getConsigneePostalCode() {
        return consigneePostalCode;
    }

    public void setConsigneePostalCode(String consigneePostalCode) {
        this.consigneePostalCode = consigneePostalCode;
    }

    public String getConsigneeAreaCode() {
        return consigneeAreaCode;
    }

    public void setConsigneeAreaCode(String consigneeAreaCode) {
        this.consigneeAreaCode = consigneeAreaCode;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightQualifier() {
        return weightQualifier;
    }

    public void setWeightQualifier(String weightQualifier) {
        this.weightQualifier = weightQualifier;
    }

    public String getCubicWeight() {
        return cubicWeight;
    }

    public void setCubicWeight(String cubicWeight) {
        this.cubicWeight = cubicWeight;
    }

    public String getCubicWeightQualifier() {
        return cubicWeightQualifier;
    }

    public void setCubicWeightQualifier(String cubicWeightQualifier) {
        this.cubicWeightQualifier = cubicWeightQualifier;
    }

    public String getDangerousGoods() {
        return dangerousGoods;
    }

    public void setDangerousGoods(String dangerousGoods) {
        this.dangerousGoods = dangerousGoods;
    }

    public String getHeatedService() {
        return heatedService;
    }

    public void setHeatedService(String heatedService) {
        this.heatedService = heatedService;
    }

    public String getWeekendDelivery() {
        return weekendDelivery;
    }

    public void setWeekendDelivery(String weekendDelivery) {
        this.weekendDelivery = weekendDelivery;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCodAmount() {
        return codAmount;
    }

    public void setCodAmount(String codAmount) {
        this.codAmount = codAmount;
    }

    public String getSpecialInstructions1() {
        return specialInstructions1;
    }

    public void setSpecialInstructions1(String specialInstructions1) {
        this.specialInstructions1 = specialInstructions1;
    }

    public String getSpecialInstructions2() {
        return specialInstructions2;
    }

    public void setSpecialInstructions2(String specialInstructions2) {
        this.specialInstructions2 = specialInstructions2;
    }

    public String getInsuranceValue() {
        return insuranceValue;
    }

    public void setInsuranceValue(String insuranceValue) {
        this.insuranceValue = insuranceValue;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public void setAuthorizationNumber(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }

    public String getAppointmentDelivery() {
        return appointmentDelivery;
    }

    public void setAppointmentDelivery(String appointmentDelivery) {
        this.appointmentDelivery = appointmentDelivery;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChequeReturnAmount() {
        return chequeReturnAmount;
    }

    public void setChequeReturnAmount(String chequeReturnAmount) {
        this.chequeReturnAmount = chequeReturnAmount;
    }

    public String getHoldForPickup() {
        return holdForPickup;
    }

    public void setHoldForPickup(String holdForPickup) {
        this.holdForPickup = holdForPickup;
    }

    public String getNineAMDelivery() {
        return nineAMDelivery;
    }

    public void setNineAMDelivery(String nineAMDelivery) {
        this.nineAMDelivery = nineAMDelivery;
    }

    public String getPrivateResidence() {
        return privateResidence;
    }

    public void setPrivateResidence(String privateResidence) {
        this.privateResidence = privateResidence;
    }

    public String getHydraulicLift() {
        return hydraulicLift;
    }

    public void setHydraulicLift(String hydraulicLift) {
        this.hydraulicLift = hydraulicLift;
    }

    public String getNoSignatureRequired() {
        return noSignatureRequired;
    }

    public void setNoSignatureRequired(String noSignatureRequired) {
        this.noSignatureRequired = noSignatureRequired;
    }

    public String getSignatureRequired() {
        return signatureRequired;
    }

    public void setSignatureRequired(String signatureRequired) {
        this.signatureRequired = signatureRequired;
    }
}
