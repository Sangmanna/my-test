package com.freightcom.clickship.model.exception.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpStatusCodeException;

public class TooManyRequestsRestException extends HttpStatusCodeException  {

	private static final long serialVersionUID = -7065094800708586211L;
	
	public TooManyRequestsRestException(HttpStatus statusCode) {
		super(statusCode);
	}

	public TooManyRequestsRestException(HttpStatusCode statusCode, String statusText, HttpHeaders responseHeaders, byte[] responseBody) {
		super(statusCode, statusText, responseHeaders, responseBody, null);
	}

}
