package com.freightcom.clickship.model.customer.userrole;

public enum SettingsPermissions {
	
	CLAIMS("claims"),
	LOCATIONS("showLocations"),
	ADDRESS_BOOK("addressBook"),
	SHIPPING_RULES("shippingRules"),
	PRINTER_SETUP("showPrinterSetup"),
	CUSTOM_BRANDING("customBranding"),
	SMART_PACKAGING("smartPackaging"),
	SHOW_SETTINGS_PAGE("showSettings"),
	CUSTOMER_PREFERENCES("showPreferences"),
	EDIT_PRINTING_PREFERENCE("editPrintingPreference");
	
    private String value;

	SettingsPermissions (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

	@Override
	public String toString() {
		return value;
	}

}
