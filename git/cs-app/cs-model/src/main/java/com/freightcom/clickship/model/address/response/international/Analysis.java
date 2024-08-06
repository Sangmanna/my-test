
package com.freightcom.clickship.model.address.response.international;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freightcom.clickship.model.CommonDTO;

import java.io.Serializable;

@JsonPropertyOrder({
    "verification_status",
    "address_precision",
    "max_address_precision",
    "changes"
})
public class Analysis extends CommonDTO implements Serializable
{

    @JsonProperty("verification_status")
    private String verificationStatus;
    @JsonProperty("address_precision")
    private String addressPrecision;
    @JsonProperty("max_address_precision")
    private String maxAddressPrecision;
    @JsonProperty("changes")
    private AddressValidationResponse changes;
    private final static long serialVersionUID = -4911932426411722914L;

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public Analysis setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
        return this;
    }

    public String getAddressPrecision() {
        return addressPrecision;
    }

    public Analysis setAddressPrecision(String addressPrecision) {
        this.addressPrecision = addressPrecision;
        return this;
    }

    public String getMaxAddressPrecision() {
        return maxAddressPrecision;
    }

    public Analysis setMaxAddressPrecision(String maxAddressPrecision) {
        this.maxAddressPrecision = maxAddressPrecision;
        return this;
    }

    public AddressValidationResponse getChanges() {
        return changes;
    }

    public Analysis setChanges(AddressValidationResponse changes) {
        this.changes = changes;
        return this;
    }

}
