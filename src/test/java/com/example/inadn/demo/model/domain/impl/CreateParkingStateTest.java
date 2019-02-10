package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.domain.impl.consts.MaximumVehiclesPerType;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class CreateParkingStateTest {
	
	Parking p;
	CreateParkingState create;
	
	@Before
	public void setUp() {
		p = new Parking();
		create = new CreateParkingState();
	}
	
	@Test
	public void getMaximumVehicles() {
		
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
	
		Integer case1 = create.getMaximumVehicles(car);
		Integer case2 = create.getMaximumVehicles(motorcycle);
		
		assertEquals(new Integer(20),case1);
		assertEquals(new Integer(10),case2);
	}
	
	@Test
	public void isParkingAvailable() {
		
		Integer positionCar = 21;
		Integer positionMotorcycle = 11;
		
		boolean case1 = create.isParkingAvailable(positionCar, MaximumVehiclesPerType.CAR.getMaximum());
		boolean case2 = create.isParkingAvailable(positionMotorcycle, MaximumVehiclesPerType.MOTORCYCLE.getMaximum());
		boolean case3 = create.isParkingAvailable(positionCar-1, MaximumVehiclesPerType.CAR.getMaximum());
		boolean case4 = create.isParkingAvailable(positionMotorcycle-1, MaximumVehiclesPerType.MOTORCYCLE.getMaximum());
		
		assertEquals(false,case1);
		assertEquals(false,case2);
		assertEquals(true,case3);
		assertEquals(true,case4);
	}
	
	@Test
	public void isVehicleAllowed() {
		
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		String bike = "bike";
		
		boolean case1 = create.isVehicleAllowed(car);
		boolean case2 = create.isVehicleAllowed(motorcycle);
		boolean case3 = create.isVehicleAllowed(bike);
		
		assertEquals(true,case1);
		assertEquals(true,case2);
		assertEquals(false,case3);
	}
	
	@Test
	public void isBadgeRestricted() {
		
		String badge1 = "AFG-754";
		String badge2 = "FTM-921";
		
		boolean case1 = create.isBadgeRestricted(badge1);
		boolean case2 = create.isBadgeRestricted(badge2);
		
		assertEquals(true,case1);
		assertEquals(false,case2);
	}
	
	@Test
	public void isARestrictedDay() {
		
		Integer sunday = Calendar.SUNDAY;
		Integer monday = Calendar.MONDAY;
		Integer tuesday = Calendar.TUESDAY;
		
		boolean case1 = create.isARestrictedDay(sunday);
		boolean case2 = create.isARestrictedDay(monday);
		boolean case3 = create.isARestrictedDay(tuesday);
		
		assertEquals(false,case1);
		assertEquals(false,case2);
		assertEquals(true,case3);
	}
	
	@Test
	public void isAnAllowedCar() {
		
		boolean badgeRestricted = true;
		boolean dayRestricted = true;
		
		boolean case1 = create.isAnAllowedCar(badgeRestricted, dayRestricted);
		boolean case2 = create.isAnAllowedCar(!badgeRestricted, dayRestricted);
		boolean case3 = create.isAnAllowedCar(badgeRestricted, !dayRestricted);
		boolean case4 = create.isAnAllowedCar(!badgeRestricted, !dayRestricted);
		
		assertEquals(false,case1);
		assertEquals(true,case2);
		assertEquals(true,case3);
		assertEquals(true,case4);
	}
}
