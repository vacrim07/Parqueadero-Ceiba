package com.example.inadn.demo.model.impl.consts;

public enum parkingState {
	
	CHECKED_IN ("checked in"),
	CHECKED_OUT ("checked out"),
	NOT_ALLOWED ("not allowed");
	
	private final String state;
	
	private parkingState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

}
