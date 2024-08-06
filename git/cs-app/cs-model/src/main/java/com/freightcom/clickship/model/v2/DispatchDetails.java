package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LTL dispatch details, required if dispatch service utilized.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DispatchDetails {
	@JsonProperty("date")
	private Date date = null;

	@JsonProperty("ready_at")
	private TimeOfDay readyAt = null;

	@JsonProperty("ready_until")
	private TimeOfDay readyUntil = null;

	public DispatchDetails date(Date date) {
		this.date = date;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DispatchDetails readyAt(TimeOfDay readyAt) {
		this.readyAt = readyAt;
		return this;
	}

	public TimeOfDay getReadyAt() {
		return readyAt;
	}

	public void setReadyAt(TimeOfDay readyAt) {
		this.readyAt = readyAt;
	}

	public DispatchDetails readyUntil(TimeOfDay readyUntil) {
		this.readyUntil = readyUntil;
		return this;
	}

	public TimeOfDay getReadyUntil() {
		return readyUntil;
	}

	public void setReadyUntil(TimeOfDay readyUntil) {
		this.readyUntil = readyUntil;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DispatchDetails dispatchDetails = (DispatchDetails) o;
		return Objects.equals(this.date, dispatchDetails.date) && Objects.equals(this.readyAt, dispatchDetails.readyAt)
				&& Objects.equals(this.readyUntil, dispatchDetails.readyUntil);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, readyAt, readyUntil);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DispatchDetails {\n");

		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    readyAt: ").append(toIndentedString(readyAt)).append("\n");
		sb.append("    readyUntil: ").append(toIndentedString(readyUntil)).append("\n");
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
