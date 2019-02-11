package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.domain.impl.consts.MaximumVehiclesPerType;
import com.example.inadn.demo.model.impl.Motorcycle;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingState;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class CreateParkingStateTest {
	
	CreateParkingState create;
	
	@Before
	public void setUp() {
		create = new CreateParkingState();
	}
	
	@After
	public void stop() {
		create = null;
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
	
	@Test
	public void modifyParkingStatusResponse() {
		
		Parking p1 = new Parking();
		Parking p2 = new Parking();
		Parking p3 = new Parking();
		
		// Response 1 : CAR
		Integer position1 = 21;
//		Integer engineCapacity1 = 0;
//		GregorianCalendar checkIn1 = new GregorianCalendar(2019,0,31,22,0,0);
//		GregorianCalendar checkOut1 = new GregorianCalendar(2019,1,2,1,0,0);
//		Motorcycle vehicle1 = new Motorcycle();
//		vehicle1.setEngineCapacity(engineCapacity1);
//		vehicle1.setType(VehicleType.CAR);
//		p1.setVehicle(vehicle1);
//		p1.setPosition(position1);
//		p1.setStartDate(checkIn1);
//		p1.setEndDate(checkOut1);
		
		// Response 2 : MOTORCYCLE > 500 CC
//		Integer position2 = 6;
//		Integer engineCapacity2 = 650;
//		GregorianCalendar checkIn2 = new GregorianCalendar(2019,1,2,2,0,0);
//		GregorianCalendar checkOut2 = new GregorianCalendar(2019,1,2,12,0,0);
//		Motorcycle vehicle2 = new Motorcycle();
//		vehicle2.setEngineCapacity(engineCapacity2);
//		vehicle2.setType(VehicleType.MOTORCYCLE);
//		p2.setVehicle(vehicle2);
//		p2.setPosition(position2);
//		p2.setStartDate(checkIn2);
//		p2.setEndDate(checkOut2);
		
		// Response 3 : MOTORCYCLE < 500 CC
//		Integer position3 = 1;
//		Integer engineCapacity3 = 150;
//		GregorianCalendar checkIn3 = new GregorianCalendar(2018,11,31,20,0,0);
//		GregorianCalendar checkOut3 = new GregorianCalendar(2019,0,2,20,59,59);
//		Motorcycle vehicle3 = new Motorcycle();
//		vehicle3.setEngineCapacity(engineCapacity3);
//		vehicle3.setType(VehicleType.MOTORCYCLE);
//		p3.setVehicle(vehicle3);
//		p3.setPosition(position3);
//		p3.setStartDate(checkIn3);
//		p3.setEndDate(checkOut3);
		
		
		
		CreateParkingState response1 = new CreateParkingState(p1);
		
		// Response 1
		assertEquals(new Integer(20), response1.getMaximumVehicles(VehicleType.CAR.getType()));
		assertEquals(false, response1.isParkingAvailable(position1, response1.getMaximumVehicles(VehicleType.CAR.getType())));
		assertEquals(ParkingState.NOT_ALLOWED.getState(), response1.getParking().getState().getState());
	}
}
