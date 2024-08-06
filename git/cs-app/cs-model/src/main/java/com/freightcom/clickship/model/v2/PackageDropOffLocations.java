package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackageDropOffLocations {

	@JsonProperty("depots")
	private List<Depots> depots;

	public List<Depots> getDepots() {
		return depots;
	}

	public PackageDropOffLocations setDepots(List<Depots> depots) {
		this.depots = depots;
		return this;
	}
		
}
