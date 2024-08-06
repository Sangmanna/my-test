package com.freightcom.clickship.model.customer.userrole;

public enum MarketplacePermissions {
	
	MARKETPLACES("marketplaces"),
	ADD_MARKETPLACE("addMarketplace"),
	SHOW_MARKETPLACE_PAGE("showMarketplacePage");
	
    private String value;

	MarketplacePermissions (String value) {
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
