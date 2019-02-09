package com.example.inadn.demo.model.impl;

public class Motorcycle extends Vehicle{
	
	private int engineCapacity;

	public Motorcycle() {
		super();
	}

	public Motorcycle(int engineCapacity) {
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
