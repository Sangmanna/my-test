package com.freightcom.clickship.model.marketplace.etsy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyOrder extends Receipt {

	private static final long serialVersionUID = -593922627417951549L;

	@JsonIgnore
    private List<EtsyOrderDetail> etsyOrderDetails;

    public List<EtsyOrderDetail> getEtsyOrderDetails() {
        return etsyOrderDetails;
    }

    public void setEtsyOrderDetails(List<EtsyOrderDetail> etsyOrderDetails) {
        this.etsyOrderDetails = etsyOrderDetails;
    }
}
