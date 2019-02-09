package com.example.inadn.demo.controller.buissinesRules.impl.consts;

public enum MaximumVehicles {
	CAR (20),
	MOTORCYCLE (10);
	
	private final int maximum;

	private MaximumVehicles(int maximum) {
		this.maximum = maximum;
	}

	public int getMaximum() {
		return maximum;
	}
}
