package com.example.inadn.demo.model.impl.consts;

public enum VehicleType {
	
	CAR ("car"),
	MOTORCYCLE ("motorcycle");
	
	private final String type;
	
	private VehicleType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
