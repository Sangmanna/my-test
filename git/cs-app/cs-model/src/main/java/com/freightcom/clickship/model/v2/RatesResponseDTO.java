package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatesResponseDTO {

	@JsonProperty("service_id")
	private String serviceId;

	@JsonProperty("valid_until")
	private ExpectedShipDateDTO validUntil;

	@JsonProperty("total")
	private CostDTO total;

	@JsonProperty("base")
	private CostDTO base;

	@JsonProperty("surcharges")
	private List<ChargesTaxesDTO> surcharges;

	@JsonProperty("taxes")
	private List<ChargesTaxesDTO> taxes;

	@JsonProperty("transit_time_days")
	private int transitTimeDays;
	
    @JsonProperty("transit_time_not_available")
    private boolean transitTimeNotAvailable;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public ExpectedShipDateDTO getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(ExpectedShipDateDTO validUntil) {
		this.validUntil = validUntil;
	}

	public CostDTO getTotal() {
		return total;
	}

	public void setTotal(CostDTO total) {
		this.total = total;
	}

	public CostDTO getBase() {
		return base;
	}

	public void setBase(CostDTO base) {
		this.base = base;
	}

	public List<ChargesTaxesDTO> getSurcharges() {
		return surcharges;
	}

	public void setSurcharges(List<ChargesTaxesDTO> surcharges) {
		this.surcharges = surcharges;
	}

	public List<ChargesTaxesDTO> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<ChargesTaxesDTO> taxes) {
		this.taxes = taxes;
	}

	public int getTransitTimeDays() {
		return transitTimeDays;
	}

	public void setTransitTimeDays(int transitTimeDays) {
		this.transitTimeDays = transitTimeDays;
	}

	public boolean isTransitTimeNotAvailable() {
		return transitTimeNotAvailable;
	}

	public void setTransitTimeNotAvailable(boolean transitTimeNotAvailable) {
		this.transitTimeNotAvailable = transitTimeNotAvailable;
	}
}
