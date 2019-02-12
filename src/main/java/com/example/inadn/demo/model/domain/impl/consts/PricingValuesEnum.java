package com.example.inadn.demo.model.domain.impl.consts;

public enum PricingValuesEnum {
	
	HOUR_CAR (1000),
	HOUR_MOTORCYCLE (500),
	DAY_CAR (8000),
	DAY_MOTORCYCLE (4000),
	EXTRA_MOTORCYCLE (2000);
	
	private final Integer amount;

	private PricingValuesEnum(Integer amount) {
		this.amount = amount;
	}

	public Integer getAmount() {
		return amount;
	}

}
