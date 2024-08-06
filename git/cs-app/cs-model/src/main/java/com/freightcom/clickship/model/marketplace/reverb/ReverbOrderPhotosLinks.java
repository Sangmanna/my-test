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
public class ReverbOrderPhotosLinks {
	@JsonProperty("large_crop")
	private ReverbSelf largeCrop;
	@JsonProperty("small_crop")
	private ReverbSelf smallCrop;
	@JsonProperty("full")
	private ReverbSelf full;
	@JsonProperty("thumbnail")
	private ReverbSelf thumbnail;
}
