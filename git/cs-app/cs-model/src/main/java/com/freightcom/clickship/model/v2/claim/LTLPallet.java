package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.Box;

import lombok.Data;

@Data
public class LTLPallet {
	@JsonProperty("measurements")
	private Box measurements = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("freight_class")
	private String freightClass = null;

	@JsonProperty("nmfc")
	private String nmfc = null;

	@JsonProperty("contents_type")
	private String contentsType = null;

	@JsonProperty("num_pieces")
	private Integer numPieces = null;
	
	@JsonProperty("num_pallets")
	private Integer numPallets = null;
}
