package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedImage extends LightSpeedBaseEntity {

	@JsonProperty("title")
	private String title;

	@JsonProperty("src")
	private String src;

	@JsonProperty("thumb")
	private String thumb;

	@JsonProperty("extension")
	private String extension;

	public String getTitle() {
		return title;
	}

	public LightSpeedImage setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getSrc() {
		return src;
	}

	public LightSpeedImage setSrc(String src) {
		this.src = src;
		return this;
	}

	public String getThumb() {
		return thumb;
	}

	public LightSpeedImage setThumb(String thumb) {
		this.thumb = thumb;
		return this;
	}

	public String getExtension() {
		return extension;
	}

	public LightSpeedImage setExtension(String extension) {
		this.extension = extension;
		return this;
	}

}
