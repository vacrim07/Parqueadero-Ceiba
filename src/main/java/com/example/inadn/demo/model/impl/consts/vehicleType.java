package com.example.inadn.demo.model.impl.consts;

public enum vehicleType {
	
	CAR ("car"),
	MOTORCYCLE ("motorcycle");
	
	private final String type;
	
	private vehicleType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
