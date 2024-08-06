package com.freightcom.clickship.data.entity.projection.customer.address;

public interface CustomerAddressProjection {
	
	public static final String PROJECTION_COLUMN_SELECT = " SELECT ca.id AS id, ca.addressName AS addressName, ca.businessName AS businessName, ca.provinceState as provinceState, ca.country AS country, ca.postalCode AS postalCode ";

	public String getId();

	public String getAddressName();

	public String getBusinessName();

	public String getProvinceState();

	public String getCountry();

	public String getPostalCode();
}
