package com.example.inadn.demo.controller.buissinesRules.impl;

import com.example.inadn.demo.controller.buissinesRules.impl.consts.MaximumVehicles;
import com.example.inadn.demo.model.impl.consts.VehicleType;

public class CheckMethods {
	
	public Integer getMaximumVehicles(String vehicleType) {
		return vehicleType.equalsIgnoreCase(VehicleType.CAR.getType()) ?
				MaximumVehicles.CAR.getMaximum() : MaximumVehicles.MOTORCYCLE.getMaximum();
	}
	
	public boolean isParkingAvailable(Integer id, Integer total) {
		return id <= total ? true : false;
	}

}
