package com.example.inadn.demo.model.impl;

import java.io.Serializable;

import javax.persistence.Entity;

import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("car")
@Entity
public class Car extends Vehicle implements Serializable{
	
	private static final long serialVersionUID= 1L;

	public Car() {
	}

	public Car(VehicleTypeEnum name, String badge) {
		super(name, badge);
	}
	
	

}
