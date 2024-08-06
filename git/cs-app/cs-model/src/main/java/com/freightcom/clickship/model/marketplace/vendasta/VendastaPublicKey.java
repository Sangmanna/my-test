package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaPublicKey {

    @JsonProperty("use")
    private String use;

    @JsonProperty("kty")
    private String kty;

    @JsonProperty("kid")
    private String kid;

    @JsonProperty("alg")
    private String alg;

    @JsonProperty("n")
    private String modulus;

    @JsonProperty("e")
    private String exponent;

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getKty() {
        return kty;
    }

    public void setKty(String kty) {
        this.kty = kty;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }
}
