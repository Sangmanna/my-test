package com.freightcom.clickship.model.v2;

import java.util.Calendar;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Date {
	@JsonProperty("year")
	private Integer year = null;

	@JsonProperty("month")
	private Integer month = null;

	@JsonProperty("day")
	private Integer day = null;

	public Date() {		
		this(Calendar.getInstance());
	}
	
	public Date(Calendar calendar) {
		this.setYear(calendar.get(Calendar.YEAR));
		this.setMonth(calendar.get(Calendar.MONTH) + 1);
		this.setDay(calendar.get(Calendar.DAY_OF_MONTH));
	}

	public Date year(Integer year) {
		this.year = year;
		return this;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date month(Integer month) {
		this.month = month;
		return this;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Date day(Integer day) {
		this.day = day;
		return this;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Date date = (Date) o;
		return Objects.equals(this.year, date.year) && Objects.equals(this.month, date.month)
				&& Objects.equals(this.day, date.day);
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, month, day);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Date {\n");

		sb.append("    year: ").append(toIndentedString(year)).append("\n");
		sb.append("    month: ").append(toIndentedString(month)).append("\n");
		sb.append("    day: ").append(toIndentedString(day)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
