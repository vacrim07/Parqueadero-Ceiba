package com.example.inadn.demo.controller.domain;

public interface IMaximumVehicles {
	
	Integer getMaximumVehicles(String vehicleType);
	
	boolean isParkingAvailable(Integer position, Integer total);

}
