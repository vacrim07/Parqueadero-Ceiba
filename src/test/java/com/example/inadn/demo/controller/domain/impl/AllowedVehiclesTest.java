package com.example.inadn.demo.controller.domain.impl;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.domain.impl.AllowedVehicles;
import com.example.inadn.demo.controller.domain.impl.consts.BadgeRestriction;
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
	
	@Test
	public void isARestrictedDay() {
		
		Integer sunday = Calendar.SUNDAY;
		Integer monday = Calendar.MONDAY;
		Integer tuesday = Calendar.TUESDAY;
		
		AllowedVehicles testAllowedVehicles = new AllowedVehicles();
		boolean sundayTest = testAllowedVehicles.isARestrictedDay(sunday);
		boolean mondayTest = testAllowedVehicles.isARestrictedDay(monday);
		boolean tuesdayTest = testAllowedVehicles.isARestrictedDay(tuesday);
		
		assertEquals(false,sundayTest);
		assertEquals(false,mondayTest);
		assertEquals(true,tuesdayTest);
	}
	
	@Test
	public void isAnAllowedCar() {
		
		boolean badgeRestricted = true;
		boolean dayRestricted = true;
		
		AllowedVehicles testAllowedVehicles = new AllowedVehicles();
		boolean caseOne = testAllowedVehicles.isAnAllowedCar(badgeRestricted, dayRestricted);
		boolean caseTwo = testAllowedVehicles.isAnAllowedCar(!badgeRestricted, dayRestricted);
		boolean caseThree = testAllowedVehicles.isAnAllowedCar(badgeRestricted, !dayRestricted);
		boolean caseFour = testAllowedVehicles.isAnAllowedCar(!badgeRestricted, !dayRestricted);
		
		assertEquals(false,caseOne);
		assertEquals(true,caseTwo);
		assertEquals(true,caseThree);
		assertEquals(true,caseFour);
	}
	
	
}
