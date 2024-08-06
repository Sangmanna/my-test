package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChequeProperties {

    private Contact contact;

    @Data
	@EqualsAndHashCode(callSuper = false)
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Contact {
        private String name;
        private Address address;
        private PhoneNumber phone_number;
    }

    @Data
	@EqualsAndHashCode(callSuper = false)
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Address {
        private String address_line1;
        private String address_line2;
        private String unit_number;
        private String city;
        private String region;
        private String country;
        private String postal_code;
        private boolean validated;
    }

    @Data
	@EqualsAndHashCode(callSuper = false)
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class PhoneNumber {
        private String number;
        private String extension;
    }
}