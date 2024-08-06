package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsContact implements Serializable {

	private static final long serialVersionUID = 7213451494108372785L;

	@JsonProperty("SoldTo")
    private UpsShipper soldTo;

    public UpsShipper getSoldTo() {
        return soldTo;
    }

    public UpsContact setSoldTo(UpsShipper soldTo) {
        this.soldTo = soldTo;
        return this;
    }
}
