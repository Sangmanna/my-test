package com.freightcom.clickship.model.marketplace.amazon;

public enum AmazonReportEnum {
	
	GET_PRODUCTS("_GET_MERCHANT_LISTINGS_DATA_", "_1_DAY_"),
	INACTIVE_PRODUCTS("_GET_MERCHANT_LISTINGS_INACTIVE_DATA_", "_15_DAYS_"),
	GET_CONFIRMED_ORDERS_DATA("_GET_FLAT_FILE_ACTIONABLE_ORDER_DATA_", "_15_MINUTES_");
	
	private String reportType;
	
	private String scheduleTime;

	AmazonReportEnum(String type, String time) {
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
