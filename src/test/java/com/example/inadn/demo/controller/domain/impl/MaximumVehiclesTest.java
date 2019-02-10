package com.example.inadn.demo.controller.domain.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.domain.impl.MaximumVehicles;
import com.example.inadn.demo.controller.domain.impl.consts.MaximumVehiclesPerType;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class MaximumVehiclesTest {
	
	@Test
	public void getMaximumVehicles() {
		
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		
		MaximumVehicles maximumVehicles = new MaximumVehicles();
		int case1 = maximumVehicles.getMaximumVehicles(car);
		int case2 = maximumVehicles.getMaximumVehicles(motorcycle);
		
		assertEquals(20,case1);
		assertEquals(10,case2);
	}
	
	@Test
	public void isParkingAvailable() {
		
		Integer positionCar = 21;
		Integer positionMotorcycle = 11;
		
		MaximumVehicles maximumVehicles = new MaximumVehicles();
		boolean case1 = maximumVehicles.isParkingAvailable(positionCar, MaximumVehiclesPerType.CAR.getMaximum());
		boolean case2 = maximumVehicles.isParkingAvailable(positionMotorcycle, MaximumVehiclesPerType.MOTORCYCLE.getMaximum());
		boolean case3 = maximumVehicles.isParkingAvailable(positionCar-1, MaximumVehiclesPerType.CAR.getMaximum());
		boolean case4 = maximumVehicles.isParkingAvailable(positionMotorcycle-1, MaximumVehiclesPerType.MOTORCYCLE.getMaximum());
		
		assertEquals(false,case1);
		assertEquals(false,case2);
		assertEquals(true,case3);
		assertEquals(true,case4);
	}

}
