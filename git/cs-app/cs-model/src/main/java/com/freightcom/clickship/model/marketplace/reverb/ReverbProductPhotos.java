package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ReverbProductPhotos {
	@JsonProperty("_links")
	private ReverbProductLinks links;

	public ReverbProductLinks getLinks() {
		return links;
	}

	public void setLinks(ReverbProductLinks links) {
		this.links = links;
	}
	
	
}
