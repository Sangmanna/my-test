package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixMainMedia {

	@JsonProperty("id")
	private String id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("mediaType")
	private String mediaType;

	@JsonProperty("image")
	private WixThumbnail image;

	@JsonProperty("thumbnail")
	private WixThumbnail thumbnail;

	public String getId() {
		return id;
	}

	public WixMainMedia setId(String id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public WixMainMedia setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getMediaType() {
		return mediaType;
	}

	public WixMainMedia setMediaType(String mediaType) {
		this.mediaType = mediaType;
		return this;
	}

	public WixThumbnail getImage() {
		return image;
	}

	public WixMainMedia setImage(WixThumbnail image) {
		this.image = image;
		return this;
	}

	public WixThumbnail getThumbnail() {
		return thumbnail;
	}

	public WixMainMedia setThumbnail(WixThumbnail thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

}
