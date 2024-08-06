package com.freightcom.clickship.model.admin.dashboard;

import java.math.BigInteger;

public class ActiveCustomerCountsDTO {

	private Integer today;

	private Integer yesterday;

	private Integer thisWeek;

	private Integer lastWeek;

	private Integer thisMonth;

	private Integer pervMonth;

	private String percentToday;

	private String percentWeek;

	private String percentMonth;

	private String trendToday;

	private String trendWeek;

	private String trendMonth;

	private String tipWeek;

	private String tipMonth;

	private String tipToday;

	public ActiveCustomerCountsDTO(Object[] cols) {
		super();
		this.today = ((BigInteger) cols[0]).intValue();
		this.yesterday = ((BigInteger) cols[1]).intValue();
		this.thisWeek = ((BigInteger) cols[2]).intValue();
		this.lastWeek = ((BigInteger) cols[3]).intValue();
		this.thisMonth = ((BigInteger) cols[4]).intValue();
		this.pervMonth = ((BigInteger) cols[5]).intValue();
	}

	public ActiveCustomerCountsDTO() {
		super();
	}

	public Integer getToday() {
		return today;
	}

	public void setToday(Integer today) {
		this.today = today;
	}

	public Integer getYesterday() {
		return yesterday;
	}

	public void setYesterday(Integer yesterday) {
		this.yesterday = yesterday;
	}

	public Integer getThisWeek() {
		return thisWeek;
	}

	public void setThisWeek(Integer thisWeek) {
		this.thisWeek = thisWeek;
	}

	public Integer getLastWeek() {
		return lastWeek;
	}

	public void setLastWeek(Integer lastWeek) {
		this.lastWeek = lastWeek;
	}

	public Integer getThisMonth() {
		return thisMonth;
	}

	public void setThisMonth(Integer thisMonth) {
		this.thisMonth = thisMonth;
	}

	public Integer getPervMonth() {
		return pervMonth;
	}

	public void setPervMonth(Integer pervMonth) {
		this.pervMonth = pervMonth;
	}

	public String getPercentToday() {
		return percentToday;
	}

	public void setPercentToday(String percentToday) {
		this.percentToday = percentToday;
	}

	public String getPercentWeek() {
		return percentWeek;
	}

	public void setPercentWeek(String percentWeek) {
		this.percentWeek = percentWeek;
	}

	public String getPercentMonth() {
		return percentMonth;
	}

	public void setPercentMonth(String percentMonth) {
		this.percentMonth = percentMonth;
	}

	public String getTrendToday() {
		return trendToday;
	}

	public void setTrendToday(String trendToday) {
		this.trendToday = trendToday;
	}

	public String getTrendWeek() {
		return trendWeek;
	}

	public void setTrendWeek(String trendWeek) {
		this.trendWeek = trendWeek;
	}

	public String getTrendMonth() {
		return trendMonth;
	}

	public void setTrendMonth(String trendMonth) {
		this.trendMonth = trendMonth;
	}

	public String getTipWeek() {
		return tipWeek;
	}

	public void setTipWeek(String tipWeek) {
		this.tipWeek = tipWeek;
	}

	public String getTipMonth() {
		return tipMonth;
	}

	public void setTipMonth(String tipMonth) {
		this.tipMonth = tipMonth;
	}

	public String getTipToday() {
		return tipToday;
	}

	public void setTipToday(String tipToday) {
		this.tipToday = tipToday;
	}
}
