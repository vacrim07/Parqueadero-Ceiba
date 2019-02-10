package com.example.inadn.demo.controller.buissinesRules.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.buissinesRules.impl.consts.BadgeRestriction;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class AllowedVehiclesTest {
	
	@Test
	public void isVehicleAllowed() {
		
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		String bike = "bike";
		
		AllowedVehicles testAllowedVehicles = new AllowedVehicles();
		boolean carTest = testAllowedVehicles.isVehicleAllowed(car);
		boolean motorcycleTest = testAllowedVehicles.isVehicleAllowed(motorcycle);
		boolean bikeTest = testAllowedVehicles.isVehicleAllowed(bike);
		
		assertEquals(true,carTest);
		assertEquals(true,motorcycleTest);
		assertEquals(false,bikeTest);
	}
	
	@Test
	public void isBadgeRestricted() {
		
		String a = BadgeRestriction.A.getRestriction();
		String anotherString = "F";
		
		AllowedVehicles testAllowedVehicles = new AllowedVehicles();
		boolean aTest = testAllowedVehicles.isBadgeRestricted(a);
		boolean anotherStringTest = testAllowedVehicles.isBadgeRestricted(anotherString);
		
		assertEquals(true,aTest);
		assertEquals(false,anotherStringTest);
	}

}
