package com.example.inadn.demo.model.impl;

public class motorcycle extends vehicle{
	
	private int engineCapacity;

	public motorcycle() {
		super();
	}

	public motorcycle(int engineCapacity) {
		super();
		this.engineCapacity = engineCapacity;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

}
