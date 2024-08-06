package com.freightcom.clickship.model.enums;

import java.util.List;
import org.apache.commons.lang3.EnumUtils;

public enum AddressBookHeader {
	
	COMPANY_NAME("Company Name"),
	CONTACT_ID("Contact ID"),
	ADDRESS1("Address 1"),
	ADDRESS2("Address 2"),
	UNIT_FLOOR("Unit/Floor"),
	POSTAL_ZIP_CODE("Postal/Zip Code"),
	CITY("City"),
	PROVINCE_STATE("Province/State"),
	COUNTRY("Country"),
	CONTACT_NAME("Contact Name"),
	PHONE_NUMBER("Phone Number"),
	EXTENSION("Extension"),
	EMAIL("Email"),
	READY_TIME_FOR_PALLET("Ready Time for Pallet"),
	CLOSE_TIME_FOR_PALLET("Close Time for Pallet"),
	LOCATION_TYPE("Location Type"),
	INSTRUCTIONS_FOR_PALLET("Instructions for Pallet"),
	RESIDENTIAL_DELIVERY("Residential Delivery"),
	SIGNATURE_PREFERENCE("Signature Preference");
	
	private final String addressHeaderName;

	AddressBookHeader(String addressHeaderName) {
		this.addressHeaderName = addressHeaderName;
	}

	@Override
	public String toString() {
		return this.addressHeaderName;
	}

	public static String[] getHeaders() {
		List<AddressBookHeader> list = EnumUtils.getEnumList(AddressBookHeader.class);
		return list.stream().map(AddressBookHeader::toString).toArray(String[]::new); 
	}


}
