package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundTransferProperties {

	private String type;
	private ACHDetails achdetails;
    private EFTDetails eftdetails;
    private WireTransferDetails wire_transfer_details;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EFTDetails {
        private String company_name;
        private String institution_name;
        private String account_number;
        private String transit_number;
        private String institution_number;
    }
    
    @Data
    @EqualsAndHashCode(callSuper = false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WireTransferDetails {
        private String company_name;
        private Address address;
        private String beneficiary_bank_account_number;
        private String beneficiary_bank_id;
        private String beneficiary_bank_idtype;
        private String beneficiary_bank_name;
        private Address beneficiary_address;
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
        private Boolean validated;
    }
    
    @Data
    @EqualsAndHashCode(callSuper = false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class ACHDetails {
        private String company_name;
        private Address address;
        private String beneficiary_bank_account_number;
        private String beneficiary_bank_id;
        private String beneficiary_bank_idtype;
        private String beneficiary_bank_name;
        private Address beneficiary_address;
        private String routing_bank_id;
        private String routing_bank_type;
        private String routing_bank_name;
        private Address routing_address;
    }
}
