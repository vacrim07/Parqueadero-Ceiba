package com.example.inadn.demo.model.impl;

import com.example.inadn.demo.model.impl.consts.vehicleType;

public class vehicle {
	
	private Integer id;
	
	private vehicleType type;
	
	private String badge;

	public vehicle() {
		super();
	}

	public vehicle(Integer id, vehicleType type, String badge) {
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

	public vehicleType getType() {
		return type;
	}

	public void setType(vehicleType type) {
		this.type = type;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

}
