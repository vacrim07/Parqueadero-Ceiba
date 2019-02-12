package com.example.inadn.demo.model.domain.impl.consts;

public enum MotorcycleEngineCapacityEnum {
	
	TOP (500);
	
	private final int value;

	private MotorcycleEngineCapacityEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
