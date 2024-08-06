package com.freightcom.clickship.model.customer.userrole;

public enum CarrierPermissions {
	
	FC_CARRIER("fcCarrier"),
	OWN_CARRIER("ownCarrier"),
	SHOW_CARRIER_PAGE("showCarriersPage");
	
    private String value;

	CarrierPermissions (String value) {
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
