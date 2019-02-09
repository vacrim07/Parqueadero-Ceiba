package com.example.inadn.demo.model.impl.consts;

public enum ParkingState {
	
	CHECKED_IN ("checked in"),
	CHECKED_OUT ("checked out"),
	NOT_ALLOWED ("not allowed");
	
	private final String state;
	
	private ParkingState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

}
