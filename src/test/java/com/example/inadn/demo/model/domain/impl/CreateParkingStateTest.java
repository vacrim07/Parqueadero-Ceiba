package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;

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
import com.example.inadn.demo.model.domain.impl.mock.ParkingMock;
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
		
		
		// Case 1 : CAR: Parking is full
		Parking p1 = new ParkingMock().getCase1(true);
		// Case 2 : CAR: Restricted by badge, but not by day
		Parking p2 = new ParkingMock().getCase2(true);
		// Case 3 : CAR: Restricted not by badge, restricted by day
		Parking p3 = new ParkingMock().getCase3(true);
		// Case 4 : MOTORCYCLE: Parking is full
		Parking p4 = new ParkingMock().getCase4(true);
		// Case 5 : MOTORCYCLE: With CAR restrictions ---> No problem
		Parking p5 = new ParkingMock().getCase5(true);
		// Case 6 : MOTORCYCLE: OK
		Parking p6 = new ParkingMock().getCase6(true);
		
		CreateParkingState response1 = new CreateParkingState(p1);
		CreateParkingState response2 = new CreateParkingState(p2);
		CreateParkingState response3 = new CreateParkingState(p3);
		CreateParkingState response4 = new CreateParkingState(p4);
		CreateParkingState response5 = new CreateParkingState(p5);
		CreateParkingState response6 = new CreateParkingState(p6);
		
		// Response 1		
		assertEquals(new Integer(20), response1.getMaximumVehicles(VehicleType.CAR.getType()));
		assertEquals(false, response1.isParkingAvailable(p1.getPosition(), response1.getMaximumVehicles(VehicleType.CAR.getType())));
		assertEquals(true, response1.isVehicleRestricted(response1.getParking().getVehicle().getType().getType()));
		assertEquals(false, response1.isBadgeRestricted(response1.getParking().getVehicle().getBadge()));
		assertEquals(false, response1.isARestrictedDay(response1.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.NOT_ALLOWED.getState(), response1.getParking().getState().getState());
		// Response 2
		assertEquals(new Integer(20), response2.getMaximumVehicles(VehicleType.CAR.getType()));
		assertEquals(true, response2.isParkingAvailable(p2.getPosition(), response2.getMaximumVehicles(VehicleType.CAR.getType())));
		assertEquals(true, response2.isVehicleRestricted(response2.getParking().getVehicle().getType().getType()));
		assertEquals(true, response2.isBadgeRestricted(response2.getParking().getVehicle().getBadge()));
		assertEquals(false, response2.isARestrictedDay(response2.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.CHECKED_IN.getState(), response2.getParking().getState().getState());
		// Response 3
		assertEquals(new Integer(20), response3.getMaximumVehicles(VehicleType.CAR.getType()));
		assertEquals(true, response3.isParkingAvailable(p3.getPosition(), response3.getMaximumVehicles(VehicleType.CAR.getType())));
		assertEquals(true, response3.isVehicleRestricted(response3.getParking().getVehicle().getType().getType()));
		assertEquals(true, response3.isBadgeRestricted(response3.getParking().getVehicle().getBadge()));
		assertEquals(true, response3.isARestrictedDay(response3.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.NOT_ALLOWED.getState(), response3.getParking().getState().getState());
		// Response 4
		assertEquals(new Integer(10), response4.getMaximumVehicles(VehicleType.MOTORCYCLE.getType()));
		assertEquals(false, response4.isParkingAvailable(p4.getPosition(), response4.getMaximumVehicles(VehicleType.MOTORCYCLE.getType())));
		assertEquals(false, response4.isVehicleRestricted(response4.getParking().getVehicle().getType().getType()));
		assertEquals(false, response4.isBadgeRestricted(response4.getParking().getVehicle().getBadge()));
		assertEquals(false, response4.isARestrictedDay(response4.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.NOT_ALLOWED.getState(), response4.getParking().getState().getState());
		// Response 5
		assertEquals(new Integer(10), response5.getMaximumVehicles(VehicleType.MOTORCYCLE.getType()));
		assertEquals(true, response5.isParkingAvailable(p5.getPosition(), response5.getMaximumVehicles(VehicleType.MOTORCYCLE.getType())));
		assertEquals(false, response5.isVehicleRestricted(response5.getParking().getVehicle().getType().getType()));
		assertEquals(true, response5.isBadgeRestricted(response5.getParking().getVehicle().getBadge()));
		assertEquals(true, response5.isARestrictedDay(response5.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.CHECKED_IN.getState(), response5.getParking().getState().getState());
		// Response 6
		assertEquals(new Integer(10), response6.getMaximumVehicles(VehicleType.MOTORCYCLE.getType()));
		assertEquals(true, response6.isParkingAvailable(p6.getPosition(), response6.getMaximumVehicles(VehicleType.MOTORCYCLE.getType())));
		assertEquals(false, response6.isVehicleRestricted(response6.getParking().getVehicle().getType().getType()));
		assertEquals(false, response6.isBadgeRestricted(response6.getParking().getVehicle().getBadge()));
		assertEquals(false, response6.isARestrictedDay(response6.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingState.CHECKED_IN.getState(), response6.getParking().getState().getState());
	}
}
