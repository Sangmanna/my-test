package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PackagingEnvelope implements OneOfShippingDetailsPackagingProperties {
	@JsonProperty("includes_return_label")
	private boolean includesReturnLabel;
	
	@JsonProperty("verified_documents_only")
	private boolean verifiedDocumentsOnly;
}
