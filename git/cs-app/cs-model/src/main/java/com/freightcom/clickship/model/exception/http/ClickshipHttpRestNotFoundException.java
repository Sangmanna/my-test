package com.freightcom.clickship.model.exception.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpStatusCodeException;

public class ClickshipHttpRestNotFoundException extends HttpStatusCodeException  {

	private static final long serialVersionUID = 7607868180884875329L;

	public ClickshipHttpRestNotFoundException(HttpStatus statusCode) {
		super(statusCode);
	}

	public ClickshipHttpRestNotFoundException(HttpStatusCode statusCode, String statusText, HttpHeaders responseHeaders, byte[] responseBody) {
		super(statusCode, statusText, responseHeaders, responseBody, null);
	}

}
