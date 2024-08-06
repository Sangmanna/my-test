package com.freightcom.clickship.model.v2.claim;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.PackagingPackagePackages;

import lombok.Data;

@Data
public class PackagingPackage implements OneOfShippingDetailsPackagingProperties {
	@JsonProperty("includes_return_label")
	private Boolean includesReturnLabel = null;

	@JsonProperty("has_dangerous_goods")
	private Boolean hasDangerousGoods = null;

	@JsonProperty("packages")
	private List<PackagingPackagePackages> packages = new ArrayList<>();
}
