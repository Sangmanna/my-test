package com.freightcom.clickship.model.exception.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpStatusCodeException;

public class ClickshipHttpRestException extends HttpStatusCodeException  {

	private static final long serialVersionUID = -5033753097386402103L;
	
	public ClickshipHttpRestException(HttpStatus statusCode) {
		super(statusCode);
	}

	public ClickshipHttpRestException(HttpStatusCode statusCode, String statusText, HttpHeaders responseHeaders, byte[] responseBody) {
		super(statusCode, statusText, responseHeaders, responseBody, null);
	}

}
