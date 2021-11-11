package com.fbs.common.exception;

public class IllegalInputException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public IllegalInputException() {
		super();
	}
	
	public IllegalInputException(String msg) {
		super(msg);
	}

	public IllegalInputException(Exception e) {
		super(e);
	}
	
	public IllegalInputException(String msg, Exception e) {
		super(msg, e);
	}
}
