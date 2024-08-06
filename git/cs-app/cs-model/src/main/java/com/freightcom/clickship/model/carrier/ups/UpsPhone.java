package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsPhone implements Serializable {
	
	private static final long serialVersionUID = -2213899066312806411L;

	@JsonProperty("Extension")
    private String extension;
    
    @JsonProperty("Number")
    private String number;
    
    public String getExtension() {
        return extension;
    }

    public UpsPhone setExtension(String extension) {
        this.extension = extension;
        return this;
    }
    
    public String getNumber() {
        return number;
    }

    public UpsPhone setNumber(String number) {
        this.number = number;
        return this;
    }

}
