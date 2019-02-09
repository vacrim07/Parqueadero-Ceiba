package com.example.inadn.demo.controller.buissinesRules.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.buissinesRules.impl.*;
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

}
