package com.freightcom.clickship.model.enums;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;

public enum SignaturePreference {
	
	SIGNATURE_REQUIRED("Signature Required", "SR"), 
	NO_SIGNATURE_REQUIRED("No Signature Required", "NSR"),
	ADULT_SIGNATURE_REQUIRED("Adult Signature Required", "ASR");	


	private final String preferences;
	private final String value;

	SignaturePreference(String preferences,String value) {
		this.preferences = preferences;
		this.value = value;
	}
	
	public String getPreferences() {
        return preferences;
    }
    public String getValue() {
        return value;
    }

	public static String[] getSignaturePreference() {
		List<SignaturePreference> list = EnumUtils.getEnumList(SignaturePreference.class);
		return list.stream().map(SignaturePreference::toString).toArray(String[]::new);
	}
}
