package com.freightcom.clickship.model.marketplace.amazon.v2;

public enum AmazonV2ReportEnum {

	GET_PRODUCTS("GET_MERCHANT_LISTINGS_ALL_DATA", "P1D"),
	GET_CONFIRMED_ORDERS_DATA("GET_FLAT_FILE_ACTIONABLE_ORDER_DATA_SHIPPING", "PT15M");

	private String reportType;

	private String scheduleTime;

	AmazonV2ReportEnum(String type, String time) {
		this.reportType = type;
		this.scheduleTime = time;
	}

	public String getReportType() {
		return reportType;
	}
	
	public String getScheduleTime() {
		return scheduleTime;
	}
}
