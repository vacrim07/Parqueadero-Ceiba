package com.example.inadn.demo.controller.impl.consts;

public enum MessagesEnum {
	
	NOT_ALLOWED ("You are not allowed to park here");
	
	private final String message;

	private MessagesEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
