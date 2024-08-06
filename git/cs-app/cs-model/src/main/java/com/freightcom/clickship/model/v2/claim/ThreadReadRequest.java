package com.freightcom.clickship.model.v2.claim;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThreadReadRequest {
	private String read_at = getTimeString();
	
	private String getTimeString() {
		ZonedDateTime zdt = ZonedDateTime.now();
        ZonedDateTime utc = zdt.withZoneSameInstant(ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        return utc.format(formatter);
	}
}
