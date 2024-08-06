package com.freightcom.clickship.model.exception;

public class CSException extends Exception implements CustomExceptionInterface {
	
	private static final long serialVersionUID = -4769145481203798480L;

	public CSException(String msg) {
		super(msg);
	}
	
	public CSException(Exception e) {
		super(e);
	}
	
	public CSException(String errorMsg, Exception e) {
		super(errorMsg, e);
	}
}
