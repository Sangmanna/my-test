package com.freightcom.clickship.model.customer.userrole;

public enum ProductPermissions {
	
	PRODUCTS("products"),
	SHOW_PRODUCTS_PAGE("showProductsPage");
	
    private String value;

	ProductPermissions (String value) {
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
