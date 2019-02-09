package com.example.inadn.demo.controller.buissinesRules.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.buissinesRules.impl.*;
import com.example.inadn.demo.controller.buissinesRules.impl.consts.MaximumVehicles;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class CheckMethodsTest {
	
	@Test
	public void getMaximumVehicles() {
		
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		
		CheckMethods testCheckMethods = new CheckMethods();
		int totalCars = testCheckMethods.getMaximumVehicles(car);
		int totalMotorcycles = testCheckMethods.getMaximumVehicles(motorcycle);
		
		assertEquals(20,totalCars);
		assertEquals(10,totalMotorcycles);
	}
	
	@Test
	public void isParkingAvailable() {
		
		Integer idCar = 21;
		Integer idMotorcycle = 11;
		
		CheckMethods testCheckMethods = new CheckMethods();
		boolean carsFull = testCheckMethods.isParkingAvailable(idCar, MaximumVehicles.CAR.getMaximum());
		boolean motorcyclesFull = testCheckMethods.isParkingAvailable(idMotorcycle, MaximumVehicles.MOTORCYCLE.getMaximum());
		boolean carsNotFull = testCheckMethods.isParkingAvailable(idCar-1, MaximumVehicles.CAR.getMaximum());
		boolean motorcyclesNotFull = testCheckMethods.isParkingAvailable(idMotorcycle-1, MaximumVehicles.MOTORCYCLE.getMaximum());
		
		assertEquals(false,carsFull);
		assertEquals(false,motorcyclesFull);
		assertEquals(true,carsNotFull);
		assertEquals(true,motorcyclesNotFull);
	}

}
