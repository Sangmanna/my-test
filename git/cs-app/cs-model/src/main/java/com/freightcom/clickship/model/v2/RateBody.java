package com.freightcom.clickship.model.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RateBody {
	@JsonProperty("services")
	private List<String> services = null;

	@JsonProperty("excluded_services")
	private List<String> excludedServices = null;

	@JsonProperty("details")
	private ShippingDetails details = null;

	public RateBody services(List<String> services) {
		this.services = services;
		return this;
	}

	public RateBody addServicesItem(String servicesItem) {
		if (this.services == null) {
			this.services = new ArrayList<String>();
		}
		this.services.add(servicesItem);
		return this;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	public RateBody excludedServices(List<String> excludedServices) {
		this.excludedServices = excludedServices;
		return this;
	}

	public RateBody addExcludedServicesItem(String excludedServicesItem) {
		if (this.excludedServices == null) {
			this.excludedServices = new ArrayList<String>();
		}
		this.excludedServices.add(excludedServicesItem);
		return this;
	}

	public List<String> getExcludedServices() {
		return excludedServices;
	}

	public void setExcludedServices(List<String> excludedServices) {
		this.excludedServices = excludedServices;
	}

	public RateBody details(ShippingDetails details) {
		this.details = details;
		return this;
	}

	public ShippingDetails getDetails() {
		return details;
	}

	public void setDetails(ShippingDetails details) {
		this.details = details;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RateBody rateBody = (RateBody) o;
		return Objects.equals(this.services, rateBody.services)
				&& Objects.equals(this.excludedServices, rateBody.excludedServices)
				&& Objects.equals(this.details, rateBody.details);
	}

	@Override
	public int hashCode() {
		return Objects.hash(services, excludedServices, details);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RateBody {\n");

		sb.append("    services: ").append(toIndentedString(services)).append("\n");
		sb.append("    excludedServices: ").append(toIndentedString(excludedServices)).append("\n");
		sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
