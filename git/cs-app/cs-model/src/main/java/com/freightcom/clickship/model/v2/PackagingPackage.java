package com.freightcom.clickship.model.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("PackagingPackage")
public class PackagingPackage implements OneOfShippingDetailsPackagingProperties {
	@JsonProperty("includes_return_label")
	private Boolean includesReturnLabel = null;

	@JsonProperty("has_dangerous_goods")
	private Boolean hasDangerousGoods = null;

	@JsonProperty("packages")
	private List<PackagingPackagePackages> packages = new ArrayList<PackagingPackagePackages>();

	public PackagingPackage includesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
		return this;
	}

	public Boolean isIncludesReturnLabel() {
		return includesReturnLabel;
	}

	public void setIncludesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
	}

	public PackagingPackage hasDangerousGoods(Boolean hasDangerousGoods) {
		this.hasDangerousGoods = hasDangerousGoods;
		return this;
	}

	public Boolean isHasDangerousGoods() {
		return hasDangerousGoods;
	}

	public void setHasDangerousGoods(Boolean hasDangerousGoods) {
		this.hasDangerousGoods = hasDangerousGoods;
	}

	public PackagingPackage packages(List<PackagingPackagePackages> packages) {
		this.packages = packages;
		return this;
	}

	public PackagingPackage addPackagesItem(PackagingPackagePackages packagesItem) {
		this.packages.add(packagesItem);
		return this;
	}

	public List<PackagingPackagePackages> getPackages() {
		return packages;
	}

	public void setPackages(List<PackagingPackagePackages> packages) {
		this.packages = packages;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PackagingPackage packagingPackage = (PackagingPackage) o;
		return Objects.equals(this.includesReturnLabel, packagingPackage.includesReturnLabel)
				&& Objects.equals(this.hasDangerousGoods, packagingPackage.hasDangerousGoods)
				&& Objects.equals(this.packages, packagingPackage.packages);
	}

	@Override
	public int hashCode() {
		return Objects.hash(includesReturnLabel, hasDangerousGoods, packages);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PackagingPackage {\n");

		sb.append("    includesReturnLabel: ").append(toIndentedString(includesReturnLabel)).append("\n");
		sb.append("    hasDangerousGoods: ").append(toIndentedString(hasDangerousGoods)).append("\n");
		sb.append("    packages: ").append(toIndentedString(packages)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
