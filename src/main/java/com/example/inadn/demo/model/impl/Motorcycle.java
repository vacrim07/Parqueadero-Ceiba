package com.example.inadn.demo.model.impl;

public class Motorcycle extends Vehicle{
	
	private Integer engineCapacity;

	public Motorcycle() {
		super();
	}

	public Motorcycle(Integer engineCapacity) {
		super();
		this.engineCapacity = engineCapacity;
	}

	public Integer getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(Integer engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

}
