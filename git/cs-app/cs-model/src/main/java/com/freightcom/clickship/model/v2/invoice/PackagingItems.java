package com.freightcom.clickship.model.v2.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.Cuboid;
import com.freightcom.clickship.model.v2.Weight;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackagingItems {

	@JsonProperty("packaging_items")
	private List<PackagingItem> packagingItems;

	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PackagingItem {

		@JsonProperty("id")
		private String id;

		@JsonProperty("document_id")
		private String documentId;

		@JsonProperty("shipment_id")
		private String shipmentId;

		@JsonProperty("item_number")
		private Integer itemNumber;

		@JsonProperty("packaging_type")
		private String packagingType;

		@JsonProperty("original")
		private Original original;
		
		@JsonProperty("billed")
		private Original billed;
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Original {

		@JsonProperty("cuboid")
		private Cuboid cuboid;
		
		@JsonProperty("weight")
		private Weight weight;
	}
}
