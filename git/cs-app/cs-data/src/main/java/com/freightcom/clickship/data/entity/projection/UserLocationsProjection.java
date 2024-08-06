package com.freightcom.clickship.data.entity.projection;

public interface UserLocationsProjection {
	
	public static final String SELECT = "SELECT ca.id AS addressId, ca.address_name AS addressName, CONCAT_WS(' ', ca.address1, ca.city, ca.province_state, ca.country, ca.postal_code) as address, ul.id as locationId";

	public String getAddress();
	
	public String getAddressId();
	
	public String getLocationId();
	
	public String getAddressName();

}
