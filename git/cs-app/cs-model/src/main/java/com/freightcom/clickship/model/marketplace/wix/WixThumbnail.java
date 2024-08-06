package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixThumbnail {

	@JsonProperty("url")
	private String url;

	@JsonProperty("width")
	private Integer width;

	@JsonProperty("height")
	private Integer height;

	public String getUrl() {
		return url;
	}

	public WixThumbnail setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getWidth() {
		return width;
	}

	public WixThumbnail setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getHeight() {
		return height;
	}

	public WixThumbnail setHeight(Integer height) {
		this.height = height;
		return this;
	}

}
