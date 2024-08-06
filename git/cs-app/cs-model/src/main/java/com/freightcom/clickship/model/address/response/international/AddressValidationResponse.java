
package com.freightcom.clickship.model.address.response.international;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freightcom.clickship.model.CommonDTO;

import java.io.Serializable;


@JsonPropertyOrder({
	"input_id",
    "address1",
    "address2",
    "address3",
    "address4",
    "address5",
    "address6",
    "address7",
    "address8",
    "address9",
    "address10",
    "address11",
    "address12",
    "components",
    "metadata",
    "analysis"
})

public class AddressValidationResponse extends CommonDTO implements Serializable
{
    @JsonProperty("input_id")
    private String inputId;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("address3")
    private String address3;
    @JsonProperty("address4")
    private String address4;
    @JsonProperty("address5")
    private String address5;
    @JsonProperty("address6")
    private String address6;
    @JsonProperty("address7")
    private String address7;
    @JsonProperty("address8")
    private String address8;
    @JsonProperty("address9")
    private String address9;
    @JsonProperty("address10")
    private String address10;
    @JsonProperty("address11")
    private String address11;
    @JsonProperty("address12")
    private String address12;
    @JsonProperty("components")
    private Components components;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("analysis")
    private Analysis analysis;
    private final static long serialVersionUID = -1273692364885403302L;

    public String getInputId() {
        return inputId;
    }

    public AddressValidationResponse setInputId(String inputId) {
        this.inputId = inputId;
        return this;
    }


    public String getAddress1() {
        return address1;
    }

    public AddressValidationResponse setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }
    
    public AddressValidationResponse setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getAddress3() {
        return address3;
    }

    public AddressValidationResponse setAddress3(String address3) {
        this.address3 = address3;
        return this;
    }

    public String getAddress4() {
        return address4;
    }

    public AddressValidationResponse setAddress4(String address4) {
        this.address4 = address4;
        return this;
    }


    public String getAddress5() {
        return address5;
    }

    public AddressValidationResponse setAddress5(String address5) {
        this.address5 = address5;
        return this;
    }


    public String getAddress6() {
        return address6;
    }

    public AddressValidationResponse setAddress6(String address6) {
        this.address6 = address6;
        return this;
    }


    public String getAddress7() {
        return address7;
    }

    public AddressValidationResponse setAddress7(String address7) {
        this.address7 = address7;
        return this;
    }


    public String getAddress8() {
        return address8;
    }

    public AddressValidationResponse setAddress8(String address8) {
        this.address8 = address8;
        return this;
    }


    public String getAddress9() {
        return address9;
    }

    public AddressValidationResponse setAddress9(String address9) {
        this.address9 = address9;
        return this;
    }


    public String getAddress10() {
        return address10;
    }

    public AddressValidationResponse setAddress10(String address10) {
        this.address10 = address10;
        return this;
    }


    public String getAddress11() {
        return address11;
    }

    public AddressValidationResponse setAddress11(String address11) {
        this.address11 = address11;
        return this;
    }


    public String getAddress12() {
        return address12;
    }

    public AddressValidationResponse setAddress12(String address12) {
        this.address12 = address12;
        return this;
    }

    public Components getComponents() {
        return components;
    }

    public AddressValidationResponse setComponents(Components components) {
        this.components = components;
        return this;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public AddressValidationResponse setMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public AddressValidationResponse setAnalysis(Analysis analysis) {
        this.analysis = analysis;
        return this;
    }


}
