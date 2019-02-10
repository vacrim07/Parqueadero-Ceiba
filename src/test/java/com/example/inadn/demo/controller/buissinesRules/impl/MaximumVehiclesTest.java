package com.example.inadn.demo.controller.buissinesRules.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.buissinesRules.impl.consts.MaximumVehiclesPerType;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class MaximumVehiclesTest {
	
	@Test
	public void getMaximumVehicles() {
		
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		
		MaximumVehicles maximumVehicles = new MaximumVehicles();
		int totalCars = maximumVehicles.getMaximumVehicles(car);
		int totalMotorcycles = maximumVehicles.getMaximumVehicles(motorcycle);
		
		assertEquals(20,totalCars);
		assertEquals(10,totalMotorcycles);
	}
	
	@Test
	public void isParkingAvailable() {
		
		Integer idCar = 21;
		Integer idMotorcycle = 11;
		
		MaximumVehicles maximumVehicles = new MaximumVehicles();
		boolean carsFull = maximumVehicles.isParkingAvailable(idCar, MaximumVehiclesPerType.CAR.getMaximum());
		boolean motorcyclesFull = maximumVehicles.isParkingAvailable(idMotorcycle, MaximumVehiclesPerType.MOTORCYCLE.getMaximum());
		boolean carsNotFull = maximumVehicles.isParkingAvailable(idCar-1, MaximumVehiclesPerType.CAR.getMaximum());
		boolean motorcyclesNotFull = maximumVehicles.isParkingAvailable(idMotorcycle-1, MaximumVehiclesPerType.MOTORCYCLE.getMaximum());
		
		assertEquals(false,carsFull);
		assertEquals(false,motorcyclesFull);
		assertEquals(true,carsNotFull);
		assertEquals(true,motorcyclesNotFull);
	}

}
