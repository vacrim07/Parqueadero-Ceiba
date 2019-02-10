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
		boolean case1 = testAllowedVehicles.isVehicleAllowed(car);
		boolean case2 = testAllowedVehicles.isVehicleAllowed(motorcycle);
		boolean case3 = testAllowedVehicles.isVehicleAllowed(bike);
		
		assertEquals(true,case1);
		assertEquals(true,case2);
		assertEquals(false,case3);
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
		boolean case1 = testAllowedVehicles.isARestrictedDay(sunday);
		boolean case2 = testAllowedVehicles.isARestrictedDay(monday);
		boolean case3 = testAllowedVehicles.isARestrictedDay(tuesday);
		
		assertEquals(false,case1);
		assertEquals(false,case2);
		assertEquals(true,case3);
	}
	
	@Test
	public void isAnAllowedCar() {
		
		boolean badgeRestricted = true;
		boolean dayRestricted = true;
		
		AllowedVehicles testAllowedVehicles = new AllowedVehicles();
		boolean case1 = testAllowedVehicles.isAnAllowedCar(badgeRestricted, dayRestricted);
		boolean case2 = testAllowedVehicles.isAnAllowedCar(!badgeRestricted, dayRestricted);
		boolean case3 = testAllowedVehicles.isAnAllowedCar(badgeRestricted, !dayRestricted);
		boolean case4 = testAllowedVehicles.isAnAllowedCar(!badgeRestricted, !dayRestricted);
		
		assertEquals(false,case1);
		assertEquals(true,case2);
		assertEquals(true,case3);
		assertEquals(true,case4);
	}
	
	
}
