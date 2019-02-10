package com.example.inadn.demo.controller.buissinesRules.impl;

import com.example.inadn.demo.controller.buissinesRules.impl.consts.MaximumVehiclesPerType;
import com.example.inadn.demo.model.impl.consts.VehicleType;

public class MaximumVehicles {
	
	public Integer getMaximumVehicles(String vehicleType) {
		return vehicleType.equalsIgnoreCase(VehicleType.CAR.getType()) ?
				MaximumVehiclesPerType.CAR.getMaximum() : MaximumVehiclesPerType.MOTORCYCLE.getMaximum();
	}
	
	public boolean isParkingAvailable(Integer position, Integer total) {
		return position <= total ? true : false;
	}

}
