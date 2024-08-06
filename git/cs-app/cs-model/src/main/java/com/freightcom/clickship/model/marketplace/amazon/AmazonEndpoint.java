package com.freightcom.clickship.model.marketplace.amazon;

public enum AmazonEndpoint {
	
	ORDERS_VERSION("2013-09-01"),
	REPORTS_VERSION("2009-01-01"),
	PRODUCTS_VERSION("2011-10-01"),
	MARKETPLACES_VERSION("2011-07-01"),
	SUBSCRIPTIONS_VERSION("2013-07-01"),
	REPORTS_URL("https://mws.amazonservices.ca/"),
	ORDERS_SERVICE_URL("https://mws.amazonservices.ca/Orders/2013-09-01"),
	SELLERS_SERVICE_URL("https://mws.amazonservices.ca/Sellers/2011-07-01"),
	PRODUCTS_SERVICE_URL("https://mws.amazonservices.ca/Products/2011-10-01"),
	SQS_URL("https://sqs.ca-central-1.amazonaws.com/893911953248/clickshipamazon"),
	SUBSCRIPTIONS_SERVICE_URL("https://mws.amazonservices.ca/Subscriptions/2013-07-01");	
	
	private String value;

	AmazonEndpoint(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
