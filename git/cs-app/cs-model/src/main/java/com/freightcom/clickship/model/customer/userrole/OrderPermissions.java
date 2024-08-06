package com.freightcom.clickship.model.customer.userrole;

public enum OrderPermissions {
	
	TAGS("tags"),
	US_ORDERS("usOrders"),
	CSV_ORDERS("csvOrders"),
	PICK_LIST("orderPickList"),
	BULK_SHIPPING("bulkShipping"),
	EXPORT_ORDERS("exportOrders"),
	CANADA_ORDERS("canadaOrders"),
	ARCHIVE_ORDERS("archiveOrders"),
	BACTH_ACTIONS("orderBatchActions"),
	SHOW_ORDERS_PAGE("showOrdersPage"),
	MARKETPLACE_ORDERS("marketplaceOrders"),
	INTERNATIONAL_ORDERS("internationalOrders");
	
    private String value;

	OrderPermissions (String value) {
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
