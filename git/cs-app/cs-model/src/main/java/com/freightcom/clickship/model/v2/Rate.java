package com.freightcom.clickship.model.v2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate {
	@JsonProperty("service_id")
	private String serviceId = null;

	@JsonProperty("valid_until")
	private Date validUntil = null;

	@JsonProperty("total")
	private Money total = null;

	@JsonProperty("base")
	private Money base = null;

	@JsonProperty("surcharges")
	private List<RateSurcharges> surcharges = null;

	@JsonProperty("taxes")
	private List<RateTaxes> taxes = null;

	@JsonProperty("transit_time_days")
	private Integer transitTimeDays = null;

	public Rate serviceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Rate validUntil(Date validUntil) {
		this.validUntil = validUntil;
		return this;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public Rate total(Money total) {
		this.total = total;
		return this;
	}

	public Money getTotal() {
		return total;
	}

	public void setTotal(Money total) {
		this.total = total;
	}

	public Rate base(Money base) {
		this.base = base;
		return this;
	}

	public Money getBase() {
		return base;
	}

	public void setBase(Money base) {
		this.base = base;
	}

	public Rate surcharges(List<RateSurcharges> surcharges) {
		this.surcharges = surcharges;
		return this;
	}

	public Rate addSurchargesItem(RateSurcharges surchargesItem) {
		if (this.surcharges == null) {
			this.surcharges = new ArrayList<RateSurcharges>();
		}
		this.surcharges.add(surchargesItem);
		return this;
	}

	public List<RateSurcharges> getSurcharges() {
		return surcharges;
	}

	public void setSurcharges(List<RateSurcharges> surcharges) {
		this.surcharges = surcharges;
	}

	public Rate taxes(List<RateTaxes> taxes) {
		this.taxes = taxes;
		return this;
	}

	public Rate addTaxesItem(RateTaxes taxesItem) {
		if (this.taxes == null) {
			this.taxes = new ArrayList<RateTaxes>();
		}
		this.taxes.add(taxesItem);
		return this;
	}

	public List<RateTaxes> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<RateTaxes> taxes) {
		this.taxes = taxes;
	}

	public Rate transitTimeDays(Integer transitTimeDays) {
		this.transitTimeDays = transitTimeDays;
		return this;
	}

	public Integer getTransitTimeDays() {
		return transitTimeDays;
	}

	public void setTransitTimeDays(Integer transitTimeDays) {
		this.transitTimeDays = transitTimeDays;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Rate rate = (Rate) o;
		return Objects.equals(this.serviceId, rate.serviceId) && Objects.equals(this.validUntil, rate.validUntil)
				&& Objects.equals(this.total, rate.total) && Objects.equals(this.base, rate.base)
				&& Objects.equals(this.surcharges, rate.surcharges) && Objects.equals(this.taxes, rate.taxes)
				&& Objects.equals(this.transitTimeDays, rate.transitTimeDays);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceId, validUntil, total, base, surcharges, taxes, transitTimeDays);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Rate {\n");

		sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
		sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
		sb.append("    total: ").append(toIndentedString(total)).append("\n");
		sb.append("    base: ").append(toIndentedString(base)).append("\n");
		sb.append("    surcharges: ").append(toIndentedString(surcharges)).append("\n");
		sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
		sb.append("    transitTimeDays: ").append(toIndentedString(transitTimeDays)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
