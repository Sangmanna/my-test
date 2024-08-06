package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverbProductLinks {
	@JsonProperty("large_crop")
	private ReverbProductImage largeCrop;
	@JsonProperty("small_crop")
	private ReverbProductImage smallCrop;
	@JsonProperty("full")
	private ReverbProductImage full;
	@JsonProperty("thumbnail")
	private ReverbProductImage thumbnail;
	public ReverbProductImage getLargeCrop() {
		return largeCrop;
	}
	public void setLargeCrop(ReverbProductImage largeCrop) {
		this.largeCrop = largeCrop;
	}
	public ReverbProductImage getSmallCrop() {
		return smallCrop;
	}
	public void setSmallCrop(ReverbProductImage smallCrop) {
		this.smallCrop = smallCrop;
	}
	public ReverbProductImage getFull() {
		return full;
	}
	public void setFull(ReverbProductImage full) {
		this.full = full;
	}
	public ReverbProductImage getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(ReverbProductImage thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}
