package com.example.inadn.demo.model.impl.consts;

public enum VehicleTypeEnum {
	
	CAR ("car"),
	MOTORCYCLE ("motorcycle");
	
	private final String type;
	
	private VehicleTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
