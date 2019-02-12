package com.example.inadn.demo.model.impl.consts;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ParkingStateEnum {
	
	CHECKED_IN ("checked in"),
	CHECKED_OUT ("checked out"),
	NOT_ALLOWED ("not allowed");
	
	private final String state;
	
	private ParkingStateEnum(String state) {
		this.state = state;
	}
	
	@JsonValue
	public String getState() {
		return state;
	}

}
