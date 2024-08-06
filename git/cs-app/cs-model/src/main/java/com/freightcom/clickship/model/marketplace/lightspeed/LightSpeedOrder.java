package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedOrder extends LightSpeedBaseEntity{

    @JsonProperty("number")
    private String number;

    @JsonProperty("status")
    private String status;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("isCompany")
    private boolean isCompany;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("addressBillingName")
    private String addressBillingName;

    @JsonProperty("addressBillingStreet")
    private String addressBillingStreet;

    @JsonProperty("addressBillingStreet2")
    private String addressBillingStreet2;

    @JsonProperty("addressBillingZipcode")
    private String addressBillingZipcode;

    @JsonProperty("addressBillingCity")
    private String addressBillingCity;

    @JsonProperty("addressBillingCountry")
    private LightSpeedCountry addressBillingCountry;

    @JsonProperty("addressBillingRegionData")
    private JsonNode addressBillingRegionData;

    @JsonProperty("addressShippingName")
    private String addressShippingName;

    @JsonProperty("addressShippingStreet")
    private String addressShippingStreet;

    @JsonProperty("addressShippingZipcode")
    private String addressShippingZipcode;

    @JsonProperty("addressShippingCity")
    private String addressShippingCity;

    @JsonProperty("addressShippingCountry")
    private LightSpeedCountry addressShippingCountry;

    @JsonProperty("addressShippingRegionData")
    private JsonNode addressShippingRegionData;

    @JsonProperty("paymentStatus")
    private String paymentStatus;

    @JsonProperty("paymentTaxRates")
    private List<LightSpeedTaxRates> paymentTaxRates;

    @JsonProperty("shipmentId")
    private String shipmentId;

    @JsonProperty("shipmentStatus")
    private String shipmentStatus;

    @JsonProperty("shipmentTaxRates")
    private List<LightSpeedTaxRates> shipmentTaxRates;

    @JsonProperty("shipmentPriceExcl")
    private float shipmentPriceExcl;

    @JsonProperty("priceExcl")
    private float priceExcl;

    @JsonProperty("priceIncl")
    private float priceIncl;

    @JsonProperty("taxRates")
    private List<LightSpeedTaxRates> taxRates;

    @JsonProperty("isDiscounted")
    private boolean isDiscounted;

    @JsonProperty("discountAmount")
    private float discountAmount;

    @JsonProperty("discountType")
    private String discountType;

    @JsonProperty("discountCouponCode")
    private String discountCouponCode;

    @JsonProperty("shipmentDiscountExcl")
    private float shipmentDiscountExcl;

    @JsonProperty("products")
    private ProductResource products;

    @JsonProperty("doNotifyCancelled")
    private boolean doNotifyCancelled;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("shipmentTitle")
    private String shipmentTitle;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressBillingName() {
        return addressBillingName;
    }

    public void setAddressBillingName(String addressBillingName) {
        this.addressBillingName = addressBillingName;
    }

    public String getAddressBillingStreet() {
        return addressBillingStreet;
    }

    public void setAddressBillingStreet(String addressBillingStreet) {
        this.addressBillingStreet = addressBillingStreet;
    }

    public String getAddressBillingStreet2() {
        return addressBillingStreet2;
    }

    public void setAddressBillingStreet2(String addressBillingStreet2) {
        this.addressBillingStreet2 = addressBillingStreet2;
    }

    public String getAddressBillingZipcode() {
        return addressBillingZipcode;
    }

    public void setAddressBillingZipcode(String addressBillingZipcode) {
        this.addressBillingZipcode = addressBillingZipcode;
    }

    public String getAddressBillingCity() {
        return addressBillingCity;
    }

    public void setAddressBillingCity(String addressBillingCity) {
        this.addressBillingCity = addressBillingCity;
    }

    public LightSpeedCountry getAddressBillingCountry() {
        return addressBillingCountry;
    }

    public void setAddressBillingCountry(LightSpeedCountry addressBillingCountry) {
        this.addressBillingCountry = addressBillingCountry;
    }

    public String getAddressShippingName() {
        return addressShippingName;
    }

    public void setAddressShippingName(String addressShippingName) {
        this.addressShippingName = addressShippingName;
    }

    public String getAddressShippingStreet() {
        return addressShippingStreet;
    }

    public void setAddressShippingStreet(String addressShippingStreet) {
        this.addressShippingStreet = addressShippingStreet;
    }

    public String getAddressShippingZipcode() {
        return addressShippingZipcode;
    }

    public void setAddressShippingZipcode(String addressShippingZipcode) {
        this.addressShippingZipcode = addressShippingZipcode;
    }

    public String getAddressShippingCity() {
        return addressShippingCity;
    }

    public void setAddressShippingCity(String addressShippingCity) {
        this.addressShippingCity = addressShippingCity;
    }

    public LightSpeedCountry getAddressShippingCountry() {
        return addressShippingCountry;
    }

    public void setAddressShippingCountry(LightSpeedCountry addressShippingCountry) {
        this.addressShippingCountry = addressShippingCountry;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<LightSpeedTaxRates> getPaymentTaxRates() {
        return paymentTaxRates;
    }

    public void setPaymentTaxRates(List<LightSpeedTaxRates> paymentTaxRates) {
        this.paymentTaxRates = paymentTaxRates;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public List<LightSpeedTaxRates> getShipmentTaxRates() {
        return shipmentTaxRates;
    }

    public void setShipmentTaxRates(List<LightSpeedTaxRates> shipmentTaxRates) {
        this.shipmentTaxRates = shipmentTaxRates;
    }

    public float getShipmentPriceExcl() {
        return shipmentPriceExcl;
    }

    public void setShipmentPriceExcl(float shipmentPriceExcl) {
        this.shipmentPriceExcl = shipmentPriceExcl;
    }

    public float getPriceExcl() {
        return priceExcl;
    }

    public void setPriceExcl(float priceExcl) {
        this.priceExcl = priceExcl;
    }

    public float getPriceIncl() {
        return priceIncl;
    }

    public void setPriceIncl(float priceIncl) {
        this.priceIncl = priceIncl;
    }

    public List<LightSpeedTaxRates> getTaxRates() {
        return taxRates;
    }

    public void setTaxRates(List<LightSpeedTaxRates> taxRates) {
        this.taxRates = taxRates;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getDiscountCouponCode() {
        return discountCouponCode;
    }

    public void setDiscountCouponCode(String discountCouponCode) {
        this.discountCouponCode = discountCouponCode;
    }

    public float getShipmentDiscountExcl() {
        return shipmentDiscountExcl;
    }

    public void setShipmentDiscountExcl(float shipmentDiscountExcl) {
        this.shipmentDiscountExcl = shipmentDiscountExcl;
    }

    public ProductResource getProducts() {
        return products;
    }

    public void setProducts(ProductResource products) {
        this.products = products;
    }

    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isDoNotifyCancelled() {
        return this.doNotifyCancelled;
    }

    public void setDoNotifyCancelled(boolean doNotifyCancelled) {
        this.doNotifyCancelled = doNotifyCancelled;
    }

    public JsonNode getAddressShippingRegionData() {
        return addressShippingRegionData;
    }

    public void setAddressShippingRegionData(JsonNode addressShippingRegionData) {
        this.addressShippingRegionData = addressShippingRegionData;
    }

    public JsonNode getAddressBillingRegionData() {
        return addressBillingRegionData;
    }

    public void setAddressBillingRegionData(JsonNode addressBillingRegionData) {
        this.addressBillingRegionData = addressBillingRegionData;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShipmentTitle() {
        return shipmentTitle;
    }

    public void setShipmentTitle(String shipmentTitle) {
        this.shipmentTitle = shipmentTitle;
    }
}
