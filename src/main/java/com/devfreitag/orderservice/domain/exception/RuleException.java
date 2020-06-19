package com.devfreitag.orderservice.domain.exception;

public class RuleException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RuleException(String message) {
		super(message);
	}

}
