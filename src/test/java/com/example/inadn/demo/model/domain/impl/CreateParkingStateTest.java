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
import com.example.inadn.demo.model.impl.Vehicle;
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
	public void isVehicleRestricted() {
		
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		
		boolean case1 = create.isVehicleRestricted(car);
		boolean case2 = create.isVehicleRestricted(motorcycle);
		
		assertEquals(true,case1);
		assertEquals(false,case2);
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
		Parking p4 = new Parking();
		
		// Response 1 : Parking is full
		Integer position1 = 21;
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setType(VehicleType.CAR);	
		String badge1 = "EGH-761";
		vehicle1.setBadge(badge1);
		GregorianCalendar checkIn1 = new GregorianCalendar(2019,1,10,22,0,0);
		p1.setStartDate(checkIn1);
		p1.setVehicle(vehicle1);
		p1.setPosition(position1);
		
		// Response 2 : CAR Not Restricted
		Integer position2 = 15;
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setType(VehicleType.CAR);	
		String badge2 = "AGH-761";
		vehicle2.setBadge(badge2);
		GregorianCalendar checkIn2 = new GregorianCalendar(2019,1,10,22,0,0);
		p2.setStartDate(checkIn2);
		p2.setVehicle(vehicle2);
		p2.setPosition(position2);
		
		// Response 3 : CAR Restricted by date
		Integer position3 = 15;
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setType(VehicleType.CAR);	
		String badge3 = "AGH-761";
		vehicle3.setBadge(badge3);
		GregorianCalendar checkIn3 = new GregorianCalendar(2019,1,14,22,0,0);
		p3.setStartDate(checkIn3);
		p3.setVehicle(vehicle3);
		p3.setPosition(position3);
		
		// Response 4 : MOTORCYCLE Parking is full
		Integer position4 = 15;
		Vehicle vehicle4 = new Vehicle();
		vehicle4.setType(VehicleType.MOTORCYCLE);	
		String badge4 = "IGH-761";
		vehicle4.setBadge(badge4);
		GregorianCalendar checkIn4 = new GregorianCalendar(2019,1,10,22,0,0);
		p4.setStartDate(checkIn4);
		p4.setVehicle(vehicle4);
		p4.setPosition(position4);
		
		CreateParkingState response1 = new CreateParkingState(p1);
		CreateParkingState response2 = new CreateParkingState(p2);
		CreateParkingState response3 = new CreateParkingState(p3);
		CreateParkingState response4 = new CreateParkingState(p4);
		
		// Response 1
		assertEquals(new Integer(20), response1.getMaximumVehicles(VehicleType.CAR.getType()));
		assertEquals(false, response1.isParkingAvailable(position1, response1.getMaximumVehicles(VehicleType.CAR.getType())));
		assertEquals(true, response1.isVehicleRestricted(response1.getParking().getVehicle().getType().getType()));
		assertEquals(false, response1.isBadgeRestricted(response1.getParking().getVehicle().getBadge()));
		assertEquals(false, response1.isARestrictedDay(response1.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.NOT_ALLOWED.getState(), response1.getParking().getState().getState());
		// Response 2
		assertEquals(new Integer(20), response2.getMaximumVehicles(VehicleType.CAR.getType()));
		assertEquals(true, response2.isParkingAvailable(position2, response2.getMaximumVehicles(VehicleType.CAR.getType())));
		assertEquals(true, response2.isVehicleRestricted(response2.getParking().getVehicle().getType().getType()));
		assertEquals(true, response2.isBadgeRestricted(response2.getParking().getVehicle().getBadge()));
		assertEquals(false, response2.isARestrictedDay(response2.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.CHECKED_IN.getState(), response2.getParking().getState().getState());
		// Response 3
		assertEquals(new Integer(20), response3.getMaximumVehicles(VehicleType.CAR.getType()));
		assertEquals(true, response3.isParkingAvailable(position3, response3.getMaximumVehicles(VehicleType.CAR.getType())));
		assertEquals(true, response3.isVehicleRestricted(response3.getParking().getVehicle().getType().getType()));
		assertEquals(true, response3.isBadgeRestricted(response3.getParking().getVehicle().getBadge()));
		assertEquals(true, response3.isARestrictedDay(response3.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.NOT_ALLOWED.getState(), response3.getParking().getState().getState());
		// Response 4
		assertEquals(new Integer(10), response4.getMaximumVehicles(VehicleType.MOTORCYCLE.getType()));
		assertEquals(false, response4.isParkingAvailable(position4, response4.getMaximumVehicles(VehicleType.CAR.getType())));
		assertEquals(false, response4.isVehicleRestricted(response4.getParking().getVehicle().getType().getType()));
		assertEquals(false, response4.isBadgeRestricted(response4.getParking().getVehicle().getBadge()));
		assertEquals(false, response4.isARestrictedDay(response4.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.NOT_ALLOWED.getState(), response4.getParking().getState().getState());
	}
}
