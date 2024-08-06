package com.freightcom.clickship.service.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DateUtil {
	
	private DateUtil() {
		super();
	}

	private static Logger logger = LogManager.getLogger(DateUtil.class);
	
	private static String yyyy_mm_dd = "yyyy-MM-dd";
	
	public static String getToday() {
		return getFormattedDate(yyyy_mm_dd, Calendar.getInstance());
	}
	
	public static String getYesterday() {
		return getDateInDiff(-1);
	}
	
	public static String getDateInDiff(int diff) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, diff);
		
		return getFormattedDate(yyyy_mm_dd, cal);
	}
	
	public static String getFormattedDate(String format, Calendar cal) {
		return getFormattedDate(format, cal.getTime());
	}
	
	public static String getFormattedDate(SimpleDateFormat format, Calendar cal) {
		return getFormattedDate(format, cal.getTime());
	}
	
	public static String getFormattedDate(String format, Date date) {
		return getFormattedDate(new SimpleDateFormat(format), date);
	}

	public static String getFormattedDate(SimpleDateFormat format, Date date) {
		return format.format(date);
	}
	
	public static ZonedDateTime getUtcDate(Date date) {
		return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));
	}
	
	public static int getBusinessDaysUntilDate(Instant toDate) {
		Date endDate = Date.from(toDate);
		Date startDate = new Date();
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return workDays;
	}
	
	public static Date getDate(String str, String format) {
		Date returnDate = null;
		try {
			if (StringUtils.isNotBlank(str)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				returnDate = dateFormat.parse(str);
			}
		} catch (Exception e) {
			logger.error("str {}, format {}", str, format, e);
		}
		return returnDate;
	}
	
	public static Date getDaysAgoDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, - days);
		return cal.getTime();
	}
	
}

