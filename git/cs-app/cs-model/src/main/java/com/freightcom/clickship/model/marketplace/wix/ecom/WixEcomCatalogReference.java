package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomCatalogReference {

	@JsonProperty("catalogItemId")
	private String catalogItemId;

	@JsonProperty("options")
	private Options options;

	public String getCatalogItemId() {
		return catalogItemId;
	}

	public void setCatalogItemId(String catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Options {

		@JsonProperty("variantId")
		private String variantId;

		public String getVariantId() {
			return variantId;
		}

		public void setVariantId(String variantId) {
			this.variantId = variantId;
		}
	}

}
