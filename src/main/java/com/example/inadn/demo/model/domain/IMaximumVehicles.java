package com.example.inadn.demo.model.domain;

public interface IMaximumVehicles {
	
	Integer getMaximumVehicles(String vehicleType);
	
	boolean isParkingAvailable(Integer position, Integer total);

}
