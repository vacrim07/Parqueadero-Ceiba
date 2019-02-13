package com.example.inadn.demo.model.impl;

import java.io.Serializable;

import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("car")
public class Car extends Vehicle implements Serializable{
	
	private static final long serialVersionUID= 1L;

	public Car() {
		super();
	}

	public Car(VehicleTypeEnum name, String badge) {
		super(name, badge);
	}
	
	

}
