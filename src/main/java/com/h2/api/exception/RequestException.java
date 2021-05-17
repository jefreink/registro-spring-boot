package com.h2.api.exception;

public class RequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RequestException(String msg) {
		super(msg);
	}
	
	public RequestException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
