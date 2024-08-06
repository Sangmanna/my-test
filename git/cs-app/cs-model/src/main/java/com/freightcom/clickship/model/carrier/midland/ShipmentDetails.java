package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class ShipmentDetails {
    @JsonInclude(value= JsonInclude.Include.ALWAYS)
    private String source;
    private String labelformat;
    private String shipmentDate;
    @JsonInclude(value= JsonInclude.Include.ALWAYS)
    private String shipperAccountCode;
    private String shipperName;
    private String shipperAddress1;
    private String shipperAddress2;
    private String shipperCity;
    private String shipperStateCode;
    private String shipperPostal;
    private String shipperPhone;
    private String shipperContact;
    private String shipperEmail;
    @JsonInclude(value= JsonInclude.Include.ALWAYS)
    private String billtoAccountCode;
    private String consigneeName;
    private String consigneeAddress1;
    private String consigneeAddress2;
    private String consigneeCity;
    private String consigneeStateCode;
    private String consigneePostal;
    private String consigneePhone;
    private String consigneeContact;
    private String consigneeEmailBOL;
    private String paymentTerms;
    private String thirdpartyName;
    private String thirdpartyAddress1;
    private String thirdpartyAddress2;
    private String thirdpartyCity;
    private String thirdpartyStateCode;
    private String thirdpartyPostal;
    private String thirdpartyPhone;
    private String thirdpartyContact;
    private String thirdpartyEmail;
    private String serviceTypeCode;
    private int pieceCount;
    private double totalWeightLbs;
    private double totalWeightKgs;
    private String customerReference;
    private String poNumber;
    private String freightDescription;
    private String specialInstructions1;
    private String specialInstructions2;
    private double codAmount;
    private double insuranceAmount;
    private double checkReturnAmount;

    public String getLabelformat() {
        return labelformat;
    }

    public void setLabelformat(String labelformat) {
        this.labelformat = labelformat;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getShipperAccountCode() {
        return shipperAccountCode;
    }

    public void setShipperAccountCode(String shipperAccountCode) {
        this.shipperAccountCode = shipperAccountCode;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperAddress1() {
        return shipperAddress1;
    }

    public void setShipperAddress1(String shipperAddress1) {
        this.shipperAddress1 = shipperAddress1;
    }

    public String getShipperAddress2() {
        return shipperAddress2;
    }

    public void setShipperAddress2(String shipperAddress2) {
        this.shipperAddress2 = shipperAddress2;
    }

    public String getShipperCity() {
        return shipperCity;
    }

    public void setShipperCity(String shipperCity) {
        this.shipperCity = shipperCity;
    }

    public String getShipperStateCode() {
        return shipperStateCode;
    }

    public void setShipperStateCode(String shipperStateCode) {
        this.shipperStateCode = shipperStateCode;
    }

    public String getShipperPostal() {
        return shipperPostal;
    }

    public void setShipperPostal(String shipperPostal) {
        this.shipperPostal = shipperPostal;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public String getShipperContact() {
        return shipperContact;
    }

    public void setShipperContact(String shipperContact) {
        this.shipperContact = shipperContact;
    }

    public String getShipperEmail() {
        return shipperEmail;
    }

    public void setShipperEmail(String shipperEmail) {
        this.shipperEmail = shipperEmail;
    }

    public String getBilltoAccountCode() {
        return billtoAccountCode;
    }

    public void setBilltoAccountCode(String billtoAccountCode) {
        this.billtoAccountCode = billtoAccountCode;
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

    public String getConsigneeStateCode() {
        return consigneeStateCode;
    }

    public void setConsigneeStateCode(String consigneeStateCode) {
        this.consigneeStateCode = consigneeStateCode;
    }

    public String getConsigneePostal() {
        return consigneePostal;
    }

    public void setConsigneePostal(String consigneePostal) {
        this.consigneePostal = consigneePostal;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getConsigneeContact() {
        return consigneeContact;
    }

    public void setConsigneeContact(String consigneeContact) {
        this.consigneeContact = consigneeContact;
    }

    public String getConsigneeEmailBOL() {
        return consigneeEmailBOL;
    }

    public void setConsigneeEmailBOL(String consigneeEmailBOL) {
        this.consigneeEmailBOL = consigneeEmailBOL;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getThirdpartyName() {
        return thirdpartyName;
    }

    public void setThirdpartyName(String thirdpartyName) {
        this.thirdpartyName = thirdpartyName;
    }

    public String getThirdpartyAddress1() {
        return thirdpartyAddress1;
    }

    public void setThirdpartyAddress1(String thirdpartyAddress1) {
        this.thirdpartyAddress1 = thirdpartyAddress1;
    }

    public String getThirdpartyAddress2() {
        return thirdpartyAddress2;
    }

    public void setThirdpartyAddress2(String thirdpartyAddress2) {
        this.thirdpartyAddress2 = thirdpartyAddress2;
    }

    public String getThirdpartyCity() {
        return thirdpartyCity;
    }

    public void setThirdpartyCity(String thirdpartyCity) {
        this.thirdpartyCity = thirdpartyCity;
    }

    public String getThirdpartyStateCode() {
        return thirdpartyStateCode;
    }

    public void setThirdpartyStateCode(String thirdpartyStateCode) {
        this.thirdpartyStateCode = thirdpartyStateCode;
    }

    public String getThirdpartyPostal() {
        return thirdpartyPostal;
    }

    public void setThirdpartyPostal(String thirdpartyPostal) {
        this.thirdpartyPostal = thirdpartyPostal;
    }

    public String getThirdpartyPhone() {
        return thirdpartyPhone;
    }

    public void setThirdpartyPhone(String thirdpartyPhone) {
        this.thirdpartyPhone = thirdpartyPhone;
    }

    public String getThirdpartyContact() {
        return thirdpartyContact;
    }

    public void setThirdpartyContact(String thirdpartyContact) {
        this.thirdpartyContact = thirdpartyContact;
    }

    public String getThirdpartyEmail() {
        return thirdpartyEmail;
    }

    public void setThirdpartyEmail(String thirdpartyEmail) {
        this.thirdpartyEmail = thirdpartyEmail;
    }

    public String getServiceTypeCode() {
        return serviceTypeCode;
    }

    public void setServiceTypeCode(String serviceTypeCode) {
        this.serviceTypeCode = serviceTypeCode;
    }

    public int getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(int pieceCount) {
        this.pieceCount = pieceCount;
    }

    public double getTotalWeightLbs() {
        return totalWeightLbs;
    }

    public void setTotalWeightLbs(double totalWeightLbs) {
        this.totalWeightLbs = totalWeightLbs;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getFreightDescription() {
        return freightDescription;
    }

    public void setFreightDescription(String freightDescription) {
        this.freightDescription = freightDescription;
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
    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public double getCheckReturnAmount() {
        return checkReturnAmount;
    }

    public void setCheckReturnAmount(double checkReturnAmount) {
        this.checkReturnAmount = checkReturnAmount;
    }

    public double getTotalWeightKgs() {
        return totalWeightKgs;
    }

    public void setTotalWeightKgs(double totalWeightKgs) {
        this.totalWeightKgs = totalWeightKgs;
    }

    public double getCodAmount() {
        return codAmount;
    }

    public void setCodAmount(double codAmount) {
        this.codAmount = codAmount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
