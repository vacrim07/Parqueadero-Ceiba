package com.example.inadn.demo.model.domain.impl.consts;

public enum DayHoursParking {
	
	PARKING_DAY_START (9);
	
	private final Integer hours;

	private DayHoursParking(Integer hours) {
		this.hours = hours;
	}

	public Integer getHours() {
		return hours;
	}

}
