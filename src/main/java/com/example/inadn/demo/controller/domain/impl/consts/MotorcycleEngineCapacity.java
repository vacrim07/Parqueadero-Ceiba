package com.example.inadn.demo.controller.domain.impl.consts;

public enum MotorcycleEngineCapacity {
	
	TOP (500);
	
	private final int value;

	private MotorcycleEngineCapacity(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
