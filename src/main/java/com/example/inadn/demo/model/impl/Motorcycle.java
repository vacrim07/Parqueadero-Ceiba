package com.example.inadn.demo.model.impl;

import java.io.Serializable;

import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("motorcycle")
public class Motorcycle extends Vehicle implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
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
