package com.example.inadn.demo.model.domain.impl.consts;

public enum MaximumVehiclesPerTypeEnum {
	CAR (20),
	MOTORCYCLE (10);
	
	private final int maximum;

	private MaximumVehiclesPerTypeEnum(int maximum) {
		this.maximum = maximum;
	}

	public int getMaximum() {
		return maximum;
	}
}
