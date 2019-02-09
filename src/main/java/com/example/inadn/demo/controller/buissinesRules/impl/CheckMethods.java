package com.example.inadn.demo.controller.buissinesRules.impl;

import com.example.inadn.demo.model.impl.consts.VehicleType;

public class CheckMethods {
	
	public Integer getMaximumVehicles(String vehicleType) {
		return vehicleType.equalsIgnoreCase(VehicleType.CAR.getType()) ? 20 : 10;
	}
	
	

}
