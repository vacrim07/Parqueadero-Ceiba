package com.example.inadn.demo.controller.buissinesRules.impl;

import com.example.inadn.demo.model.impl.consts.VehicleType;

public class AllowedVehicles {
	
	public boolean isVehicleAllowed(String vehicleType) {
		if (vehicleType.equalsIgnoreCase(VehicleType.CAR.getType()) ||
				vehicleType.equalsIgnoreCase(VehicleType.MOTORCYCLE.getType())) {
			return true;
		}else {
			return false;
		}
	}
}
