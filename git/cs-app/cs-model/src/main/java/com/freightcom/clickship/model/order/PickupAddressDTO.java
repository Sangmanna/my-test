package com.freightcom.clickship.model.order;

import java.io.Serializable;

public class PickupAddressDTO implements Serializable {
	private static final long serialVersionUID = -1703093792593546910L;
	
	private String addressLine1;
    private String addressLine2;
    private String unitNumber;
    private String buzzerCode;
    private String city;
    private String region;
    private String country;
    private String postalCode;
    private boolean validated;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getBuzzerCode() {
        return buzzerCode;
    }

    public void setBuzzerCode(String buzzerCode) {
        this.buzzerCode = buzzerCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

}