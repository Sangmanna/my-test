package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaPublicKey_ {

    @JsonProperty("keys")
    private List<VendastaPublicKey> vendastaPublicKey;

    public List<VendastaPublicKey> getVendastaPublicKey() {
        return vendastaPublicKey;
    }

    public void setVendastaPublicKey(List<VendastaPublicKey> vendastaPublicKey) {
        this.vendastaPublicKey = vendastaPublicKey;
    }
}
