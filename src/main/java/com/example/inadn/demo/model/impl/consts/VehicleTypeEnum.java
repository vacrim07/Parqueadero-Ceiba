package com.example.inadn.demo.model.impl.consts;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VehicleTypeEnum {
	
	CAR ("car"),
	MOTORCYCLE ("motorcycle");
	
	private final String type;
	
	private VehicleTypeEnum(String type) {
		this.type = type;
	}

	@JsonValue
	public String getType() {
		return type;
	}

}
