package com.example.inadn.demo.controller.domain.impl.consts;

public enum PricingValues {
	
	HOUR_CAR (1000),
	HOUR_MOTORCYCLE (500),
	DAY_CAR (8000),
	DAY_MOTORCYCLE (4000),
	EXTRA_MOTORCYCLE (2000);
	
	private final Integer amount;

	private PricingValues(Integer amount) {
		this.amount = amount;
	}

	public Integer getAmount() {
		return amount;
	}

}
