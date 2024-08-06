package com.freightcom.clickship.model.customer.userrole;

public enum InvoicePermissions {
	
	INVOICE("invoice"),
	SUBSCRIPTION("subscription"),
	SHOW_INVOICE_PAGE("showInvoicePage");
	
    private String value;

	InvoicePermissions (String value) {
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
