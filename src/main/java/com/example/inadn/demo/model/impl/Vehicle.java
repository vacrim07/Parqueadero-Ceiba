package com.example.inadn.demo.model.impl;

import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(@Type(value = Motorcycle.class, name = "motorcycle"))
public abstract class Vehicle {
	
	private VehicleTypeEnum type;
	
	private String badge;

	public Vehicle() {
		super();
	}

	public Vehicle(VehicleTypeEnum type, String badge) {
		super();
		this.type = type;
		this.badge = badge;
	}

	public VehicleTypeEnum getType() {
		return type;
	}

	public void setType(VehicleTypeEnum type) {
		this.type = type;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

}
