package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedResource extends LightSpeedBaseEntity {

	@JsonProperty("url")
	private String url;

	@JsonProperty("link")
	private String link;

	@JsonProperty("embedded")
	private List<EmbeddedResource> embeddedResources;

	public String getUrl() {
		return url;
	}

	public LightSpeedResource setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getLink() {
		return link;
	}

	public LightSpeedResource setLink(String link) {
		this.link = link;
		return this;
	}

	public List<EmbeddedResource> getEmbeddedResources() {
		return embeddedResources;
	}

	public LightSpeedResource setEmbeddedResources(List<EmbeddedResource> embeddedResources) {
		this.embeddedResources = embeddedResources;
		return this;
	}
}
