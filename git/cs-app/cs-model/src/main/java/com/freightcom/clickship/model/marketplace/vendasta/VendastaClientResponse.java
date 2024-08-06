package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaClientResponse {

    @JsonProperty("data")
    private VendastaTokenResponse data;

    public VendastaTokenResponse getData() {
        return data;
    }

    public void setData(VendastaTokenResponse data) {
        this.data = data;
    }
}
