package com.example.inadn.demo.model.impl;

import com.example.inadn.demo.model.impl.consts.VehicleType;

public class Vehicle {
	
	private Integer id;
	
	private VehicleType type;
	
	private String badge;

	public Vehicle() {
		super();
	}

	public Vehicle(Integer id, VehicleType type, String badge) {
		super();
		this.id = id;
		this.type = type;
		this.badge = badge;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

}
