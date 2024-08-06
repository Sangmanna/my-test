
package com.freightcom.clickship.model.address.response.usa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freightcom.clickship.model.CommonDTO;

import java.io.Serializable;

@JsonPropertyOrder({
    "dpv_match_code",
    "dpv_footnotes",
    "dpv_cmra",
    "dpv_vacant",
    "active",
    "footnotes",
    "lacslink_code",
    "lacslink_indicator",
    "suitelink_match"
})
public class Analysis extends CommonDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 951756779894499076L;
	@JsonProperty("dpv_match_code")
    private String dpvMatchCode;
    @JsonProperty("dpv_footnotes")
    private String dpvFootnotes;
    @JsonProperty("dpv_cmra")
    private String dpvCmra;
    @JsonProperty("dpv_vacant")
    private String dpvVacant;
    @JsonProperty("active")
    private String active;
    @JsonProperty("footnotes")
    private String footnotes;
    @JsonProperty("lacslink_code")
    private String lacslinkCode;
    @JsonProperty("lacslink_indicator")
    private String lacslinkIndicator;
    @JsonProperty("suitelink_match")
    private String suitelinkMatch;

    public String getDpvMatchCode() {
        return dpvMatchCode;
    }

    public Analysis setDpvMatchCode(String dpvMatchCode) {
        this.dpvMatchCode = dpvMatchCode;
        return this;
    }

    public String getDpvFootnotes() {
        return dpvFootnotes;
    }

    public Analysis setDpvFootnotes(String dpvFootnotes) {
        this.dpvFootnotes = dpvFootnotes;
        return this;
    }

    public String getDpvCmra() {
        return dpvCmra;
    }

    public Analysis setDpvCmra(String dpvCmra) {
        this.dpvCmra = dpvCmra;
        return this;
    }

    public String getDpvVacant() {
        return dpvVacant;
    }

    public Analysis setDpvVacant(String dpvVacant) {
        this.dpvVacant = dpvVacant;
        return this;
    }

    public String getActive() {
        return active;
    }

    public Analysis setActive(String active) {
        this.active = active;
        return this;
    }

    public String getFootnotes() {
        return footnotes;
    }

    public Analysis setFootnotes(String footnotes) {
        this.footnotes = footnotes;
        return this;
    }
    
    public String getLacslinkIndicator() {
        return lacslinkIndicator;
    }

    public Analysis setLacslinkIndicator(String lacslinkIndicator) {
        this.lacslinkIndicator = lacslinkIndicator;
        return this;
    }
    public String getLacslinkCode() {
        return lacslinkCode;
    }

    public Analysis setLacslinkCode(String lacslinkCode) {
        this.lacslinkCode = lacslinkCode;
        return this;
    }
    
    public String getSuitelinkMatch() {
        return suitelinkMatch;
    }

    public Analysis setSuitelinkMatch(String suitelinkMatch) {
        this.suitelinkMatch = suitelinkMatch;
        return this;
    }



}
