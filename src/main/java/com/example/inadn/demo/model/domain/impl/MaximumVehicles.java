package com.example.inadn.demo.model.domain.impl;

import com.example.inadn.demo.model.domain.IMaximumVehicles;
import com.example.inadn.demo.model.domain.impl.consts.MaximumVehiclesPerType;
import com.example.inadn.demo.model.impl.consts.VehicleType;

public class MaximumVehicles implements IMaximumVehicles{
	
	@Override
	public Integer getMaximumVehicles(String vehicleType) {
		return vehicleType.equalsIgnoreCase(VehicleType.CAR.getType()) ?
				MaximumVehiclesPerType.CAR.getMaximum() : MaximumVehiclesPerType.MOTORCYCLE.getMaximum();
	}
	
	@Override
	public boolean isParkingAvailable(Integer position, Integer total) {
		return position <= total ? true : false;
	}

}
