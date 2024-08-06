package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class RateQuote {
    @JsonProperty("QuoteNumber")
    private int quoteNumber;
    @JsonProperty("ShipDate")
    private String shipDate;
    @JsonProperty("ShipCity")
    private String shipCity;
    @JsonProperty("ShipZip")
    private String shipZip;
    @JsonProperty("ConsCity")
    private String consCity;
    @JsonProperty("ConsState")
    private String consState;
    @JsonProperty("ConsZip")
    private String consZip;
    @JsonProperty("billCustomer")
    private String BillCustomer;
    @JsonProperty("billName")
    private String BillName;
    @JsonProperty("ServTypeDescTranslated")
    private String servTypeDescTranslated;
    @JsonProperty("CompanyNameTranslated")
    private String companyNameTranslated;
    @JsonProperty("QuoteTotal")
    private double quoteTotal;
    @JsonProperty("TransitDays")
    private int transitDays;
    @JsonProperty("EstDelDate")
    private String estDelDate;
    @JsonProperty("TotalPieces")
    private int totalPieces;
    @JsonProperty("TotalWeightPounds")
    private double totalWeightPounds;
    @JsonProperty("RateQuoteCharge")
    private List<RateQuoteCharge> rateQuoteCharges;

    public int getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(int quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getConsCity() {
        return consCity;
    }

    public void setConsCity(String consCity) {
        this.consCity = consCity;
    }

    public String getConsState() {
        return consState;
    }

    public void setConsState(String consState) {
        this.consState = consState;
    }

    public String getConsZip() {
        return consZip;
    }

    public void setConsZip(String consZip) {
        this.consZip = consZip;
    }

    public String getBillCustomer() {
        return BillCustomer;
    }

    public void setBillCustomer(String billCustomer) {
        BillCustomer = billCustomer;
    }

    public String getBillName() {
        return BillName;
    }

    public void setBillName(String billName) {
        BillName = billName;
    }

    public String getServTypeDescTranslated() {
        return servTypeDescTranslated;
    }

    public void setServTypeDescTranslated(String servTypeDescTranslated) {
        this.servTypeDescTranslated = servTypeDescTranslated;
    }

    public String getCompanyNameTranslated() {
        return companyNameTranslated;
    }

    public void setCompanyNameTranslated(String companyNameTranslated) {
        this.companyNameTranslated = companyNameTranslated;
    }

    public double getQuoteTotal() {
        return quoteTotal;
    }

    public void setQuoteTotal(double quoteTotal) {
        this.quoteTotal = quoteTotal;
    }

    public int getTransitDays() {
        return transitDays;
    }

    public void setTransitDays(int transitDays) {
        this.transitDays = transitDays;
    }

    public String getEstDelDate() {
        return estDelDate;
    }

    public void setEstDelDate(String estDelDate) {
        this.estDelDate = estDelDate;
    }

    public int getTotalPieces() {
        return totalPieces;
    }

    public void setTotalPieces(int totalPieces) {
        this.totalPieces = totalPieces;
    }

    public double getTotalWeightPounds() {
        return totalWeightPounds;
    }

    public void setTotalWeightPounds(double totalWeightPounds) {
        this.totalWeightPounds = totalWeightPounds;
    }

    public List<RateQuoteCharge> getRateQuoteCharges() {
        return rateQuoteCharges;
    }

    public void setRateQuoteCharges(List<RateQuoteCharge> rateQuoteCharges) {
        this.rateQuoteCharges = rateQuoteCharges;
    }
}
