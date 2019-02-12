package com.example.inadn.demo.model.impl;

import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("motorcycle")
//@JsonTypeName("vehicle")
public class Motorcycle extends Vehicle{
	
	private Integer engineCapacity;

	public Motorcycle() {
		super();
	}

	public Motorcycle(VehicleTypeEnum type, String badge, Integer engineCapacity) {
		super(type, badge);
		this.engineCapacity = engineCapacity;
	}

	public Integer getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(Integer engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

}
