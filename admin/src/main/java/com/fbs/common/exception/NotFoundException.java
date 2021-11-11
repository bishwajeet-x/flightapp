package com.fbs.common.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String msg) {
		super(msg);
	}

	public NotFoundException(Exception e) {
		super(e);
	}
	
	public NotFoundException(String msg, Exception e) {
		super(msg, e);
	}
}
