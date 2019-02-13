package com.example.inadn.demo.model.exception.impl;

public class CreateParkingException extends RuntimeException{
	
	private static final long serialVersionUID= 1L;

	private String message;

	public CreateParkingException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}
}
